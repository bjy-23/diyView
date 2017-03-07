package com.example.bjy.diyview.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;

import com.example.bjy.diyview.R;

/**
 * Created by bjy on 2017/3/1.
 *
 */

public class CircleImageView extends ImageView {
    private Paint mPaint;

    public CircleImageView(Context context) {
        this(context,null);
    }

    public CircleImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init(){
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Drawable drawable = getDrawable();

        if (drawable == null){
            return;
        }

        Bitmap bitmap = drawableToBitmap(drawable);

        Bitmap show = getCircleBitmap(bitmap,15);
        canvas.drawBitmap(show,0,0,null);
    }

    private Bitmap drawableToBitmap(Drawable drawable){
        if (drawable instanceof BitmapDrawable){
            BitmapDrawable bd = (BitmapDrawable) drawable;
            return bd.getBitmap();
        }

        int w = drawable.getIntrinsicWidth();
        int h = drawable.getIntrinsicHeight();

        Bitmap bitmap = Bitmap.createBitmap(w,h, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0,0,w,h);
        drawable.draw(canvas);
        return bitmap;
    }

    private Bitmap getCircleBitmap(Bitmap bitmap ,int pixels){
        Bitmap output = Bitmap.createBitmap(bitmap.getHeight(),bitmap.getHeight()
                , Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(output);
        canvas.drawCircle(bitmap.getHeight()/2,bitmap.getWidth()/2,bitmap.getHeight()/2,mPaint);

        mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));

        canvas.drawBitmap(bitmap,0,0,mPaint);
        return output;
    }
}
