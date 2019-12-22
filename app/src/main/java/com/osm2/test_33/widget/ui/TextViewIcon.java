package com.osm2.test_33.widget.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by Administrator on 10/28/2019.
 */

@SuppressLint("AppCompatCustomView")
public class TextViewIcon
        extends TextView
{
    public TextViewIcon(Context paramContext, AttributeSet paramAttributeSet)
    {
        super(paramContext, paramAttributeSet);
    }

    public void setError(CharSequence paramCharSequence, Drawable paramDrawable)
    {
        if (paramCharSequence == null)
        {
            setCompoundDrawables(null, null, null, null);
            return;
        }
        paramDrawable.setBounds(10, 0, paramDrawable.getIntrinsicWidth() + 10, paramDrawable.getIntrinsicHeight());
        setCompoundDrawables(null, null, paramDrawable, null);
    }
}