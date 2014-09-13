package com.thing.rpg_droid.app;

import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jon on 13/09/14.
 */
public class ViewBinder {

    protected abstract static class Binder {

        public abstract String getValue();

        public boolean getReadOnly() { return true; }
    }

    public abstract static class StringBinder extends Binder {

        public void setValue(String pValue) { }
    }

    public abstract static class NumericBinder extends Binder {

        public int getMaximum() { return Integer.MAX_VALUE; }

        public int getMinimum() { return 0; }

        public void setValue(int pValue) { }
    }

    private static class Binding {

        protected View_CharacterSheet_Field mField;

        private Binder mBinder;

        public Binding(View_CharacterSheet_Field pField, Binder pBinder)
        {
            mField = pField;

            mBinder = pBinder;

            if (!pBinder.getReadOnly())
            {
                pField.setOnLongClickListener(new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View v) {

                        //TODO launch modification entry dialog

                        return false;
                    }
                });
            }
        }

        public void UpdateField()
        {
            if (mBinder != null)
            {
                mField.setValue(mBinder.getValue());
            }
            else
            {
                mField.setValue("-");
            }
        }
    }

    private List<Binding> mBindings = new ArrayList<Binding>();

    public ViewBinder()
    {

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
            lBinding.UpdateField();
        }
    }

}
