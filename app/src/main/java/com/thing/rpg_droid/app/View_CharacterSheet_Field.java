package com.thing.rpg_droid.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
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
    private String mLabel = "2347823";

    private int mLabelFontSize;

    private int mLabelWidth;

    private String mValue = "thingyasdasd";

    private int mValueFontSize;

    private int mBorderRadius = 0;

    private int mLabelColor = 0xFF000000;

    private int mValueColor = 0xFF000000;

    private Paint mBorderStroke;

    private Paint mTextBrush = new Paint();

    private RectF mBorderRect;

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

    private void Init(Context pContext, AttributeSet pAttrs, int pDefStyleAttr)
    {
        DisplayMetrics dm = getResources().getDisplayMetrics();

        TypedArray aTypedArray = pContext.obtainStyledAttributes(pAttrs, R.styleable.View_CharacterSheet_Field, pDefStyleAttr, 0);

        mValueColor = aTypedArray.getColor(R.styleable.View_CharacterSheet_Field_valueColor, mValueColor);

        mValueFontSize = (int)(Math.round(12 * dm.scaledDensity));
        mValueFontSize = aTypedArray.getDimensionPixelSize(R.styleable.View_CharacterSheet_Field_valueFontSize, mValueFontSize);

        mLabelColor = aTypedArray.getColor(R.styleable.View_CharacterSheet_Field_labelColor, mLabelColor);

        mLabelFontSize = (int)(Math.round(8 * dm.scaledDensity));
        mLabelFontSize = aTypedArray.getDimensionPixelSize(R.styleable.View_CharacterSheet_Field_valueFontSize, mLabelFontSize);

        mBorderRadius = aTypedArray.getDimensionPixelSize(R.styleable.View_CharacterSheet_Field_borderColor, mBorderRadius);

        mLabel = "2342324";//aTypedArray.getString(R.styleable.View_CharacterSheet_Field_label);
        mValue = "klqweo";//aTypedArray.getString(R.styleable.View_CharacterSheet_Field_value);

        int lBorderStrokeWidth = aTypedArray.getDimensionPixelSize(R.styleable.View_CharacterSheet_Field_borderWidth, 0);
        int lBorderStrokeColor = aTypedArray.getColor(R.styleable.View_CharacterSheet_Field_borderColor, 0xFFFFFFFF);

        if (lBorderStrokeWidth != 0)
        {
            mBorderStroke = new Paint();
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
        int lHeight = Math.max(getSuggestedMinimumHeight(), mValueFontSize);

        if ((mLabel != null) && (!mLabel.equals("")))
        {
            mTextBrush.setTextSize(mLabelFontSize);
            mLabelWidth = (int)Math.ceil(mTextBrush.measureText(mLabel));

            lWidth = Math.max(mLabelWidth + 5, lWidth);
        }

        if ((mValue != null) && (!mValue.equals("")))
        {
            mTextBrush.setTextSize(mValueFontSize);
            lWidth += (int) Math.ceil(mTextBrush.measureText(mValue));
        }

        mBorderRect = new RectF(0, 0, lWidth, lHeight);

        setMeasuredDimension(lWidth, lHeight);
    }

    @Override
    protected void onDraw (Canvas pCanvas)
    {
        super.onDraw(pCanvas);

        if ((mLabel != null) && (!mLabel.equals("")))
        {
            mTextBrush.setColor(mLabelColor);
            mTextBrush.setTextSize(mLabelFontSize);
            pCanvas.drawText(mLabel, 0, 0, mTextBrush);
        }

        if ((mValue != null) && (!mValue.equals("")))
        {
            mTextBrush.setColor(mValueColor);
            mTextBrush.setTextSize(mLabelFontSize);
            pCanvas.drawText(mValue, mLabelWidth, 0, mTextBrush);
        }

        if (mBorderStroke != null)
        {
            if (mBorderRadius != 0)
                pCanvas.drawRoundRect(mBorderRect, mBorderRadius, mBorderRadius, mBorderStroke);
            else
                pCanvas.drawRect(mBorderRect, mBorderStroke);
        }
        //paint border
    }

}
