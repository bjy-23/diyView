package com.example.bjy.diyview.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by bjy on 2016/12/19.
 */

public class CircleView extends View {
    private int mWidth,mHeight = 200;
    private int mColor = Color.RED;
    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    public CircleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public CircleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CircleView(Context context) {
        super(context);
        init();
    }

    private void init(){
        mPaint.setColor(mColor);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int widthSpecMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSpecSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSpecMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSpecSize = MeasureSpec.getSize(heightMeasureSpec);
        if (widthSpecMode==MeasureSpec.AT_MOST && heightSpecMode==MeasureSpec.AT_MOST){
            setMeasuredDimension(mWidth,mHeight);
        }else if (widthSpecMode==MeasureSpec.AT_MOST){
            setMeasuredDimension(mWidth,heightSpecSize);
        }else if (heightSpecMode==MeasureSpec.AT_MOST){
            setMeasuredDimension(widthSpecSize,mHeight);
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = getWidth();
        int height = getHeight();
        int radius = Math.min(width,height) / 2;
        canvas.drawCircle(width/2,height/2,radius,mPaint);
    }
}
