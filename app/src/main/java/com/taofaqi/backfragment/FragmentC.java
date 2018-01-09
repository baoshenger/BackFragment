package com.taofaqi.backfragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FragmentC extends BaseFragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_c_layout, container,
				false);
		return view;
	}

	@Override
	public boolean onBackPressed() {
		getFragmentManager().beginTransaction().remove(this).commit();
		return false;
	}

}
