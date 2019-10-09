package jso.kpl.demo.myview;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import jso.kpl.demo.R;

public class CustomNode extends LinearLayout
{
    public TextView locationText;

    public CustomNode(Context context) {
        super(context);
    }

    public CustomNode(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initializeViews(context, attrs);
    }

    public CustomNode(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initializeViews(context, attrs);
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

    private void initializeViews(Context context, AttributeSet attrs) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.custom_node, this);
        if (attrs != null) {
            //attrs.xml에 정의한 스타일을 가져온다
            TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.CustomNode);
//            mSelected = a.getInteger(0, 0);
            a.recycle();
        }
    }

    @Override
    protected void onFinishInflate()
    {
        super.onFinishInflate();

        locationText = (TextView)findViewById(R.id.locationText);
    }
}
