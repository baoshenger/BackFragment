package com.taofaqi.backfragment;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * 多个fragment嵌套,获取回退Demo
 * @author tmy
 *
 */
public class MainActivity extends FragmentActivity implements
        IOnFragmentBackPressed {
    public FragmentTransaction ft;
    FragmentManager fm;
    List<BaseFragment> baseFragmentList;//用来存储打开的所有fragment

    @Override
    protected void onCreate(@Nullable Bundle arg0) {
        super.onCreate(arg0);
        setContentView(R.layout.activity_main);

        baseFragmentList = new ArrayList<BaseFragment>();//初始化list

        //显示一个fragment
        fm = getFragmentManager();
        ft = fm.beginTransaction();
        FragmentA fragmentA = new FragmentA();
        ft.add(R.id.v_fm_a, fragmentA, "fragemntA");
        ft.commit();
    }

    /**
     * activity的回退事件
     */
    @Override
    public void onBackPressed() {
        if (baseFragmentList != null && baseFragmentList.size() > 0) {//判断一下当前是否有fragment
            int size = baseFragmentList.size();
            if (baseFragmentList.get(size - 1).onBackPressed()) {//调用fragment的回退事件（每个fragment的回退逻辑代码都放在里面）
                //这里true表示当前的fragment不做任何操做，把回退事件交给它的上一级
                baseFragmentList.remove(size - 1);//将当前的fragment从集合中移除
                onBackPressed();//再次调用activity的回退
            } else {
                //这里表示回退事件已经被当前fragment给消费了
                baseFragmentList.remove(size - 1);
            }
        } else {
            super.onBackPressed();//执行activity回退
        }

    }

    //重写fragment的setFragment方法，将fragment放入activity的集合中
    @Override
    public void setFragment(BaseFragment fragment) {
        baseFragmentList.add(fragment);
    }

}
