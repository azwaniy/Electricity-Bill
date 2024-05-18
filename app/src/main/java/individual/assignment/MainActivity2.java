package individual.assignment;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity implements View.OnClickListener {

    Button btnBack;

    TextView tvClickLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        // Initialize btnBack and set OnClickListener
        btnBack = findViewById(R.id.btnBack);
        tvClickLink = findViewById(R.id.tvClickLink);
        tvClickLink.setMovementMethod(LinkMovementMethod.getInstance());
        btnBack.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        // Handle button click event
        if (v.getId() == R.id.btnBack) {
            // Create an Intent to go back to MainActivity
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent); // Start MainActivity
            finish(); // Close the current activity (MainActivity2)
        }
    }
}