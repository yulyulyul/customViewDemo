package jso.kpl.demo.myview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import androidx.core.content.ContextCompat;

import jso.kpl.demo.R;

public class CustomCircle extends View
{
    private int lineColor;
    private int lineType;

    private PointF[] leftTobottom;
    private PointF[] leftToTop;


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
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec)
    {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom)
    {
        super.onLayout(changed, left, top, right, bottom);
    }

    @Override
    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);

        //Paint Setting
        Paint paint  = new Paint();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
        //선의 굵기를 세팅하는 곳. px 단위인데 dp 단위로 바꿔서 통일시켜야함.
        paint.setStrokeWidth(8);
        paint.setColor(getLineColor());

        //좌표 초기화
        pointFinit(canvas);

        switch(this.lineType)
        {
            case 0 :
                canvas.drawPath(drawCurve(leftTobottom[0],leftTobottom[1], leftTobottom[2]), paint);
                break;
            case 1:
                canvas.drawPath(drawCurve(leftToTop[0],leftToTop[1], leftToTop[2]), paint);
                break;
        }


    }

    /**
        곡선을 그리기 위하여 필요한 좌표를 초기화.
        startPoint~ : 시작 좌표
        centerP : 중간 좌표(여기를 기점으로 곡선이 꺾임)
        endPoint~ : 끝 좌표
     */
    private void pointFinit(Canvas canvas)
    {
        int w=canvas.getWidth();
        int h=canvas.getHeight();
        int w_2= (w / 2);
        int h_2= (h / 2);
        PointF startPoint1 = new PointF(0, h_2);
        PointF centerP = new PointF(w_2, h_2);
        PointF endPoint1 = new PointF(w_2, h);

        leftTobottom[0] = startPoint1;
        leftTobottom[1] = centerP;
        leftTobottom[2] = endPoint1;

        PointF endPoint2 = new PointF(w_2, 0);
        leftToTop[0] = startPoint1;
        leftToTop[1] = centerP;
        leftToTop[2] = endPoint2;


    }

    private void init(AttributeSet attrs)
    {
        leftTobottom = new PointF[3];
        leftToTop = new PointF[3];

        TypedArray a = getContext().getTheme().obtainStyledAttributes(attrs, R.styleable.CustomCircle,0,0);
        try
        {
            this.lineColor = a.getColor(R.styleable.CustomCircle_lineColor,0xffc0c0c0);
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

    public int getLineType()
    {
        return lineType;
    }

    public void setLineType(int type)
    {
        this.lineType = type;
        invalidate();
        requestLayout();
    }


    private Path drawCurve(PointF mPointa, PointF cp, PointF mPointb) {
        Path myPath = new Path();
        myPath.moveTo(mPointa.x, mPointa.y);
        myPath.cubicTo(mPointa.x, mPointa.y , cp.x, cp.y, mPointb.x, mPointb.y);
        return myPath;
    }

}
