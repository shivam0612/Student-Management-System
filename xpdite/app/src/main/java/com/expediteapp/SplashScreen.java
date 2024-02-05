package com.expediteapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;

public class SplashScreen extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash_screen);
		Handler handler = new Handler();
		handler.postDelayed(new Runnable() {
			public void run() {
				// TODO Auto-generated method stub
				finish();
				Intent intent = new Intent(getApplicationContext(),
						LoginActivity.class);
				intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK
						| intent.FLAG_ACTIVITY_CLEAR_TOP
						| Intent.FLAG_ACTIVITY_SINGLE_TOP);
				startActivity(intent);

			}
		}, 3000);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_splash_screen, menu);
		return true;
	}
}
