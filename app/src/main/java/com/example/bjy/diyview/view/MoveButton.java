package com.example.bjy.diyview.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.Button;

/**
 * Created by bjy on 2016/12/14.
 */

public class MoveButton extends Button {
    private int oldX;
    private int oldY;
    private int newX;
    private int newY;
    private MoveListener moveListener;
    public MoveButton(Context context) {
        super(context);
    }

    public MoveButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MoveButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public boolean onTouchEvent(MotionEvent event){
        int width = getWidth();
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                oldX = (int) event.getRawX();
                oldY = (int) event.getRawY();
                break;
            case MotionEvent.ACTION_MOVE:
                newX = (int) event.getRawX();
                newY = (int) event.getRawY();
                moveListener.onMove(oldX-newX,oldY-newY);
                oldX = newX;
                oldY = newY;
                break;
            case MotionEvent.ACTION_UP:
                moveListener.moveBack();

        }
        return super.onTouchEvent(event);
    }

    public interface MoveListener{
        void onMove(int translationX,int translationY);
        void moveBack();
    }

    public void setMoveListener(MoveListener moveListener) {
        this.moveListener = moveListener;
    }
}
