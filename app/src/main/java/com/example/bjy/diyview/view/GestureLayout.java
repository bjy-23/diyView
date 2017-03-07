package com.example.bjy.diyview.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.RelativeLayout;

/**
 * Created by bjy on 2016/12/14.
 */

public class GestureLayout extends RelativeLayout implements GestureDetector.OnGestureListener,GestureDetector.OnDoubleTapListener{
    private Context context;
    private GestureDetector gestureDetector;
    public GestureLayout(Context context) {
        super(context);
        this.context =context;
        init();
    }

    public GestureLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context =context;
        init();
    }

    public GestureLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context =context;
        init();
    }

//    public GestureLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
//        super(context, attrs, defStyleAttr, defStyleRes);
//        this.context =context;
//        init();
//    }

    public void init(){
        gestureDetector = new GestureDetector(context,this);
        gestureDetector.setIsLongpressEnabled(false);
    }

    public boolean onTouchEvent(MotionEvent event){

        boolean consume = gestureDetector.onTouchEvent(event);
        return consume;
    }
//    @Override
//    public boolean onTouchEvent(MotionEvent event) {
//        return super.onTouchEvent(event);
//    }

    @Override
    public boolean onDown(MotionEvent e) {
        Log.e("down","down");
        return true;
    }

    @Override
    public void onShowPress(MotionEvent e) {
        Log.e("onShowPress","onShowPress");
    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        Log.e("onSingleTapUp","onSingleTapUp");
        return true;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        Log.e("onScroll","onScroll");
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {
        Log.e("onLongPress","onLongPress");
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        Log.e("onFling","onFling");
        return false;
    }

    @Override
    public boolean onSingleTapConfirmed(MotionEvent e) {
        Log.e("onSingleTapConfirmed","onSingleTapConfirmed");
        return true;
    }

    @Override
    public boolean onDoubleTap(MotionEvent e) {
        Log.e("onDoubleTap","onDoubleTap");
        return false;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent e) {
        Log.e("onDoubleTapEvent","onDoubleTapEvent");
        return false;
    }
}
