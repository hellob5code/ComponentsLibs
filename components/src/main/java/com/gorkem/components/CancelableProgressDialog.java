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

import com.gorkem.components.func.onCancelProgressDialog;

public class CancelableProgressDialog extends ProgressDialog {
	private ProgressDialog dialog = null;

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
		super(context);
		this.instance = this;
		this._context = context;
		// TODO Auto-generated constructor stub

	}

	

	public static void settextColor(int txtColor) {
		textColor = txtColor;
	}

	public CancelableProgressDialog cancelShow(final String title,
			final String message, final ViewGroup v) {

		dialog = ProgressDialog.show(_context, title, message, true, true,
				new OnCancelListener() {

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

				dialog.setMessage(delayString);
			}
		}, delayTime);

		return instance;
	}

	@Override
	public void dismiss() {

		super.dismiss();
		dialog.dismiss();

	}

    @Override
    public void cancel() {
        super.cancel();
        dialog.cancel();
    }

    public void setonCancelProgressDialog(onCancelProgressDialog listener) {

		mCancelListener = listener;
	}

	public ProgressDialog getDialog() {
		return dialog;
	}

}
