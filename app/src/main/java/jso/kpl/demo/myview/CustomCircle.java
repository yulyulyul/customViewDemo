package jso.kpl.demo.myview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

import jso.kpl.demo.R;

public class CustomCircle extends View
{
    private int lineColor;
    private int lineType;

    public CustomCircle(Context context)
    {
        super(context);

    }

    public CustomCircle(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        init(attrs);
    }

    public CustomCircle(Context context, AttributeSet attrs, int defStyleAttr)
    {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    @Override
    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);

    }

    private void init(AttributeSet attrs)
    {
        TypedArray a = getContext().getTheme().obtainStyledAttributes(attrs, R.styleable.CustomCircle,0,0);
        try
        {
            this.lineColor = a.getColor(R.styleable.CustomCircle_lineColor,0xff000000);
            this.lineType = a.getInteger(R.styleable.CustomCircle_lineType, 0);
        }
        finally
        {
        }
    }

    public int getLineColor()
    {
        return lineColor;
    }

    public void setLineColor(int color)
    {
        this.lineColor = color;
        invalidate();
        requestLayout();
    }
}
