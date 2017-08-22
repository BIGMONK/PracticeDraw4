package com.hencoder.hencoderpracticedraw4.practice;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.hencoder.hencoderpracticedraw4.R;

public class Practice01ClipRectView extends View {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Bitmap bitmap;

    public Practice01ClipRectView(Context context) {
        super(context);
    }

    public Practice01ClipRectView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice01ClipRectView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.maps);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int viewWidth = getWidth();
        int viewHeigh = getHeight();
        int bitWidth = bitmap.getWidth();
        int bitHeigh = bitmap.getHeight();
        canvas.drawBitmap(bitmap, 0, 0, paint);

        canvas.save();
        int left = viewWidth / 2 - bitWidth / 2;
        int top = viewHeigh / 2 - bitHeigh / 2;
        canvas.clipRect(left, top, left + bitWidth / 2, top + bitHeigh / 2);//显图区域
        canvas.drawBitmap(bitmap, left, top - bitHeigh / 2, paint);//绘图
        canvas.restore();

        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawCircle(viewWidth / 4 * 3, viewHeigh / 2, viewHeigh / 4, paint);
        canvas.save();
        for (int i = 0; i < 3; i++) {
            canvas.drawLine(viewWidth / 4 * 3, viewHeigh / 4, viewWidth / 4 * 3, viewHeigh / 4 + 20, paint);
            canvas.rotate(60, viewWidth / 4 * 3, viewHeigh / 2);
        }
        canvas.restore();
        paint.setColor(Color.BLACK);
        canvas.drawLine(viewWidth / 4 * 3, viewHeigh / 4, viewWidth / 4 * 3, viewHeigh / 4 + 20, paint);


    }
}
