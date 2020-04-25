package edu.sdsmt.kopp_riley.adventurekoppriley;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

public class GameView extends View {


    public GameView(Context context) {
        super(context);
        this.setBackgroundColor(Color.GRAY);
    }

    public GameView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.setBackgroundColor(Color.GRAY);
    }

    public GameView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.setBackgroundColor(Color.GRAY);
    }

    public GameView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        this.setBackgroundColor(Color.GRAY);
    }

    public void setPlayerShape(PlayerShape newShape) {

    }
}
