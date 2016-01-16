package com.example.android06_viewpager01;

import java.util.List;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

public class MyPagerAdapter extends PagerAdapter{
	Context context;
	List<View> lists;
	public MyPagerAdapter(MainActivity mainActivity, List<View> lists) {
		context=mainActivity;
		this.lists=lists;
	}

	@Override
	public int getCount() {
		return lists.size();
	}
	/**看源码：在setAdapter中寻找isViewFromObject的所有信息*/
	@Override
	public boolean isViewFromObject(View arg0, Object arg1) {
		return arg0==arg1;
	}
	/**删除*/
	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		container.removeView(lists.get(position));
	}
	/**添加*/
	@Override
	public Object instantiateItem(ViewGroup container, int position) {
		View view=lists.get(position);
		container.addView(view, 0);
		return view;
	}
	
}
