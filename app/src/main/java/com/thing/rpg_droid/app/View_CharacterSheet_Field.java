package com.thing.rpg_droid.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;

import com.thing.rpg_droid.res.R;

/**
 * Created by jon on 22/06/14.
 */
public class View_CharacterSheet_Field extends View
{
    private String mLabel;

    private int mLabelFontSize;

    private int mLabelWidth;

    private String mValue;

    private int mValueFontSize;

    private int mBorderRadius = 0;

    private int mLabelColor = 0xFF000000;

    private int mValueColor = 0xFF000000;

    private Paint mBorderStroke;

    private Paint mTextBrush = new Paint();

    private RectF mBorderRect;

    private int mInternalPadding;

    private Rect mTextRect = new Rect();

    public View_CharacterSheet_Field(Context pContext)
    {
        this(pContext, null);
    }

    public View_CharacterSheet_Field(Context pContext, AttributeSet pAttrs)
    {
        this(pContext, pAttrs, 0);
    }

    public View_CharacterSheet_Field(Context pContext, AttributeSet pAttrs, int pDefStyleAttr)
    {
        super(pContext, pAttrs, pDefStyleAttr);

        Init(pContext, pAttrs, pDefStyleAttr);
    }

    public String getValue()
    {
        return mValue;
    }

    public void setValue(String pValue)
    {
        mValue = pValue;
    }

    private void Init(Context pContext, AttributeSet pAttrs, int pDefStyleAttr)
    {
        DisplayMetrics dm = getResources().getDisplayMetrics();

        TypedArray aTypedArray = pContext.obtainStyledAttributes(pAttrs, R.styleable.View_CharacterSheet_Field, pDefStyleAttr, 0);

        mValueColor = aTypedArray.getColor(R.styleable.View_CharacterSheet_Field_valueColor, mValueColor);

        mValueFontSize = (int)(Math.round(12 * dm.scaledDensity));
        mValueFontSize = aTypedArray.getDimensionPixelSize(R.styleable.View_CharacterSheet_Field_valueFontSize, mValueFontSize);

        mLabelColor = aTypedArray.getColor(R.styleable.View_CharacterSheet_Field_labelColor, mLabelColor);

        mLabelFontSize = (int)(Math.round(8 * dm.scaledDensity));
        mLabelFontSize = aTypedArray.getDimensionPixelSize(R.styleable.View_CharacterSheet_Field_labelFontSize, mLabelFontSize);

        mBorderRadius = aTypedArray.getDimensionPixelSize(R.styleable.View_CharacterSheet_Field_cornerRadius, mBorderRadius);

        mInternalPadding = (int)(Math.round(5 * dm.scaledDensity));

        mLabel = aTypedArray.getString(R.styleable.View_CharacterSheet_Field_label);
        mValue = aTypedArray.getString(R.styleable.View_CharacterSheet_Field_value);

        mBorderRect = new RectF();

        int lBorderStrokeWidth = aTypedArray.getDimensionPixelSize(R.styleable.View_CharacterSheet_Field_borderWidth, -1);
        int lBorderStrokeColor = aTypedArray.getColor(R.styleable.View_CharacterSheet_Field_borderColor, 0xFFFFFFFF);

        if (lBorderStrokeWidth >= 0)
        {
            mBorderStroke = new Paint();
            mBorderStroke.setStyle(Paint.Style.STROKE);
            mBorderStroke.setColor(lBorderStrokeColor);
            mBorderStroke.setStrokeWidth(lBorderStrokeWidth);
        }
        else
        {
            mBorderStroke = null;
        }

        aTypedArray.recycle();
    }

    @Override
    protected void onMeasure (int pWidthMeasureSpec, int pHeightMeasureSpec)
    {
        int lWidth = getSuggestedMinimumWidth();
        int lHeight = Math.max(getSuggestedMinimumHeight(), Math.max(mLabelFontSize, mValueFontSize));
        float lBorderWidth = 0;

        if (mBorderStroke != null) //catering for hairline divider
        {
            lBorderWidth = mBorderStroke.getStrokeWidth();
            if (lBorderWidth == 0)
                lBorderWidth = 1;
        }

        if ((mLabel != null) && (!mLabel.equals("")))
        {
            mTextBrush.setTextSize(mLabelFontSize);
            mLabelWidth = (int)Math.ceil(mTextBrush.measureText(mLabel));

            lWidth = Math.max(mLabelWidth + mInternalPadding, lWidth);
        }

        if ((mValue != null) && (!mValue.equals("")))
        {
            mTextBrush.setTextSize(mValueFontSize);
            lWidth += (int) Math.ceil(mTextBrush.measureText(mValue));
        }

        lWidth += getPaddingLeft() + getPaddingRight() + 2 * lBorderWidth;

        lHeight += getPaddingTop() + getPaddingBottom() + 2 * lBorderWidth;

        lWidth = resolveSizeAndState(lWidth, pWidthMeasureSpec, 0);
        lHeight = resolveSizeAndState(lHeight, pHeightMeasureSpec, 0);

        setMeasuredDimension(lWidth, lHeight);
    }

    @Override
    protected void onDraw (Canvas pCanvas)
    {
        super.onDraw(pCanvas);

        float lBorderWidth = 0;

        if (mBorderStroke != null) //catering for hairline divider
        {
            lBorderWidth = mBorderStroke.getStrokeWidth();
            if (lBorderWidth == 0)
                lBorderWidth = 1;
        }

        float lPosX = getPaddingLeft() + lBorderWidth;

        float lVertPadding = getPaddingTop() + getPaddingBottom() + 2 * lBorderWidth;

        if ((mLabel != null) && (!mLabel.equals("")))
        {
            mTextBrush.setColor(mLabelColor);
            mTextBrush.setTextSize(mLabelFontSize);
            mTextBrush.getTextBounds(mLabel,0,mLabel.length(),mTextRect);

            pCanvas.drawText(mLabel, lPosX, getPaddingTop() + lBorderWidth - mTextBrush.ascent() - mTextBrush.descent(), mTextBrush);

            lPosX += mLabelWidth + mInternalPadding;
        }

        if ((mValue != null) && (!mValue.equals("")))
        {
            mTextBrush.setColor(mValueColor);
            mTextBrush.setTextSize(mValueFontSize);

            lPosX = getWidth() - (lBorderWidth + getPaddingRight()) - (int)Math.ceil(mTextBrush.measureText(mValue));

            pCanvas.drawText(mValue, lPosX, (getHeight() - (mTextBrush.ascent() + mTextBrush.descent())) / 2, mTextBrush);
        }

        if (mBorderStroke != null)
        {
            mBorderRect.set(0, 0, getWidth()-1, getHeight()-1);

            if (mBorderRadius != 0)
                pCanvas.drawRoundRect(mBorderRect, mBorderRadius, mBorderRadius, mBorderStroke);
            else
                pCanvas.drawRect(mBorderRect, mBorderStroke);
        }
        //paint divider
    }

}
