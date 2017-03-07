package com.example.bjy.diyview;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Dialog;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TextView;

import com.example.bjy.diyview.view.FrontLinearLayout;
import com.example.bjy.diyview.view.MoveButton;
import com.example.bjy.diyview.view.ScrollButton;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements MoveButton.MoveListener{
    private MoveButton btn;
    private LinearLayout moveLayout;
    private int scrollPoint;
    private boolean isIntent;
    private LinearLayout.LayoutParams layoutParams;
    private View viewLeft;
    private TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = (MoveButton) findViewById(R.id.btn);
        btn.setMoveListener(this);
        moveLayout = (LinearLayout) findViewById(R.id.move_layout);
        viewLeft = findViewById(R.id.view_left);

    }

    @Override
    protected void onResume() {
        super.onResume();
//        moveLayout.scrollTo(0,0);
        isIntent = false;
        if (layoutParams!=null){
            layoutParams.width = 0;
            viewLeft.requestLayout();
        }
    }

    @Override
    public void onMove(int translationX, int translationY) {
        layoutParams.width += (-translationX);
        if (layoutParams.width >= 0 && layoutParams.width < (-scrollPoint)) {
            viewLeft.requestLayout();
        } else if (layoutParams.width > (-scrollPoint)) {
            if (!isIntent){
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);
                isIntent = true;
            }
        }
//        if ((moveLayout.getScrollX()+translationX)<=0)
//            moveLayout.scrollBy(translationX,0);
//
//        if (moveLayout.getScrollX()<=scrollPoint){
//            if (!isIntent){
//                Intent intent = new Intent(MainActivity.this,MainActivity2.class);
//                startActivity(intent);
//            }
//            isIntent = true;
//        }
    }

    @Override
    public void moveBack() {
//        if (moveLayout.getScrollX()>scrollPoint)
//            moveLayout.scrollTo(0,0);
        if (layoutParams.width<(-scrollPoint)){
            layoutParams.width = 0;
            viewLeft.requestLayout();
        }
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);

        layoutParams = (LinearLayout.LayoutParams) viewLeft.getLayoutParams();
        int viewWidth = layoutParams.width;
        int btnWidth = btn.getWidth();
        int btnWidth2 = btn.getMeasuredWidth();
        int moveLayoutWidth = moveLayout.getWidth();
        int moveLayoutWidth2 = moveLayout.getMeasuredWidth();

        scrollPoint = btnWidth - moveLayoutWidth;
    }
}
