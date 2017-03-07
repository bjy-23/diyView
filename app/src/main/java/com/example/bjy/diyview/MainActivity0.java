package com.example.bjy.diyview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.bjy.diyview.view.SingleChoiceLayout;

import java.util.ArrayList;

/**
 * Created by bjy on 2017/3/7.
 */

public class MainActivity0 extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main0);

        TextView tv = (TextView) findViewById(R.id.hello);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity0.this);
                ArrayList<String> data = new ArrayList<String>();
                data.add("aaa");
                data.add("bbb");
                data.add("ccc");
                SingleChoiceLayout singleChoiceLayout = new SingleChoiceLayout.Builder(MainActivity0.this)
                        .setContent(data)
                        .build();
                builder.setView(singleChoiceLayout);
                builder.create().show();
            }
        });
    }
}
