package gr.aueb.cf.kilotopoundconvertapp;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {
    private EditText kiloET;

    private TextView convPoundTV;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        MaterialButton convertBtn = findViewById(R.id.convertBtn);
        kiloET = findViewById(R.id.kiloET);
        convPoundTV = findViewById(R.id.convPoundTV);

        convertBtn.setOnClickListener(new View.OnClickListener()  {

            @Override
            public void onClick(View v) {
                String input = kiloET.getText().toString();

                if (!input.isEmpty()){
                    try {
                        float kilo = Float.parseFloat(input); //convert the string to float
                        float pound = kilo * 2.20462f;

                        String poundString = String.format("%.2f", pound);
                        convPoundTV.setText(poundString);

                        kiloET.setError(null);
                    } catch (NumberFormatException e) {
                        kiloET.setError("Invalid Input, give a number");
                    }
                } else {
                    kiloET.setError("Field cannot be empty");
                }
            }
        });

    }
}