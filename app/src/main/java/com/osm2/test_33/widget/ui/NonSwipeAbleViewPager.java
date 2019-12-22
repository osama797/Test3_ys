package com.osm2.test_33.widget.ui;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

public class NonSwipeAbleViewPager
        extends ViewPager
{
    public NonSwipeAbleViewPager(Context paramContext)
    {
        super(paramContext);
    }

    public NonSwipeAbleViewPager(Context paramContext, AttributeSet paramAttributeSet)
    {
        super(paramContext, paramAttributeSet);
    }

    public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
    {
        return false;
    }

    public boolean onTouchEvent(MotionEvent paramMotionEvent)
    {
        return false;
    }
}
