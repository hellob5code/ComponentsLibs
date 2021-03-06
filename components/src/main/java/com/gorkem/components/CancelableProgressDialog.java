package com.gorkem.components;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.gorkem.components.MDialog.MaterialDialog;
import com.gorkem.components.func.onCancelProgressDialog;

public class CancelableProgressDialog {
    private MaterialDialog mDialog = null;

    private static int _drawable = R.drawable.backtoview;
    private static int textColor = android.R.color.black;


    private static int delayTime = 15000;
    private static String delayString = "İşleminiz beklenenden uzun sürdü, gecikme için özür dileriz.";


    public static void setdelayString(String delay) {
        delayString = delay;
    }

    public static void setDelayTime(int delay) {
        delayTime = delay;
    }


    private static CancelableProgressDialog instance;
    Context _context = null;
    private onCancelProgressDialog mCancelListener = null;

    public CancelableProgressDialog(Context context) {
        this.instance = this;
        this._context = context;
    }


    public static void settextColor(int txtColor) {
        textColor = txtColor;
    }

    public CancelableProgressDialog cancelShow(final String title,
                                               final String message, final ViewGroup v) {

        try {
            mDialog = ProgressMaterial.show(_context, title, message, true);

            mDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
                @Override
                public void onCancel(DialogInterface dialog) {
                    v.removeAllViews();
                    View cancelView = LayoutInflater.from(_context)
                            .inflate(R.layout.canceldialogerror, null);

                    ImageView iv = (ImageView) cancelView
                            .findViewById(R.id.ivErrorButton);
                    TextView tv = (TextView) cancelView
                            .findViewById(R.id.tvError);
                    tv.setTextColor(textColor);


                    iv.setImageDrawable(_context.getResources()
                            .getDrawable(_drawable));
                    v.addView(cancelView);

                    if (mCancelListener != null)
                        mCancelListener.onCanceled(cancelView, iv, tv);
                }
            });

            Handler handler = new Handler();

            handler.postDelayed(new Runnable() {

                @Override
                public void run() {
                    ProgressMaterial.setTextMessage(delayString);
                }
            }, delayTime);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return instance;


    }

    public CancelableProgressDialog cancelShow(final String message, final ViewGroup v) {

        try {
            mDialog = ProgressMaterial.show(_context,  message, true);

            mDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
                @Override
                public void onCancel(DialogInterface dialog) {
                    v.removeAllViews();
                    View cancelView = LayoutInflater.from(_context)
                            .inflate(R.layout.canceldialogerror, null);

                    ImageView iv = (ImageView) cancelView
                            .findViewById(R.id.ivErrorButton);
                    TextView tv = (TextView) cancelView
                            .findViewById(R.id.tvError);
                    tv.setTextColor(textColor);


                    iv.setImageDrawable(_context.getResources()
                            .getDrawable(_drawable));
                    v.addView(cancelView);

                    if (mCancelListener != null)
                        mCancelListener.onCanceled(cancelView, iv, tv);
                }
            });

            Handler handler = new Handler();

            handler.postDelayed(new Runnable() {

                @Override
                public void run() {
                    ProgressMaterial.setTextMessage(delayString);
                }
            }, delayTime);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return instance;


    }

    public void dismiss() {
        mDialog.dismiss();
    }

    public void cancel() {
        mDialog.cancel();
    }

    public void setonCancelProgressDialog(onCancelProgressDialog listener) {

        mCancelListener = listener;
    }

    public MaterialDialog getDialog() {
        return mDialog;
    }

}
