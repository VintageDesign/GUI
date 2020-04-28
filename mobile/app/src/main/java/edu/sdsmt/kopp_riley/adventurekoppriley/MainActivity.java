package edu.sdsmt.kopp_riley.adventurekoppriley;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.TextView;

/***********************************************************************************************
 * @author  Riley Kopp
 * Descripton:
 * The entry point of the Mobile program. For more information see the assignment on D2L for
 * a full description of the program.
 *
 * Last Tier Completed: all of them
 * Extensions Completed:
 * +10 Win is a view
 * +5  Motion Changes direction
 *
 * Known Bugs:
 * None... I cleaned this tank thouroughly
 **********************************************************************************************/



public class MainActivity extends AppCompatActivity {
    private boolean isFABOpen = false;
    private View circlePlayer;
    private View squarePlayer;
    private Thread scoreThread;
    Integer time = 0;
    String score;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.circlePlayer = findViewById(R.id.circleButton);
        this.squarePlayer = findViewById(R.id.squareButton);
        scoreThread = new Thread() {
            @Override
            public void run() {

                try {
                    while(!scoreThread.isInterrupted()){
                        Thread.sleep(1000);

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                time += 1;
                                score = "Score: " + time;
                                ((TextView)findViewById(R.id.Score)).setText(score);
                            }
                        });
                    }
                } catch (InterruptedException e) {

                }

            }
        };
        scoreThread.start();

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        GameView gv = ((GameView) findViewById(R.id.playField));

        boolean vis = this.isFABOpen;
        PlayerShape playerShape = gv.playerShape;
        int shape = 0;
        if(playerShape == PlayerShape.CIRCLE)
        {
            shape = 1;
        }

        boolean blue = gv.stateMachine.getBlue();
        String room;
        State cur = gv.stateMachine.getState();
        if (cur.getColor() == Color.RED) {
            room = "red";
        } else if (cur.getColor() == Color.BLUE) {
            room = "blue";
        } else {
            room = "grey";
        }
        outState.putInt("score", time);
        outState.putBoolean("vis", vis);
        outState.putInt("shape", shape);
        outState.putBoolean("guard", blue);
        outState.putString("room", room);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        GameView gv = ((GameView) findViewById(R.id.playField));
        super.onRestoreInstanceState(savedInstanceState);
        time = savedInstanceState.getInt("score");
        boolean vis = savedInstanceState.getBoolean("vis");
        Integer shape = savedInstanceState.getInt("shape");
        boolean blue = savedInstanceState.getBoolean("guard");
        String room = savedInstanceState.getString("room");
        this.score = score;
        this.isFABOpen = vis;
        if(vis){
            showFABMenu();
        }
        else{
            closeFABMenu();
        }

        if(shape == 0){ // Square
            gv.setPlayerShape(PlayerShape.SQUARE);
        }
        else {
            gv.setPlayerShape(PlayerShape.CIRCLE);
        }


        gv.stateMachine.setBlue(blue);


        if (room.equals("red")) {
            gv.stateMachine.setCurrentState(new StateRed());
            gv.forceBackground(new StateRed().getColor());
        } else if (room.equals("blue")) {
            gv.stateMachine.setCurrentState(new StateBlue());
            gv.forceBackground(new StateBlue().getColor());
        } else {
            gv.stateMachine.setCurrentState(new StateGrey());
            gv.forceBackground(new StateGrey().getColor());
        }

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

    public void onWin(){
        //GRADING: EXIT
        scoreThread.interrupt();
        String finalScore = (String) ((TextView)findViewById(R.id.Score)).getText();
        Intent i = new Intent(this, WinActivity.class);

        Bundle extras = new Bundle();
        extras.putString("score", finalScore);
        i.putExtras(extras);

        startActivity(i);
    }
}