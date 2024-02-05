package com.expediteapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;

public class ViewResult extends Activity {

	
	WebView resultView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_view_result);
		resultView = (WebView)findViewById(R.id.webView1);
		
		Intent i = getIntent();
		String resultPath = i.getStringExtra("result");
		resultView.setDownloadListener(null);
		resultView.loadUrl("http://docs.google.com/gview?embedded=true&url=http://xpditesolutions.com/xpditesolutions.pdf");
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
			intent = new Intent(new Intent(ViewResult.this,LoginActivity.class));
			intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK
					| intent.FLAG_ACTIVITY_CLEAR_TOP
					| Intent.FLAG_ACTIVITY_SINGLE_TOP);
			startActivity(intent);
			return true;
		
		}
		return super.onOptionsItemSelected(item);
	}
	

}
