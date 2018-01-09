package com.taofaqi.backfragment;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

public class FragmentB extends BaseFragment {
	private Button btnOpenC;
	private FragmentC fragmentC;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_b_layout, container,
				false);

		btnOpenC = (Button) view.findViewById(R.id.btn_openc);
		btnOpenC.setOnClickListener(click);

		return view;
	}

	/**
	 * 返回事件
	 */
	@Override
	public boolean onBackPressed() {
		//在当前fragment按回退键时不进行任何操作，将回退事件给它的上一级
		return true;
	}

	OnClickListener click = new OnClickListener() {

		@Override
		public void onClick(View v) {
			FragmentManager fm = getFragmentManager();
			FragmentTransaction ft = fm.beginTransaction();
			fragmentC = new FragmentC();
			ft.add(R.id.v_fm_c, fragmentC, "fragemntC");
			ft.addToBackStack(getTag());
			ft.commit();
		}
	};

}
