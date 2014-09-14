package com.thing.rpg_droid.app;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.widget.EditText;
import android.widget.NumberPicker;

import com.thing.rpg_droid.res.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jon on 13/09/14.
 */
public class ViewBinder {

    protected abstract static class Binder {

        public abstract String getDisplayValue();

        public boolean getReadOnly() { return true; }
    }

    public abstract static class StringBinder extends Binder {

        @Override
        public String getDisplayValue() { return this.getValue(); }

        public abstract String getValue();

        public void setValue(String pValue) { }
    }

    public abstract static class EditableStringBinder extends StringBinder {

        public boolean getReadOnly() { return false; }
    }

    public abstract static class NumericBinder extends Binder {

        @Override
        public String getDisplayValue() { return Integer.toString(this.getValue()); }

        public abstract int getValue();

        public int getMaximum() { return Integer.MAX_VALUE; }

        public int getMinimum() { return 0; }

        public void setValue(int pValue) { }
    }

    public abstract static class EditableNumericBinder extends NumericBinder {

        public boolean getReadOnly() { return false; }
    }

    private class Binding {

        protected View_CharacterSheet_Field mField;

        private Binder mBinder;

        public Binding(View_CharacterSheet_Field pField, final Binder pBinder)
        {
            mField = pField;

            mBinder = pBinder;

            if (!pBinder.getReadOnly())
            {
                pField.setOnLongClickListener(new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View v) {

                        if (pBinder instanceof StringBinder) {
                            LaunchTextInputDialog();;
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
                mField.setValue(mBinder.getDisplayValue());
            }
            else
            {
                mField.setValue("-");
            }
        }

        private void LaunchNumericInputDialog()
        {
            AlertDialog.Builder lBuilder = new AlertDialog.Builder(ViewBinder.this.mContext);

            lBuilder.setTitle("New Value");

            final NumberPicker lPicker = new NumberPicker(ViewBinder.this.mContext);
            lPicker.setMinValue(((NumericBinder)mBinder).getMinimum());
            lPicker.setMaxValue(((NumericBinder)mBinder).getMaximum());
            lPicker.setDescendantFocusability(NumberPicker.FOCUS_BLOCK_DESCENDANTS);
            lPicker.setValue(((NumericBinder) mBinder).getValue());

            lBuilder.setView(lPicker);

            lBuilder.setPositiveButton(R.string.label_ok, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface lDialog, int which)
                {
                    ((NumericBinder) mBinder).setValue(lPicker.getValue());
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

            lEdit.setText(((StringBinder) mBinder).getValue());

            lBuilder.setView(lEdit);

            lBuilder.setPositiveButton(R.string.label_ok, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface lDialog, int which)
                {
                    ((StringBinder) mBinder).setValue(lEdit.getText().toString());
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

    public ViewBinder(Context pContext)
    {
        mContext = pContext;
    }

    public void addBinding(View_CharacterSheet_Field pView, Binder pBinder)
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
