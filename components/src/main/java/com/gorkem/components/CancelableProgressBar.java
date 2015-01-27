package com.gorkem.components;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.gorkem.components.func.onCancelableProgressBarListener;

public class CancelableProgressBar extends RelativeLayout implements Runnable {
    private View cancelbar;
    private View canceldialogerror;
    private Context _context;
    private PBCircleInfite pb;
    private TextView tv;
    private static CancelableProgressBar instance;
    private static int tvColor = android.R.color.black;
    private static int tvDimen = R.dimen.tvsize;

    private static int delayTime = 5000;
    private static String delayString = "İşleminiz beklenenden uzun sürdü, gecikme için özür dileriz.";


    public static void setdelayString(String delay) {
        delayString = delay;
    }

    public static void setDelayTime(int delay) {
        delayTime = delay;
    }

    private onCancelableProgressBarListener mlistener = null;
    private Handler handler;

    public void setonCancelableProgressBarListener(onCancelableProgressBarListener mlistener) {
        this.mlistener = mlistener;
    }

    public static void setTvColor(int tvColor) {
        CancelableProgressBar.tvColor = tvColor;
    }

    public static void setTvDimen(int tvDimen) {
        CancelableProgressBar.tvDimen = tvDimen;
    }

    public CancelableProgressBar(Context context) {
        super(context);
        this._context = context;
        this.instance = this;
        setLayoutParams(new LayoutParams(
                LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
        inflateLayout(context);

    }

    public CancelableProgressBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        this._context = context;
        this.instance = this;
        inflateLayout(context);
    }

    private void inflateLayout(Context context) {

        cancelbar = LayoutInflater.from(_context).inflate(R.layout.cancelbar,
                null);
        canceldialogerror = LayoutInflater.from(_context).inflate(
                R.layout.canceldialogerror, null);
        addViews(cancelbar);
        pb = (PBCircleInfite) cancelbar.findViewById(R.id.pbProcess);
        tv = (TextView) cancelbar.findViewById(R.id.tvPbProcess);

        handler = new Handler();
        handler.postDelayed(instance, delayTime);


        cancelbar.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View vs) {
                Canceled();
            }
        });

        canceldialogerror.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                Loaded();
            }
        });
    }

    public void cancel() {
        Canceled();
    }

    private void Canceled() {
        if (mlistener != null) {
            mlistener.onCanceled();
        }
        removeAllViews();
        handler.postDelayed(instance, delayTime);
        addViews(canceldialogerror);

    }

    private void Loaded() {
        if (mlistener != null) {
            mlistener.onLoadAgain();
        }
        handler.removeCallbacks(instance);
        addViews(cancelbar);

    }

    @Override
    public void run() {

        tv.setText(delayString);
    }

    public void addViews(View v) {
        removeAllViews();
        addView(v, new LayoutParams(
                LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
    }

}
