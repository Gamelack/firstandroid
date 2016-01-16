package com.example.android06_viewpager01;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.widget.ImageView;
/**
 * pager-页
 * 广告轮播
 * @author pzp
 */
public class MainActivity extends Activity {
	ViewPager  viewPager;
	List<View> lists;
	int itemId=1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		viewPager=(ViewPager)findViewById(R.id.vp_picture);
		initList();
		PagerAdapter myPagerAdapter=new MyPagerAdapter(this,lists);
		viewPager.setAdapter(myPagerAdapter);
		viewPager.setCurrentItem(0);
		AutoThread autoThread=new AutoThread();
		autoThread.start();
		viewPager.setOnPageChangeListener(new OnPageChangeListener() {
			/**页面结束以后位于哪个位置*/
			@Override
			public void onPageSelected(int arg0) {
				itemId=arg0;
			}
			
			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onPageScrollStateChanged(int arg0) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	Handler handler=new Handler(new Callback() {
		
		@Override
		public boolean handleMessage(Message msg) {
			if(0==msg.what){
				int id=Integer.valueOf(msg.obj.toString());
				viewPager.setCurrentItem(id);
			}
			return true;
		}
	});
	/**线程的两种实现方式*/
	class AutoThread extends Thread{
		@Override
		public void run() {
			while (true) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				Message msg=new Message();
				msg.what=0;//标志：哪种控件、类别更新
				msg.obj=itemId%lists.size();//值
				handler.sendMessage(msg);
				itemId++;
			}
		}
	}
	
	private void initList() {
		lists=new ArrayList<View>();
		ImageView iv1=new ImageView(this);
		iv1.setBackgroundResource(R.drawable.a);
		ImageView iv2=new ImageView(this);
		iv2.setBackgroundResource(R.drawable.b);
		ImageView iv3=new ImageView(this);
		iv3.setBackgroundResource(R.drawable.c);
		ImageView iv4=new ImageView(this);
		iv4.setBackgroundResource(R.drawable.d);
		ImageView iv5=new ImageView(this);
		iv5.setBackgroundResource(R.drawable.e);
		ImageView iv6=new ImageView(this);
		iv6.setBackgroundResource(R.drawable.f);
		ImageView iv7=new ImageView(this);
		iv7.setBackgroundResource(R.drawable.g);
		ImageView iv8=new ImageView(this);
		iv8.setBackgroundResource(R.drawable.h);
		lists.add(iv8);
		lists.add(iv7);
		lists.add(iv6);
		lists.add(iv5);
		lists.add(iv4);
		lists.add(iv3);
		lists.add(iv2);
		lists.add(iv1);
	}


}
