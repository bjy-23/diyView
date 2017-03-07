package com.example.bjy.diyview.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.Scroller;

/**
 * Created by bjy on 2016/12/14.
 */

public class ScrollButton extends Button {
    private Context context;
    private Scroller scroller;
    public ScrollButton(Context context) {
        super(context);
        this.context = context;
        init();
    }

    public ScrollButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        init();
    }

    public ScrollButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        init();
    }

    public void init(){
        scroller = new Scroller(context);
    }

    public void smoothScrollTo(int destX,int destY){
        int scrollX = getScrollX();
        int deltaX = destX - scrollX;
        scroller.startScroll(scrollX,0,deltaX,0,1000);
        invalidate();
    }
    public void smoothScrollBy(int destX,int destY){
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        scroller.startScroll(scrollX,scrollY,destX,destY,1000);
        invalidate();
    }

    @Override
    public void computeScroll(){
        super.computeScroll();
        if (scroller.computeScrollOffset()){
            scrollTo(scroller.getCurrX(),scroller.getCurrY());
            postInvalidate();
        }
    }
}
