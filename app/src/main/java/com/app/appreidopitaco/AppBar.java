package com.app.appreidopitaco;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

public class AppBar extends View {
    Paint corTexto;
    Paint corTextoPremio;
    Paint corTextoSub;
    Paint corBackground;
    String text;
    String saldo = "R$1.000,00";
    String premio="Premio";
    String mitou="Quem mitou no Rei do Pitaco";
    RectF retangulo;
    boolean mShowText;
    int textPosition;
    int x;

    public void init(){

        corTexto = new Paint(Paint.ANTI_ALIAS_FLAG|Paint.DITHER_FLAG);
        corTexto.setColor(Color.BLACK);
        corTexto.setStyle(Paint.Style.FILL);
        corTexto.setTextSize(40);

        corTextoPremio = new Paint(Paint.ANTI_ALIAS_FLAG|Paint.DITHER_FLAG);
        corTextoPremio.setColor(Color.BLACK);
        corTextoPremio.setStyle(Paint.Style.FILL);
        corTextoPremio.setTextSize(40);

        corTextoSub = new Paint(Paint.ANTI_ALIAS_FLAG|Paint.DITHER_FLAG);
        corTextoSub.setColor(Color.BLACK);
        corTextoSub.setStyle(Paint.Style.FILL);
        corTextoSub.setTextSize(20);

        corBackground = new Paint(Paint.ANTI_ALIAS_FLAG|Paint.DITHER_FLAG);
        corBackground.setShader(new LinearGradient(10, 10, 2000, getHeight(),  Color.argb(100,87,186,35),Color.argb(100,255,194,41), Shader.TileMode.MIRROR));

    }
    public AppBar (Context context, AttributeSet attrs){
        super(context);
        init();
        TypedArray a = context.getTheme().obtainStyledAttributes(attrs,R.styleable.AppBar,0,0);

        try{
            mShowText=a.getBoolean(R.styleable.AppBar_ShowText,false);
            textPosition=a.getInt(R.styleable.AppBar_labelPosition,0);
            text=a.getString(R.styleable.AppBar_setText);
        }finally {
            a.recycle();
        }
        if(textPosition==0){
            corTexto.setTextAlign(Paint.Align.LEFT);
        }else{
            corTexto.setTextAlign(Paint.Align.RIGHT);
        }
    }

    @SuppressLint("DrawAllocation")
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);
        x=getWidth()-250;

        retangulo = new RectF(10,10,getWidth()-10,200);

        if(mShowText){
            canvas.drawText(saldo,x,95,corTextoPremio);
            canvas.drawText(premio,x,145,corTextoSub);
            canvas.drawText(text,28,95,corTexto);
            canvas.drawText(mitou,28,145,corTextoSub);
        }
            canvas.drawRoundRect(retangulo,100,100,corBackground);
    }
}
