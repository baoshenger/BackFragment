package com.taofaqi.backfragment;

import android.app.Fragment;
/**
 * 父类的fragment
 * @author tmy
 *
 */
public abstract class BaseFragment extends Fragment {
	public IOnFragmentBackPressed backPressed;

	/**
	 * 每个fragment的回调事件
	 * @return
	 */
	public abstract boolean onBackPressed();
	

	/**
	 * 在fragment初始化的时候讲它添加到activity的集合中
	 */
	@Override
	public void onStart() {
		super.onStart();
		backPressed = (IOnFragmentBackPressed) getActivity();
		backPressed.setFragment(this);
	}
}
