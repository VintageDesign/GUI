package edu.sdsmt.kopp_riley.adventurekoppriley;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
public class MainActivity extends AppCompatActivity {
    private boolean isFABOpen = false;
    private View circlePlayer;
    private View squarePlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.circlePlayer = findViewById(R.id.circleButton);
        this.squarePlayer = findViewById(R.id.squareButton);
    }
    public void setPlayerCircle(View view) {
        ((GameView) findViewById(R.id.playField)).setPlayerShape(PlayerShape.CIRCLE);
    }
    public void setPlayerSquare(View view) {
        ((GameView) findViewById(R.id.playField)).setPlayerShape(PlayerShape.SQUARE);
    }
    private float DpToPixels(float dp) {
        float pxPerDp = (float) getResources().getDisplayMetrics().densityDpi;
        pxPerDp = pxPerDp / DisplayMetrics.DENSITY_DEFAULT;
        return dp * pxPerDp;
    }
    public void onBurst(View view) {
        if (!isFABOpen) {
            showFABMenu();
        } else {
            closeFABMenu();
        }
    }
    private void showFABMenu() {
        isFABOpen = true;
        circlePlayer.animate().translationX(DpToPixels(-60));
        squarePlayer.animate().translationX(DpToPixels(-120));
        circlePlayer.setElevation(15);
        squarePlayer.setElevation(15);
    }
    private void closeFABMenu() {
        isFABOpen = false;
        circlePlayer.animate().translationX(0);
        squarePlayer.animate().translationX(0);
        circlePlayer.setElevation(0);
        squarePlayer.setElevation(0);
    }
}