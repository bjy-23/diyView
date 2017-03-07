package com.example.bjy.diyview.view;

import android.content.Context;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.widget.LinearLayout;

/**
 * Created by bjy on 2016/12/13.
 */

public class MyLinearLayout extends LinearLayout {
    private Context context;
    public MyLinearLayout(Context context) {
        super(context);
        init(context);
    }

    public MyLinearLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public MyLinearLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    public void init(Context context){
        this.context = context;
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        return true;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Log.e("","onInterceptTouchEvent");
        super.onInterceptTouchEvent(ev);
        return true;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getAction()& MotionEvent.ACTION_MASK){
            case MotionEvent.ACTION_POINTER_DOWN:
                float x = event.getX(0) - event.getX(1);
                float y = event.getY(0) - event.getY(1);

                break;
            case MotionEvent.ACTION_UP:
                Log.e("up","up");
                break;
        }


//        VelocityTracker velocityTracker = VelocityTracker.obtain();
//        velocityTracker.addMovement(event);
//        int pointId = 0;
//        switch (event.getAction()){
//            case MotionEvent.ACTION_DOWN:
////                pointId = event.getPointerId(0);
//            case MotionEvent.ACTION_MOVE:
//                velocityTracker.computeCurrentVelocity(1000);
//                int vx = (int) velocityTracker.getXVelocity();
//                int vy = (int) velocityTracker.getYVelocity();
//                Log.e("vx",vx+"");
//                Log.e("vy",vy+"");
//                break;
//            case MotionEvent.ACTION_UP:
//                if(velocityTracker!=null){
//                    velocityTracker.clear();
//                    velocityTracker.recycle();
//                }
//        }

        return true;
    }

}
