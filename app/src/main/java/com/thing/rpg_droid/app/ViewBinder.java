package com.thing.rpg_droid.app;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.TextView;

import com.thing.rpg_droid.res.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jon on 13/09/14.
 */
public class ViewBinder {

    protected abstract static class Binder {

        public abstract String getDisplayValue(Object pBoundObj);

        public boolean getReadOnly(Object pBoundObj) { return true; }
    }

    public abstract static class StringBinder extends Binder {

        @Override
        public String getDisplayValue(Object pBoundObj) { return this.getValue(pBoundObj); }

        public abstract String getValue(Object pBoundObj);

        public void setValue(Object pBoundObj, String pValue) { }
    }

    public abstract static class EditableStringBinder extends StringBinder {

        public boolean getReadOnly(Object pBoundObj) { return false; }
    }

    public abstract static class NumericBinder extends Binder {

        @Override
        public String getDisplayValue(Object pBoundObj) { return Integer.toString(this.getValue(pBoundObj)); }

        public abstract int getValue(Object pBoundObj);

        public int getMaximum(Object pBoundObj) { return Integer.MAX_VALUE; }

        public int getMinimum(Object pBoundObj) { return 0; }

        public void setValue(Object pBoundObj, int pValue) { }
    }

    public abstract static class EditableNumericBinder extends NumericBinder {

        public boolean getReadOnly(Object pBoundObj) { return false; }
    }

    private class Binding {

        protected View mField;

        private Binder mBinder;

        public Binding(View pField, final Binder pBinder)
        {
            mField = pField;

            mBinder = pBinder;

            if (!pBinder.getReadOnly(ViewBinder.this.mBoundObject))
            {
                pField.setOnLongClickListener(new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View v) {

                        if (pBinder instanceof StringBinder) {
                            LaunchTextInputDialog();
                        } else if (pBinder instanceof NumericBinder) {
                            LaunchNumericInputDialog();
                        }

                        return false;
                    }
                });
            }
        }

        public void updateField()
        {
            if (mBinder != null)
            {
                if (mField instanceof View_CharacterSheet_Field)
                    ((View_CharacterSheet_Field)mField).setValue(mBinder.getDisplayValue(ViewBinder.this.mBoundObject));
                else if (mField instanceof TextView)
                    ((TextView)mField).setText(mBinder.getDisplayValue(ViewBinder.this.mBoundObject));
            }
            else
            {
                if (mField instanceof View_CharacterSheet_Field)
                    ((View_CharacterSheet_Field)mField).setValue("-");
                else if (mField instanceof TextView)
                    ((TextView)mField).setText("-");
            }
        }

        private void LaunchNumericInputDialog()
        {
            AlertDialog.Builder lBuilder = new AlertDialog.Builder(ViewBinder.this.mContext);

            lBuilder.setTitle("New Value");

            final NumberPicker lPicker = new NumberPicker(ViewBinder.this.mContext);
            lPicker.setMinValue(((NumericBinder)mBinder).getMinimum(ViewBinder.this.mBoundObject));
            lPicker.setMaxValue(((NumericBinder)mBinder).getMaximum(ViewBinder.this.mBoundObject));
            lPicker.setDescendantFocusability(NumberPicker.FOCUS_BLOCK_DESCENDANTS);
            lPicker.setValue(((NumericBinder) mBinder).getValue(ViewBinder.this.mBoundObject));

            lBuilder.setView(lPicker);

            lBuilder.setPositiveButton(R.string.label_ok, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface lDialog, int which)
                {
                    ((NumericBinder) mBinder).setValue(ViewBinder.this.mBoundObject, lPicker.getValue());
                    Binding.this.updateField();

                    lDialog.dismiss();
                }
            }).setNegativeButton(R.string.label_cancel, new DialogInterface.OnClickListener()
            {
                @Override
                public void onClick(DialogInterface lDialog, int which)
                {
                    lDialog.dismiss();
                }
            });

            final AlertDialog lDialog = lBuilder.show();
        }

        private void LaunchTextInputDialog()
        {
            AlertDialog.Builder lBuilder = new AlertDialog.Builder(ViewBinder.this.mContext);

            lBuilder.setTitle("New Value");

            final EditText lEdit = new EditText(ViewBinder.this.mContext);

            lEdit.setText(((StringBinder) mBinder).getValue(ViewBinder.this.mBoundObject));

            lBuilder.setView(lEdit);

            lBuilder.setPositiveButton(R.string.label_ok, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface lDialog, int which)
                {
                    ((StringBinder) mBinder).setValue(ViewBinder.this.mBoundObject, lEdit.getText().toString());
                    Binding.this.updateField();

                    lDialog.dismiss();
                }
            }).setNegativeButton(R.string.label_cancel, new DialogInterface.OnClickListener()
            {
                @Override
                public void onClick(DialogInterface lDialog, int which)
                {
                    lDialog.dismiss();
                }
            });

            final AlertDialog lDialog = lBuilder.show();
        }
    }

    private List<Binding> mBindings = new ArrayList<Binding>();

    private Context mContext;

    private Object mBoundObject;

    public ViewBinder(Context pContext)
    {
        mContext = pContext;
    }

    public ViewBinder(Context pContext, Object pBoundObject)
    {
        mContext = pContext;
        mBoundObject = pBoundObject;
    }

    public Object getBoundObject()
    {
        return mBoundObject;
    }

    public void setBoundObject(Object pBoundObject)
    {
        mBoundObject = pBoundObject;

        update();
    }

    public void addBinding(View pView, Binder pBinder)
    {
        if ((pView != null) && (pBinder != null))
            mBindings.add(new Binding(pView, pBinder));
        else
            throw new IllegalArgumentException("Both view and binder must be supplied.");
    }

    public void update()
    {
        for(Binding lBinding : mBindings)
        {
            lBinding.updateField();
        }
    }

}
