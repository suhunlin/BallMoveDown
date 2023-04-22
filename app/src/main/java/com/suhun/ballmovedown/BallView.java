package com.suhun.ballmovedown;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

public class BallView extends View {
    private String tag = BallView.class.getSimpleName();
    private Resources res;
    private Bitmap bmpball;
    private boolean isInitBallInfo;
    private int scalingRatio, ballW, ballH;
    private float ballX, ballY;
    public BallView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        res = context.getResources();
        setBackgroundResource(R.drawable.bg);
    }

    private void initBallInfo(){
        double scalingRatio = 12.0f;
        int viewW = getWidth();
        bmpball = BitmapFactory.decodeResource(res, R.drawable.ball1);
        setScalingRatio(scalingRatio);
        bmpball = Bitmap.createScaledBitmap(bmpball, ballW, ballH, false);
        isInitBallInfo = true;
    }

    private void setScalingRatio(double ratio){
        ballW = (int)(getWidth() / ratio);
        ballH = ballW;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if(!isInitBallInfo){
            initBallInfo();
        }
        canvas.drawBitmap(bmpball, ballX, ballY, null);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        ballX = event.getX();
        ballY = event.getY();
        postInvalidate();
        return true;
    }
}
