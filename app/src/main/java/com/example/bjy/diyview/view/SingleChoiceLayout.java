package com.example.bjy.diyview.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by bjy on 2017/3/7.
 */

public class SingleChoiceLayout extends LinearLayout {
    private Builder builder;
    private TextView textViewContent;
    public SingleChoiceLayout(Builder builder) {
        this(builder.getContext(),null,builder);
    }

    public SingleChoiceLayout(Context context, AttributeSet attrs,Builder builder) {
        super(context, attrs);
        this.builder = builder;
        init();
    }

    private void init(){
        LayoutParams layoutParams = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        this.setLayoutParams(layoutParams);
        this.setOrientation(VERTICAL);
        for (String content : builder.getContents()){
            textViewContent = new TextView(builder.getContext());
            textViewContent.setText(content);
            this.addView(textViewContent);
        }
    }

    public static class Builder{
        private Context context;
        private List<String> contents;

        public Builder(Context context){
            this.context = context;
        }

        public Builder setContent(List<String> contents){
            this.contents = contents;
            return this;
        }

        public Context getContext() {
            return context;
        }

        public List<String> getContents() {
            return contents;
        }

        public SingleChoiceLayout build(){
            return new SingleChoiceLayout(this);
        }

    }
}
