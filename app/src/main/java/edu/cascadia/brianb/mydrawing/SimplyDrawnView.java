package edu.cascadia.brianb.mydrawing;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathDashPathEffect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Edited by Brian Bansenauer on 10/18/15.
 */
public class SimplyDrawnView extends View {

    private Paint mPaint;
    private Paint textPaint;
    private Path mPath;
    private Paint ovalPaint;
    private float mWidth, mHeight;

    public SimplyDrawnView(Context context, AttributeSet attributeSet){
        super(context, attributeSet);
        mPaint = new Paint();
        textPaint = new Paint();
        ovalPaint = new Paint();
        mPath = new Path();
     }
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mWidth = w;
        mHeight = h;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawColor(Color.WHITE); //draw background

        //Draw line
        mPaint.setColor(Color.BLACK);
        mPaint.setStrokeWidth(16.0f);
        textPaint.setColor(Color.BLACK);
        textPaint.setTextSize(100);
        canvas.drawLine(mWidth, 0, 200, mHeight, mPaint);

        mPaint.setColor(Color.RED); mPaint.setStrokeWidth(10);
        canvas.drawLine(mWidth, 0, 0, mHeight, mPaint);

        //Draw green lines
        mPaint.setColor(Color.GREEN); mPaint.setStrokeWidth(10);
        canvas.drawLine(mWidth, 100, 0, 100, mPaint);
        canvas.drawLine(mWidth, 200, 0, 200, mPaint);
        canvas.drawLine(mWidth, 300, 0, 300, mPaint);
        canvas.drawLine(mWidth, 400, 0, 400, mPaint);
        canvas.drawLine(mWidth, 500, 0, 500, mPaint);

        //Draw Text
        canvas.drawText("Welcome to gulag", 200, 200, textPaint);

        //Draw Text on a Path
        setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        mPath.addCircle(600, 1600, 200, Path.Direction.CW);
        textPaint.setTextSize(75);
        canvas.drawTextOnPath("the happiest place on earth", mPath, 20, 0, textPaint);


        //Draw filled, opaque, and open ovals
        ovalPaint.setColor(Color.GREEN);
        canvas.drawOval(800, 1200, 1000, 1600, ovalPaint);

        ovalPaint.setColor(Color.GREEN);
        ovalPaint.setAlpha(100);
        canvas.drawOval(1200, 1200, 1500, 1600, ovalPaint);

        canvas.drawOval(100, 1200, 300, 1600, ovalPaint);

        ovalPaint.setColor(Color.WHITE);
        canvas.drawOval(100, 1500, 300, 2000, ovalPaint);


        //Draw bee bitmap
        //     HINT: since b is a Drawable, you can use its .draw method, but .setBounds on it first
        Drawable b = getResources().getDrawable(R.drawable.bee,null);
        b.setBounds(0, 300, 400, 600);
        b.draw(canvas);

        //Add another image to the project (copy and paste to Android Studio res/drawable folder)
        //     and draw it on the screen
        Drawable tinyDiny = getResources().getDrawable(R.drawable.tinydiny);
        tinyDiny.setBounds(200, 600, 400, 800);
        tinyDiny.draw(canvas);

    }
}
