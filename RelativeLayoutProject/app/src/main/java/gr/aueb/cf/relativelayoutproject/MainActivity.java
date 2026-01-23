package gr.aueb.cf.relativelayoutproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private ScrollView scrollView;
    private CheckBox athensCB, patraCB;
    private RadioGroup agreeRG;
    private RatingBar likeRB;
    private SeekBar ageSB;
    private Switch switchBtn;
    private Button submitBtn;
    private TextView seekBarTV;
    private String ratingStars, age;
    private RelativeLayout main;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        scrollView = findViewById(R.id.scrollView);
        athensCB = findViewById(R.id.athensCB);
        patraCB = findViewById(R.id.patraCB);
        agreeRG = findViewById(R.id.agreeRG);
        likeRB = findViewById(R.id.likeRB);
        ageSB = findViewById(R.id.ageSB);
        switchBtn = findViewById(R.id.switchBtn);
        submitBtn = findViewById(R.id.submitBtn);
        seekBarTV = findViewById(R.id.seekBarTV);
        main = findViewById(R.id.main);


        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("rating", ratingStars);
                intent.putExtra("age", age);
                startActivity(intent);
                finish();
            }
        });

        likeRB.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                ratingStars = String.valueOf(rating);
                Toast.makeText(MainActivity.this, "Rating: " + ratingStars, Toast.LENGTH_SHORT).show();
            }
        });

        ageSB.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                age = String.valueOf(progress);
                seekBarTV.setText("Set your age (allowed 18 to 75): " + age);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        switchBtn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(@NonNull CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    switchBtn.setText("dark");
                    scrollView.setBackgroundColor(getColor(R.color.blue_03));
                    main.setBackgroundColor(getColor(R.color.blue_02));
                } else {
                    switchBtn.setText("light");
                    scrollView.setBackgroundColor(getColor(R.color.blue_02));
                    main.setBackgroundColor(getColor(R.color.blue_01));
                }
            }
        });
    }
}