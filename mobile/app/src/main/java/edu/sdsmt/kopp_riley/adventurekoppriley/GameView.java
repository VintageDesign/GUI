package edu.sdsmt.kopp_riley.adventurekoppriley;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;
public class GameView extends View {



    int backgroundColor;
    private float widthX;
    private float centerX;
    private float centerY;
    private float playerX = -1;
    private float playerY = -1;
    int playerColor = Color.BLACK;
    private boolean circlePlayer;
    private boolean measured = false;
    Canvas canvas;
    Paint painter;
    Thread anim;
    MainActivity m;
    private float x1,x2;
    static final int MIN_DISTANCE = 50;
    private int delay = 10;
    private int distance = 2;
    float left;
    float right;
    float top;
    float bottom;

    PlayerShape playerShape;
    StateMachine stateMachine;

    public GameView(Context context) {
        super(context);
        init();
    }
    public GameView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }
    public GameView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }
    public GameView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }
    private void init() {
        stateMachine = new StateMachine();
        setupPainter();
        backgroundColor = Color.GRAY;
        playerShape = PlayerShape.CIRCLE;
        m = (MainActivity) getContext();


    }
    private void setupPainter()
    {
        painter = new Paint();
        painter.setColor(playerColor);
        painter.setAntiAlias(true);
        painter.setStrokeWidth(4);
        painter.setStyle(Paint.Style.FILL_AND_STROKE);
        painter.setStrokeJoin(Paint.Join.ROUND);
        painter.setStrokeCap(Paint.Cap.ROUND);
        canvas = new Canvas();

    }
    public void setPlayerShape(PlayerShape shape) {
        this.playerShape = shape;
        invalidate();
    }
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        if (!measured) {
            this.centerX = (this.getWidth()) / 2;
            this.centerY = (this.getHeight()) / 2;
            this.widthX = this.getWidth();


            if (playerX != 0 && centerX != 0) {
                playerX = centerX;
                playerY = centerY;
                measured = true;
                invalidate();
            }
        }

    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        setBackgroundColor(backgroundColor);
        if (playerShape == PlayerShape.CIRCLE) {
            canvas.drawCircle(playerX, playerY, 20, painter);
        } else {
            left = playerX - 20;
            right = playerX + 20;
            top = playerY - 20;
            bottom = playerY + 20;
            canvas.drawRect(left, top, right, bottom, painter);
        }
    }

    @Override
    public boolean performClick(){
        return super.performClick();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        // GRADING: EXTENSION 2b
        if (anim != null) {
            if (anim.isAlive()) {
                anim.interrupt();
            }
        }
        switch(event.getAction())
        {
            case MotionEvent.ACTION_DOWN:
                x1 = event.getX();

                return true;
            case MotionEvent.ACTION_UP:
                x2 = event.getX();
                float deltaX = x2 - x1;

                if (Math.abs(deltaX) > MIN_DISTANCE && deltaX > 0)
                {

                    travelAnimate(true);
                } else if (Math.abs(deltaX) > MIN_DISTANCE && deltaX < 0) {

                    travelAnimate(false);
                }
                else
                {

                    if (x1 > centerX) {
                        travelAnimate(true);
                    } else {
                        travelAnimate(false);
                    }
                }
                break;
        }
        performClick();
        return super.onTouchEvent(event);
    }

    private void travelAnimate(boolean right) {
        if (right) {
            anim = new Thread() {
                @Override
                public void run() {
                    try {
                        while (!anim.isInterrupted() && playerX <= widthX) {
                            Thread.sleep(delay);
                            m.runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    playerX += distance;
                                    invalidate();
                                }
                            });
                        }
                        //GRADING: TRANSITION
                        setGame(stateMachine.setState(Edge.Right));
                    } catch (InterruptedException e) {
                    }

                }
            };
        } else {
            anim = new Thread() {
                @Override
                public void run() {
                    try {
                        while (!anim.isInterrupted() && playerX > 0) {
                            Thread.sleep(delay);
                            m.runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    playerX -= distance;
                                    invalidate();
                                }
                            });
                        }
                        // GRADING: TRANSITION
                        setGame(stateMachine.setState(Edge.Left));
                    } catch (InterruptedException e) {
                    }


                }
            };
        }
        anim.start();
    }
    public void setGame(State room) {
        //GRADING: ROOM
        int roomColor = room.getColor();
        Boolean win = stateMachine.checkWin();
        if (win == false) {

            playerX = centerX;
            playerY = centerY;
            backgroundColor = roomColor;
            invalidate();
        }
        else{
            m.onWin();
        }
    }

    public void forceBackground(int color)
    {
        backgroundColor = color;
        invalidate();
    }


}