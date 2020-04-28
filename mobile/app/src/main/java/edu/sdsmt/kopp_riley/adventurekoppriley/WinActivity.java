package edu.sdsmt.kopp_riley.adventurekoppriley;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

// GRADING: EXTENSION
public class WinActivity extends AppCompatActivity {
    String score;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.win_port);
        Intent i = this.getIntent();
        Bundle b = i.getExtras();
        score = b.getString("score");
        TextView scoreText = findViewById(R.id.score);
        scoreText.setText(score);
    }
}
