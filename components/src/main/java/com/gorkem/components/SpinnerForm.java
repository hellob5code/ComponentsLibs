package com.gorkem.components;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.Html;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.gorkem.components.func.onSpinnerItemChanged;

public class SpinnerForm extends LinearLayout {

	private onSpinnerItemChanged mSpinnerChanged = null;
	private TextView tvForm;
	private Spinner spForm;
	protected View v;

	public SpinnerForm(Context context, AttributeSet attr) {
		super(context, attr);
		inflateLayout(context);
		findViews();
		baseinit(context, attr);

	}

//	public SpinnerForm(Context context, AttributeSet attrs, int defStyle) {
//
//		super(context, attrs, defStyle);
//		inflateLayout(context);
//		findViews();
//		baseinit(context, attrs);
//
//	}

	protected void findViews() {
		this.tvForm = (TextView) v.findViewById(R.id.tvForm);

		this.spForm = (Spinner) v.findViewById(R.id.spForm);
	}

	private void inflateLayout(Context context) {

		final LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		v = inflater.inflate(R.layout.spinnerform, this);
	}

	protected void baseinit(Context context, AttributeSet attr) {

		final TypedArray a = context.obtainStyledAttributes(attr,
				R.styleable.EditForm);
		String labelText = a.getString(R.styleable.EditForm_labelText);
		boolean must = a.getBoolean(R.styleable.EditForm_must, false);
		float width = a.getDimension(R.styleable.EditForm_labelWidth, 0);
		float labelSize = a.getDimension(R.styleable.EditForm_labelSize, 0);
		int labelColor = a.getColor(R.styleable.EditForm_labelcolor, 0);

		if (must) {
			String styledText = "<font color='red'>*</font>";
			tvForm.setText(Html.fromHtml(labelText + styledText));
		} else {
			if (labelText != null)
				tvForm.setText(labelText);
		}

		if (labelSize != 0)
			tvForm.setTextSize(TypedValue.COMPLEX_UNIT_PX, labelSize);

		if (labelColor != 0)
			tvForm.setTextColor(labelColor);

		if (width != 0)
			tvForm.getLayoutParams().width = (int) width;

		a.recycle();

		spForm.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {

				if (mSpinnerChanged != null) {

					mSpinnerChanged.onItemChanged(parent, view, position, id);
				}
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {


			}
		});
		
		TypedArray b = context.obtainStyledAttributes(attr,
				R.styleable.SpinnerForm);
		
		boolean enable = a.getBoolean(R.styleable.SpinnerForm_SpinnerEnable, true);
		
		spForm.setEnabled(enable);
		b.recycle();

	}

	public void setonSpinnerItemChanged(onSpinnerItemChanged mSpinnerChanged) {
		this.mSpinnerChanged = mSpinnerChanged;
	}

	public <T> void setSpinnerAdapter(ArrayAdapter<T> adapter) {
		this.spForm.setAdapter(adapter);
	}

	public int getSpinnerSelectedItemPosition() {
		return this.spForm.getSelectedItemPosition();
	}

	public Spinner getSpForm() {
		return spForm;
	}

	public void setSelection(int i) {
		spForm.setSelection(i);

	}

	public void setSpEnable(boolean i) {
		spForm.setEnabled(i);
	}
}
