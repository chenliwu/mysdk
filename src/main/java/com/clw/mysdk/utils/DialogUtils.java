package com.clw.mysdk.utils;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;

/**
 * Created by Horrarndoo on 2017/8/31.
 * <p>
 * 对话框工具类, 提供常用对话框显示, 使用support.v7包内的AlertDialog样式
 */
public class DialogUtils {

    public static Dialog createProgressDialog(Context context) {
        return createProgressDialog(context, true);
    }

    public static Dialog createProgressDialog(Context context, boolean needCancle) {
        ProgressDialog dialog = new ProgressDialog(context);
        dialog.setMessage("Loading ...");
        dialog.setCancelable(needCancle);
        dialog.setCanceledOnTouchOutside(false);
        return dialog;
    }

    public static Dialog showCommonDialog(Context context, String message,
                                          DialogInterface.OnClickListener listener) {
        return showCommonDialog(context, message, "确认",
                "取消", listener);
    }

    public static Dialog showCommonDialog(Context context, String message, String positiveText,
                                          String negativeText, DialogInterface.OnClickListener
                                                  listener) {
        return new AlertDialog.Builder(context)
                .setMessage(message)
                .setPositiveButton(positiveText, listener)
                .setNegativeButton(negativeText, null)
                .show();
    }

    public static Dialog showConfirmDialog(Context context, String message,
                                           DialogInterface.OnClickListener listener) {
        return showConfirmDialog(context, message, "确认",
                listener);
    }

    public static Dialog showConfirmDialog(Context context, String message, String positiveText,
                                           DialogInterface.OnClickListener listener) {
        return new AlertDialog.Builder(context)
                .setMessage(message)
                .setPositiveButton(positiveText, listener)
                .show();
    }
}
