/*
 * Copyright (c) 2024. Noor Azwani binti Mustaffa Kamal
 */

package individual.assignment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnCalculate, btnClear;
    EditText etNumUnits, etPercentage;
    TextView textView;

    //Change 1



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        etNumUnits = findViewById(R.id.etNumUnits);
        etPercentage = findViewById(R.id.etPercentage);
        btnCalculate = findViewById(R.id.btnCalculate);
        btnClear = findViewById(R.id.btnClear);
        textView = findViewById(R.id.textView);

        btnCalculate.setOnClickListener(v -> calculateBill());
        btnClear.setOnClickListener(this);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
    }

    @Override
    public void onClick(View view) {
        if (view == btnClear) {
            clearFields();
        }
    }

    @SuppressLint("SetText18n")
    private void calculateBill() {
        String unitsUsedString = etNumUnits.getText().toString();
        String rebatePercentageString = etPercentage.getText().toString();

        if (unitsUsedString.isEmpty() || rebatePercentageString.isEmpty()) {
            textView.setText("Please Enter Valid Values!");
            return;
        }

        double unitsUsed = Double.parseDouble(unitsUsedString);
        double rebatePercentage = Double.parseDouble(rebatePercentageString) / 100;

        double totalCharges = calculateCharges(unitsUsed);
        double finalCost = totalCharges - (totalCharges * rebatePercentage);

        //Use String.format() to display the result with 2 decimal places
        String result = String.format("Total Final Cost : RM %.2f", finalCost);
        textView.setText(result);
    }

    private double calculateCharges(double unitsUsed) {
        double totalCharges = 0.0;

        if (unitsUsed <= 200) {
            totalCharges = unitsUsed * 0.218;
        } else if (unitsUsed <= 300) {
            totalCharges = 200 * 0.218 + (unitsUsed - 200) * 0.334;
        } else if (unitsUsed <= 600) {
            totalCharges = 200 * 0.218 + 100 * 0.334 + (unitsUsed - 300) * 0.516;
        } else if (unitsUsed > 600) {
            totalCharges = 200 * 0.218 + 100 * 0.334 + 300 * 0.516 + (unitsUsed - 600) * 0.546;
        }

        return totalCharges;

    }

    private void clearFields() {
        etNumUnits.setText("");
        etPercentage.setText("");
        textView.setText("Total Final Cost : RM 0");
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
       MenuInflater inflater = getMenuInflater();
     inflater.inflate(R.menu.menu, menu);
   return true;
  }
  
  @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==R.id.menuAbout)
        {
           Intent intent = new Intent(this,MainActivity2.class);
           startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
  }
}