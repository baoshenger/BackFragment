package com.taofaqi.backfragment;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

public class FragmentA extends BaseFragment {
	private Button btnOpenB;
	private FragmentB fragmentB;
	public FragmentTransaction ft;
	FragmentManager fm;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_a_layout, container,
				false);
		btnOpenB = view.findViewById(R.id.btn_openb);
		btnOpenB.setOnClickListener(click);
		return view;
	}

	/**
	 * 重写回退事件，将当前fragment回退时所要做的操作放在此处
	 */
	@Override
	public boolean onBackPressed() {
		getFragmentManager().beginTransaction().remove(this).commit();
		return false;
	}

	OnClickListener click = new OnClickListener() {
		@Override
		public void onClick(View v) {
			fm = getFragmentManager();
			ft = fm.beginTransaction();
			fragmentB = new FragmentB();
			ft.add(R.id.v_fm_b, fragmentB, "fragemntB");
			ft.commit();
		}
	};

}
