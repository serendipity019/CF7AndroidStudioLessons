package gr.aueb.cf.relativelayoutproject;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SecondActivity extends AppCompatActivity {

    private EditText siteET;
    private final String SHARED_PREF = "sharedPrefs";
    private final String URL = "url";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        TextView rateTV = findViewById(R.id.rateTV);
        TextView ageTV = findViewById(R.id.ageTV);
        siteET = findViewById(R.id.siteET);
        Button navBtn = findViewById(R.id.navBtn);

        String rating = getIntent().getStringExtra("rating");
        String age = getIntent().getStringExtra("age");

        rateTV.setText("Rating: " + rating);
        ageTV.setText("Age: " + age);

        loadUrl();

        navBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = siteET.getText().toString().trim();
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intent);
                saveUrl(url);
            }
        });

    }

    private void saveUrl(String url) {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREF, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(URL, url);
        editor.apply();
    }

    private void loadUrl() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREF, MODE_PRIVATE);
        String MyUrl = sharedPreferences.getString(URL, "");
        siteET.setText(MyUrl);
    }
}