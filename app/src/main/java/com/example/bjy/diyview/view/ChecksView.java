package com.example.bjy.diyview.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.LinearLayout;

/**
 * Created by bjy on 2017/2/6.
 */

public class ChecksView extends LinearLayout {

    public ChecksView(Context context) {
        super(context);
    }

    public ChecksView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ChecksView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.e("dispatch","1");
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Log.e("intercept","2");
        return super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.e("touch","3");
        return super.onTouchEvent(event);
    }
}
