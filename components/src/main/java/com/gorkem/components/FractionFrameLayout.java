package com.gorkem.components;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;

/**
 * Created by gorkem.karadogan on 25.11.2014.
 */
public class FractionFrameLayout extends FrameLayout {
    public FractionFrameLayout(Context context) {
        super(context);
    }

    public FractionFrameLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public FractionFrameLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public float getXFraction() {
        return getX() / getWidth(); // TODO: guard divide-by-zero
    }

    public void setXFraction(float xFraction) {
        // TODO: cache width
        final int width = getWidth();
        setX((width > 0) ? (xFraction * width) : -9999);
    }


}
