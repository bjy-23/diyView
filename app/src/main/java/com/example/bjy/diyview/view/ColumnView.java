package com.example.bjy.diyview.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

/**
 * Created by bjy on 2016/11/29.
 */

public class ColumnView extends LinearLayout {
    private Paint paint;

    public ColumnView(Context context) {
        super(context);

        paint = new Paint();
        paint.setColor(Color.BLUE);
    }

    public ColumnView(Context context, AttributeSet attrs) {
        super(context, attrs);

        paint = new Paint();
        paint.setColor(Color.BLUE);
    }

    public ColumnView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        paint = new Paint();
        paint.setColor(Color.BLUE);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for (int i=0;i<5;i++){
            canvas.drawRect(100+50*i,100,130+50*i,300,paint);
        }
    }
}
