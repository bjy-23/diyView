package com.example.bjy.diyview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;

/**
 * Created by bjy on 2017/2/6.
 */

public class MainActivity3 extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main3);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.e("activity","0");
        return super.onTouchEvent(event);
    }
}
