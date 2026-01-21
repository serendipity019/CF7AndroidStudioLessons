package gr.aueb.cf.basicwidgetscf7;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private TextView myTextView;
    private Button myButton;
    private EditText myEditText;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // We find the Textview element from XML file with the id: my_textView
        // and we assign it to the myTextView variable
        myTextView = findViewById(R.id.my_textView);
        myButton = findViewById(R.id.my_button);
        myEditText = findViewById(R.id.my_editText);


        // We set a click listener to the button
        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(MainActivity.this, "Button clicked!", Toast.LENGTH_LONG).show();
                //myTextView.setText("Hello CF7!"); // We use setText method from TextView class to change the content of the TextView
                String name = myEditText.getText().toString().trim();
                myTextView.setText("Hello" + name + "!");

            }
        });
    }

//    public void changeText(View view) {
//        // We use setText method from TextView class to change the content of the TextView
//        myTextView.setText("Hello CF7!");
//    }
}