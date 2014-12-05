package com.gorkem.components;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.Editable;
import android.text.Html;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.gorkem.components.func.onEditTextChangeListener;

/**
 * Created by gorkem.karadogan on 23.10.2014.
 */

public class EditForm extends LinearLayout {

	public static String TAG = "EditForm";
	protected EditText etForm;
	protected TextView tvForm;
	protected View v;

	private onEditTextChangeListener mTextListener;

	public EditForm(Context context, AttributeSet attr) {
		super(context, attr);

		inflateLayout(context);

		findViews();
		baseinit(context, attr);

	}

//	public EditForm(Context context, AttributeSet attrs, int defStyle) {
//
//		super(context, attrs, defStyle);
//		inflateLayout(context);
//		findViews();
//		baseinit(context, attrs);
//
//	}

	private void inflateLayout(Context context) {

		final LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		v = inflater.inflate(R.layout.editform, this);
	}

	protected void findViews() {
		this.tvForm = (TextView) findViewById(R.id.tvForm);

		this.etForm = (EditText) findViewById(R.id.etForm);
	}

	protected void baseinit(Context context, AttributeSet attr) {

		final TypedArray a = context.obtainStyledAttributes(attr,
				R.styleable.EditForm);
		String labelText = a.getString(R.styleable.EditForm_labelText);
		String editText = a.getString(R.styleable.EditForm_editText);

		String editHint = a.getString(R.styleable.EditForm_editHint);

		boolean editEnable = a
				.getBoolean(R.styleable.EditForm_editEnable, true);
		boolean editSingleLine = a.getBoolean(
				R.styleable.EditForm_editSingleLine, false);
		boolean must = a.getBoolean(R.styleable.EditForm_must, false);

		float width = a.getDimension(R.styleable.EditForm_labelWidth, 0);

		float labelSize = a.getDimension(R.styleable.EditForm_labelSize, 0);
		float editSize = a.getDimension(R.styleable.EditForm_editSize, 0);

		int labelColor = a.getColor(R.styleable.EditForm_labelcolor, 0);
		int editColor = a.getColor(R.styleable.EditForm_editcolor, 0);

		int inputType = a.getInt(R.styleable.EditForm_android_inputType,
				EditorInfo.TYPE_CLASS_TEXT);

		if (editText != null)
			etForm.setText(editText);

		if (editHint != null)
			etForm.setHint(editHint);

		if (editEnable == false)
			etForm.setEnabled(false);

		if (editSingleLine == true)
			etForm.setSingleLine();

		if (editSize != 0)
			etForm.setTextSize(TypedValue.COMPLEX_UNIT_PX, editSize);

		if (editColor != 0)
			etForm.setTextColor(editColor);

		etForm.setInputType(inputType);

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

		etForm.addTextChangedListener(new TextWatcher() {

			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {


			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {


			}

			@Override
			public void afterTextChanged(Editable s) {

				// Notify the listener
				if (mTextListener != null) {
					mTextListener.onChanged(s.toString());
				}
			}
		});
	}

	public void setonEditTextChangeListener(
			onEditTextChangeListener mTextListener) {
		this.mTextListener = mTextListener;
	}

	public void setEditTextTAG(Object tag) {
		this.etForm.setTag(tag);
	}

	public Object getEditTextTAG() {
		return etForm.getTag();
	}

	public void setEditTextID(int ID) {
		this.etForm.setId(ID);
	}

	public int getEditTextID() {
		return this.etForm.getId();
	}

	public void setEditTextString(String a) {
		this.etForm.setText(a);
	}

	public void setTextViewString(String a) {
		this.tvForm.setText(a);
	}

	public String getEditTextString() {
		return this.etForm.getText().toString();
	}

	public String getTextViewString() {
		return this.tvForm.getText().toString();
	}

	public EditText getEtForm() {
		return etForm;
	}

	public TextView getTvForm() {
		return tvForm;
	}

	public void setEditEnable(boolean i) {
		this.etForm.setEnabled(i);

	}

}
