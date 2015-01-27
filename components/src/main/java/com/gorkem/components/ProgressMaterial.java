package com.gorkem.components;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.gorkem.components.MDialog.MaterialDialog;

/**
 * Created by gorkem.karadogan on 1/8/2015.
 */
public class ProgressMaterial {

    public static TextView message;


    public static MaterialDialog show(Context mContext, String Tittle, String Message, Boolean isCancel) {

        MaterialDialog.Builder mBuilder = new MaterialDialog.Builder(mContext);
        mBuilder.title(Tittle);
        View view = LayoutInflater.from(mContext).inflate(R.layout.progress_dialog, null);
        TextView message = (TextView) view.findViewById(R.id.message);
        message.setText(Message);
        mBuilder.customView(view, false);

        MaterialDialog dialog = mBuilder.build();
        dialog.setCanceledOnTouchOutside(isCancel);
        dialog.show();

        return dialog;

    }

    public static MaterialDialog show(Context mContext, String Message, Boolean isCancel) {

        MaterialDialog.Builder mBuilder = new MaterialDialog.Builder(mContext);

        View view = LayoutInflater.from(mContext).inflate(R.layout.progress_dialog, null);
        message = (TextView) view.findViewById(R.id.message);
        message.setText(Message);
        mBuilder.customView(view, false);

        MaterialDialog dialog = mBuilder.build();
        dialog.setCanceledOnTouchOutside(isCancel);
        dialog.show();

        return dialog;

    }

    public static String getTextMessage() {
        if (ProgressMaterial.message != null)
            return message.toString();

        return null;
    }

    public static void setTextMessage(String message) {
        if (ProgressMaterial.message != null)
            ProgressMaterial.message.setText(message);


    }
}
