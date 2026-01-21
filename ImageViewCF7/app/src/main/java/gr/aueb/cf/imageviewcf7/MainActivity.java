package gr.aueb.cf.imageviewcf7;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ImageView imageIV;
    private Button rollButton;
    private TextView descriptionIV, referencesIV;

    private int[] imageIds = {
            R.drawable.mountain,
            R.drawable.sea,
            R.drawable.sky
    };

    private String[] imageDescriptions = {
            "Golf in the mountains.",
            "Golf by the sea.",
            "Golf in the sky and fly."
    };

    private String[] imageReferences = {
            "<a href=\"https://www.flaticon.com/free-stickers/sports-and-competition\" title=\"sports and competition stickers\">Sports and competition stickers created by Stickers - Flaticon</a>",
            "<a href=\"https://www.flaticon.com/free-stickers/sports-and-competition\" title=\"sports and competition stickers\">Sports and competition stickers created by Stickers - Flaticon</a>",
            "<a href=\"https://www.flaticon.com/free-stickers/sports-and-competition\" title=\"sports and competition stickers\">Sports and competition stickers created by Stickers - Flaticon</a>"
    };

    private Random random = new Random();


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

        imageIV = findViewById(R.id.imageIV);
        rollButton = findViewById(R.id.rollButton);
        descriptionIV = findViewById(R.id.descriptionIV);
        referencesIV = findViewById(R.id.referencesIV);


        rollButton.setOnClickListener(v -> showRandomImage());

    }

    private void showRandomImage() {
        int randomIndex = random.nextInt(imageIds.length);
        imageIV.setImageResource(imageIds[randomIndex]);
        descriptionIV.setText(imageDescriptions[randomIndex]);
        referencesIV.setText(imageReferences[randomIndex]);

    }

}