package com.clw.mysdk.base.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.Toast;
import com.clw.mysdk.utils.SharedPreferencesUtils;

/**
 * Fragment基类
 * <p>
 * 注意：导入的包是support.v4.app.Fragment;
 * 
 * @version 1.0.0
 * 
 * @date 2017-7-13 下午12:47:48
 * 
 * @author chenliwu
 */
public abstract class BaseFragment_SupportV4 extends Fragment {
	
	private final String TAG="BaseFragment_SupportV4";

	/**
	 * 基础视图
	 */
	protected View mBaseView;
	private Toast mToast;

	/**
	 * 上下文
	 */
	protected Context mContext;

	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mContext=getActivity();
	}
	
	/**
	 * 初始化Fragment
	 */
	protected abstract void initFragment();

	/**
	 * 初始化控件
	 */
	protected abstract void initView();

	/**
	 * 进入指定的Activity
	 * @param cls
	 */
	protected void startActivity(Class<?> cls){
		Intent intent=new Intent(mContext,cls);
		startActivity(intent);
	}

	/**
	 * 写入boolean变量至SharedPreferences中
	 * @param key
	 * @param value
	 */
	protected void putBooleanToSharedPreferences(String key, boolean value){
		if(mContext!=null){
			SharedPreferencesUtils.putBoolean(mContext,key,value);
		}
	}

	/**
	 * 读取boolean变量从SharedPreferences中
	 * @param key
	 * @param defValue
	 */
	protected boolean getBooleanFromSharedPreferences(String key, boolean defValue){
		if(mContext!=null){
			return SharedPreferencesUtils.getBoolean(mContext,key,defValue);
		}
		return defValue;
	}

	/**
	 * 获取String变量
	 * @param key
	 * @param defValue
	 * @return
	 */
	protected String getStringFromSharedPreferences(String key,String defValue){
		if(mContext!=null){
			return SharedPreferencesUtils.getString(mContext,key,defValue);
		}
		return defValue;
	}

	/**
	 * 写入String变量至SharedPreferences中
	 * @param key
	 * @param defValue
	 */
	protected void putStringToSharedPreferences(String key,String defValue){
		if(mContext!=null){
			SharedPreferencesUtils.putString(mContext,key,defValue);
		}
	}

	/**
	 * 读取int变量
	 * @param key
	 * @param defValue
	 * @return
	 */
	protected int getIntFromSharedPreferences(String key,int defValue){
		if(mContext!=null){
			return SharedPreferencesUtils.getInt(mContext,key,defValue);
		}
		return defValue;
	}

	/**
	 * 写入int变量至SharedPreferences中
	 * @param key
	 * @param defValue
	 */
	protected void putIntToSharedPreferences(String key,int defValue){
		if(mContext!=null){
			SharedPreferencesUtils.putInt(mContext,key,defValue);
		}
	}







	/**
	 * 显示短时间Toast
	 * @param content 显示文本内容
	 */
	protected void showShortToast(String content){
		if(content!=null && !content.isEmpty()){
			showToast(content, Toast.LENGTH_LONG);
		}
	}

	/**
	 * 显示长时间Toast
	 * @param content 显示文本内容
	 */
	protected void showLongToast(String content){
		if(content!=null && !content.isEmpty()){
			showToast(content, Toast.LENGTH_SHORT);
		}
	}

	/**
	 * 非阻塞试显示Toast,防止出现连续点击Toast时的显示问题
	 * @param text 提示内容
	 * @param duration 显示时长
	 */
	private void showToast(CharSequence text, int duration) {
		if (mToast == null) {
			mToast = Toast.makeText(mContext, text, duration);
		} else {
			mToast.setText(text);
			mToast.setDuration(duration);
		}
		mToast.show();
	}

}
