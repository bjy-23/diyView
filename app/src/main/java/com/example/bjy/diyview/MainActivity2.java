package com.example.bjy.diyview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;

import com.example.bjy.diyview.view.MyLinearLayout;

/**
 * Created by bjy on 2016/12/16.
 */

public class MainActivity2 extends AppCompatActivity implements View.OnTouchListener {
    private MyLinearLayout layout;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {

        MotionEvent.PointerProperties[] pointerPropertiesArray = new MotionEvent.PointerProperties[2];
        MotionEvent.PointerProperties properties0 = new MotionEvent.PointerProperties();
        properties0.id = 0;
        pointerPropertiesArray[0] = properties0;
        MotionEvent.PointerProperties properties1 = new MotionEvent.PointerProperties();
        properties1.id = 1;
        pointerPropertiesArray[1] = properties1;

        MotionEvent.PointerCoords[] pointerCoordsArray = new MotionEvent.PointerCoords[2];

        MotionEvent.PointerCoords pointerCoords1 = new MotionEvent.PointerCoords();
        pointerCoords1.setAxisValue(MotionEvent.AXIS_X,50.1f);
        pointerCoords1.setAxisValue(MotionEvent.AXIS_Y,50.1F);
        pointerCoordsArray[0] = pointerCoords1;
        MotionEvent.PointerCoords pointerCoords2 = new MotionEvent.PointerCoords();
        pointerCoords2.setAxisValue(MotionEvent.AXIS_X,80.1F);
        pointerCoords2.setAxisValue(MotionEvent.AXIS_Y,80.1f);
        pointerCoordsArray[1] = pointerCoords2;

        MotionEvent event1 = MotionEvent.obtain(0,0,MotionEvent.ACTION_POINTER_DOWN,2,pointerPropertiesArray,pointerCoordsArray,0,0,0f,0f,0,0,0,0);

    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return false;
    }
}
