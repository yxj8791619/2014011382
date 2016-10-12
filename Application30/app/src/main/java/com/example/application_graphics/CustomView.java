package com.example.application_graphics;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

public class CustomView extends View {


    public CustomView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //设置画布背景色
        canvas.drawColor(Color.WHITE);

        Paint paint=new Paint();

        ////绘制矩形，内部不填充
        //抗锯齿
        paint.setAntiAlias(true);

        //画笔颜色
        paint.setColor(Color.GREEN);

        //设置填充类型
        paint.setStyle(Paint.Style.STROKE);

        //设置画笔宽度
        paint.setStrokeWidth(10);

        //绘制普通矩形
        canvas.drawRect(10, 10, 200, 150, paint);

        //绘制三角形，内部填充
        Path path=new Path();
        path.moveTo(30, 200);
        path.lineTo(200, 400);
        path.lineTo(300, 200);
        path.close();
        paint.setStyle(Paint.Style.FILL);
        canvas.drawPath(path, paint);

        //绘制文本
        paint.setTextSize(100);
        paint.setColor(Color.BLUE);
        paint.setStrikeThruText(true);
        canvas.drawText("hello world", 250, 800, paint);

        Path pathText=new Path();
        pathText.addCircle(500,900,400, Path.Direction.CCW);

        canvas.drawTextOnPath("abcdefghijklmnopqlstuvwxyzabcdefghijklmnopqlstuvwx",pathText,0,10,paint);
    }
}

