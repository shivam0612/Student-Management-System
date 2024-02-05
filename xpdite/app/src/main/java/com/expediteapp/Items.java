package com.expediteapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class Items extends BaseAdapter {

	Context context;
	String[] items;
	Integer[] icons;

	public Items(Context c, String[] items,Integer[] icons) {
		// TODO Auto-generated constructor stub
		this.context = c;
		this.items = items;
		this.icons = icons;
	}

	public int getCount() {
		// TODO Auto-generated method stub
		return items.length;
	}

	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}

	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	public View getView(int arg0, View arg1, ViewGroup arg2) {
		// TODO Auto-generated method stub
		LayoutInflater inflater =(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View view = inflater.inflate(R.layout.activity_item_list,arg2,false);
		TextView tv = (TextView)view.findViewById(R.id.tvListItem);
		tv.setText(items[arg0]);
		ImageView iconView = (ImageView)view.findViewById(R.id.iconView);
		iconView.setImageResource(icons[arg0]);
		return view;
		
	}
}
