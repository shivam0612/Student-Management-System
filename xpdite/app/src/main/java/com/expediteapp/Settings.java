package com.expediteapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class Settings extends Activity implements OnClickListener,
OnTouchListener{
	ListView ItemsView;
	String[] Items={"Change Pin"};
	Integer[] icons={R.drawable.icoupdatepin};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_settings);
		

		Items adapter = new Items(this, Items,icons);
		ItemsView = (ListView) findViewById(R.id.listView1);
		ItemsView.setAdapter(adapter);
		ListclickEvent();
	}

	
	private void ListclickEvent() {

		ItemsView.setOnItemClickListener(new OnItemClickListener() {

			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {				
				
				if(arg2==0){
					Intent intent = new Intent(getApplicationContext(),RegisterMobile.class);
					intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|intent.FLAG_ACTIVITY_CLEAR_TOP|Intent.FLAG_ACTIVITY_SINGLE_TOP);
					startActivity(intent);	
				}
				else if(arg2==1){
					
				}
				else if(arg2==2){
				
				}
	                
	               
				

			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		menu.add(0,1,0,"Logout");
		return true;
	}
	

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		Intent intent;
		switch (item.getItemId()) {
		case 1:
			intent = new Intent(new Intent(Settings.this,LoginActivity.class));
			intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK
					| intent.FLAG_ACTIVITY_CLEAR_TOP
					| Intent.FLAG_ACTIVITY_SINGLE_TOP);
			startActivity(intent);
			return true;

		
		}
		return super.onOptionsItemSelected(item);
	}


	public boolean onTouch(View v, MotionEvent event) {
		// TODO Auto-generated method stub
		return false;
	}

	public void onClick(View v) {
		// TODO Auto-generated method stub
		
	}

}
