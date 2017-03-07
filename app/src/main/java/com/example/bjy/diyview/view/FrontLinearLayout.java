package com.example.bjy.diyview.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.LinearLayout;
import android.widget.Scroller;

/**
 * Created by bjy on 2016/12/16.
 */

public class FrontLinearLayout extends LinearLayout {
    private Scroller scroller;
    private onIntentListener onIntentListener;
    public FrontLinearLayout(Context context) {
        super(context);
        scroller = new Scroller(context);
    }

    public FrontLinearLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        scroller = new Scroller(context);
    }

    public FrontLinearLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        scroller = new Scroller(context);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int oldY=0;
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                oldY = (int) event.getRawY();
                break;
            case MotionEvent.ACTION_MOVE:
                int newY = (int) event.getRawY();
                if (getScrollY()<0){
                    scrollBy(0,newY-oldY);
                    oldY = newY;
                }
                break;
            case MotionEvent.ACTION_UP:
                if (getScaleY()>(-100)){
                    scroller.startScroll(0,getScrollY(),0,0,1000);
                    invalidate();
                }else if ((-100)>getScrollY()&&getScrollY()>(-150)){
                    scroller.startScroll(0,getScrollY(),0,100,1000);
                    invalidate();
                }else {
                    onIntentListener.onIntent();
                }

        }
        return super.onTouchEvent(event);
    }

    @Override
    public void computeScroll() {
        super.computeScroll();
        if (scroller.computeScrollOffset()){
            scrollTo(scroller.getCurrX(),scroller.getCurrY());
            postInvalidate();
        }
    }

    public interface onIntentListener{
        void onIntent();
    }

    public void setOnIntentListener(FrontLinearLayout.onIntentListener onIntentListener) {
        this.onIntentListener = onIntentListener;
    }
}
