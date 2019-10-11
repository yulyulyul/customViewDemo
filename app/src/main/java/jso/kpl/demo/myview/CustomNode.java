package jso.kpl.demo.myview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import jso.kpl.demo.R;

public class CustomNode extends LinearLayout
{
    private TextView locationText;
    private TextView costText;

    private CustomLine headLine;
    private CustomLine tailLine;

    private String locationName;
    private String cost;

    private int headlineType;
    private int taillineType;

    private Integer headlineVisiblity;
    private Integer taillineVisiblity;


    public static String TAG = "Demo.CustomNode";

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
        locationName = null;
        cost = null;

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.custom_node, this);
        if (attrs != null) {
            //attrs.xml에 정의한 스타일을 가져온다
            TypedArray a = getContext().getTheme().obtainStyledAttributes(attrs, R.styleable.CustomNode,0,0);
//            mSelected = a.getInteger(0, 0);
            this.locationName = a.getString(R.styleable.CustomNode_locationName);
            this.cost = a.getString(R.styleable.CustomNode_costVal);

            /*
                CustomNode의 CustomLine의 lineType을 조정 => 곡선, 직선 결정
                4번 (직선)이 default Setting
             */
            this.headlineType = a.getInt(R.styleable.CustomNode_headlineType, 4);
            this.taillineType = a.getInt(R.styleable.CustomNode_taillineType, 4);

            this.headlineVisiblity = a.getInteger(R.styleable.CustomNode_headlineVisiblity, 0);
            this.taillineVisiblity = a.getInteger(R.styleable.CustomNode_taillineVisiblity, 0);

            Log.d(TAG, "locationName : " + locationName);
            a.recycle();
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        if(getLocationName() != null)
//        {
//            locationText.setText(locationName);
//        }
    }

    public String getCost()
    {
        return cost;
    }

    public void setCost(String _cost)
    {
        this.cost = _cost;
        costText.setText(cost);
        invalidate();
        requestLayout();
    }

    public String getLocationName()
    {
        return locationName;
    }

    public void setLocationName(String _locationName)
    {
        this.locationName = _locationName;
        locationText.setText(locationName);
        invalidate();
        requestLayout();
    }

    public int getHeadLineType()
    {
        return headlineType;
    }

    public void setHeadLineType(int type)
    {
        this.headlineType = type;

        headLine.setLineType(headlineType);
        invalidate();
        requestLayout();
    }

    public int getTailLineType()
    {
        return taillineType;
    }

    public void setTailLineType(int type)
    {
        this.taillineType = type;

        tailLine.setLineType(taillineType);
        invalidate();
        requestLayout();
    }

    public Integer getHeadLineVisiblity()
    {
        return headlineVisiblity;
    }

    public void setHeadlineVisiblity(Integer _val)
    {
        this.headlineVisiblity = _val;

        switch (headlineVisiblity)
        {
            case 0:
                headLine.setVisibility(View.VISIBLE);
                break;

            case 1:
                headLine.setVisibility(View.INVISIBLE);
                break;

            case 2:
                headLine.setVisibility(View.GONE);
                break;

        }
        invalidate();
        requestLayout();
    }


    public Integer getTailLineVisiblity()
    {
        return taillineVisiblity;
    }

    public void setTailLineVisiblity(Integer _val)
    {
        this.taillineVisiblity = _val;

        switch (taillineVisiblity)
        {
            case 0:
                tailLine.setVisibility(View.VISIBLE);
                break;

            case 1:
                tailLine.setVisibility(View.INVISIBLE);
                break;

            case 2:
                tailLine.setVisibility(View.GONE);
                break;
        }
        invalidate();
        requestLayout();
    }

    @Override
    protected void onFinishInflate()
    {
        super.onFinishInflate();

        locationText = (TextView)findViewById(R.id.locationText);
        costText = (TextView)findViewById(R.id.costtv);
        headLine = (CustomLine)findViewById(R.id.headLine);
        tailLine = (CustomLine)findViewById(R.id.tailLine);

        if(locationName!=null)
        {
            locationText.setText(locationName);
        }
        if(cost != null)
        {
            costText.setText(cost);
        }
        setHeadLineType(getHeadLineType());
        setTailLineType(getTailLineType());

        setHeadlineVisiblity(getHeadLineVisiblity());
        setTailLineVisiblity(getTailLineVisiblity());
    }
}
