package com.example.pigview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/**
 * 项目名称：PigView
 * 作者：Yamy
 * 创建时间：2020/6/4   14:47
 **/
public class CustomePathView extends View {

    private Path path;
    private Canvas canvas;
    private Paint paint;

    public CustomePathView(Context context) {
        super(context);
        init();
    }

    public CustomePathView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CustomePathView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        canvas = new Canvas();
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        path = new Path();
    }
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);


        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(10);

        //鼻子
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawOval(800, 220, 1000, 520, paint);

        //鼻孔
        paint.setStrokeWidth(50);
        paint.setStrokeCap(Paint.Cap.ROUND);
        canvas.drawPoint(860, 370, paint);
        canvas.drawPoint(930, 370, paint);

        //眼睛
        canvas.drawPoint(430, 370, paint);
        canvas.drawPoint(610, 320, paint);

        //眼眶
        paint.setStrokeWidth(15);
        canvas.drawCircle(450,370,60,paint);
        canvas.drawCircle(630,320,60,paint);


        //脑袋
        paint.setStrokeWidth(10);
        path.arcTo(160,177,1200,1000,-190,125,false);
        path.arcTo(160,150,800,1000,10,170, true);
        canvas.drawPath(path,paint);


        //鼻子下边
        canvas.drawLine(900,520,795,650,paint);

        //嘴
        canvas.drawArc(400, 500, 700, 800, 20, 120, false, paint);

        //左耳
        canvas.drawArc(300, 100, 430, 270, 36, -290, false, paint);
        //右耳
        canvas.drawArc(460, 50, 580, 200, 45, -290, false, paint);

        //身子
        path.moveTo(370, 980);
        path.lineTo(150, 1400);
        path.lineTo(850, 1400);
        path.lineTo(600, 970);
        canvas.drawPath(path,paint);

        //左脚
        path.moveTo(370,1400);
        path.lineTo(370, 1550);
        path.lineTo(470, 1550);
        canvas.drawPath(path,paint);
        //右脚
        path.moveTo(600,1400);
        path.lineTo(600, 1550);
        path.lineTo(700, 1550);
        canvas.drawPath(path,paint);

        //左手
        path.moveTo(360,1000);
        path.lineTo(60, 1200);
        canvas.drawPath(path,paint);

        //右手
        path.moveTo(620,1000);
        path.lineTo(920, 1200);
        canvas.drawPath(path,paint);


        //尾巴
        paint.setStrokeWidth(10);
        path.arcTo(10,1260,150,1320,-80,270,true);
        path.arcTo(50,1255,250,1315,-128,-167, true);
        canvas.drawPath(path,paint);

        //心形
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.FILL);
        Path path1 = new Path();
        path1.addArc(400, 1100, 500, 1200, -225, 225);
        path1.arcTo(500, 1100, 600, 1200, -180, 225, false);
        path1.lineTo(500, 1300);
        canvas.drawPath(path1,paint);

    }
}
