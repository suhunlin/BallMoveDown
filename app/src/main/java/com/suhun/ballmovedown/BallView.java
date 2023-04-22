package com.suhun.ballmovedown;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class BallView extends View {
    private String tag = BallView.class.getSimpleName();
    private Resources res;
    private Bitmap bmpball;
    public BallView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        res = context.getResources();
        setBackgroundResource(R.drawable.bg);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        bmpball = BitmapFactory.decodeResource(res, R.drawable.ball1);
        canvas.drawBitmap(bmpball, 0, 0, null);
    }
}
