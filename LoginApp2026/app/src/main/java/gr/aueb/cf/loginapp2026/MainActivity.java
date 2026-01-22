package gr.aueb.cf.loginapp2026;

import android.content.Intent;
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
    private EditText usernameText, passwordText;
    private Button loginBtn;
    private TextView questionTV, registerTV;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usernameText = findViewById(R.id.usernameText);
        passwordText = findViewById(R.id.passwordText);
        loginBtn = findViewById(R.id.loginBtn);
        questionTV = findViewById(R.id.questionTV);
        registerTV = findViewById(R.id.registerTV);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameText.getText().toString().trim();
                String password = passwordText.getText().toString();

                if (username.isEmpty()) {
                    usernameText.setError("Username is required");
                } else if (password.isEmpty()) {
                    passwordText.setError("Password is required");
                } else if (username.equals("admin") && password.equals("12345")) {
                    // TODO: Intent sends user to the SecretActivity
                    Intent intent = new Intent(MainActivity.this, SecretActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(MainActivity.this, "Invalid credentials", Toast.LENGTH_SHORT).show();
                    usernameText.setText("");
                    passwordText.setText("");
                }

            }
        });

    }
}