package com.gorkem.components;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.gorkem.components.func.onImageViewClick;

public class EditFormImage extends EditForm {
	private static String TAG = "EditFormImage";

	private ImageView ivImage;
	private onImageViewClick mImageViewListener = null;

	public EditFormImage(Context context, AttributeSet attr) {
		super(context, attr);
		init(context, attr);
	}

//	public EditFormImage(Context context, AttributeSet attrs, int defStyle) {
//		super(context, attrs, defStyle);
//		init(context, attrs);
//
//	}

	private void init(Context context, AttributeSet attr) {

		super.removeAllViews();
		super.v = null;
		final LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View v = inflater.inflate(R.layout.btneditform, this);
		super.etForm = (EditText) v.findViewById(R.id.etForm);
		super.tvForm = (TextView) v.findViewById(R.id.tvForm);
		ivImage = (ImageView) v.findViewById(R.id.ivImage);
		super.baseinit(context, attr);

		final TypedArray a = context.obtainStyledAttributes(attr,
				R.styleable.EditFormImage);

		float imgWidth = a.getDimension(R.styleable.EditFormImage_imgWidth, 0);

		float imgHeight = a
				.getDimension(R.styleable.EditFormImage_imgHeight, 0);

		float imgPadding = a.getDimension(R.styleable.EditFormImage_imgPadding,
				0);
		
		int  imgVisibility = a.getInt(R.styleable.EditFormImage_imgVisibility, 0);
		
		switch (imgVisibility) {
		case 0:
			setImgVisibility(View.VISIBLE);
			break;
		case 1:
			setImgVisibility(View.INVISIBLE);
			break;
		case 2:
			setImgVisibility(View.GONE);
			break;

		default:
			break;
		}
		

		Drawable d = a.getDrawable(R.styleable.EditFormImage_android_src);

		if (imgPadding != 0)
			ivImage.setPadding((int) imgPadding, (int) imgPadding,
					(int) imgPadding, (int) imgPadding);

		if (d != null)
			ivImage.setImageDrawable(d);

		if (imgWidth != 0)
			ivImage.getLayoutParams().width = (int) imgWidth;

		if (imgHeight != 0)
			ivImage.getLayoutParams().height = (int) imgHeight;

		ivImage.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				if (mImageViewListener != null)
					mImageViewListener.onClicked();
			}
		});
	}

	public void setonImageViewClick(onImageViewClick mImageViewListener) {
		this.mImageViewListener = mImageViewListener;

	}

	public void setImgVisibility(int i) {
		this.ivImage.setVisibility(i);

	}

}
