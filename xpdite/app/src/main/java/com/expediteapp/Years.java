package com.expediteapp;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class Years extends Activity {

	private static String NAMESPACE = "http://tempuri.org/";
	private static String SOAP_ACTION1 = "http://tempuri.org/getResult";
	private static String METHOD_NAME1 = "getResult";
	private static String URL = GetIp.ip();

	ListView ItemsView;
	String[] Items = null;
	Integer[] icons = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_years);

		new myTask().execute();

	}

	private void ListclickEvent() {

		ItemsView.setOnItemClickListener(new OnItemClickListener() {

			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {

				// code to view pdf i.e call to view result activity.

				startActivity(new Intent(
						Intent.ACTION_VIEW,
						Uri.parse("http://docs.google.com/gview?embedded=true&url=http://testm.vayuna.com/results/"
								+ Items[arg2] + ".pdf")));

			}
		});
	}

	public String[] getResults() {

		String[] results = null;

		String sid = LoginDtls.getSid();

		Intent i = getIntent();
		String yeartext = i.getStringExtra("yeartext");

		SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME1);
		request.addProperty("sid", sid);
		request.addProperty("yeartext", yeartext);
		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
				SoapEnvelope.VER11);
		envelope.setOutputSoapObject(request);
		envelope.dotNet = true;
		try {
			HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);
			androidHttpTransport.call(SOAP_ACTION1, envelope);
			SoapObject result = (SoapObject) envelope.bodyIn;
			if (result != null) {
				String obtained = result.getProperty(0).toString();
				results = obtained.split(",");

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return results;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		menu.add(0, 1, 0, "Main Menu").setIcon(R.drawable.taskbar_start_menu);
		menu.add(0, 2, 1, "Student Info").setIcon(R.drawable.information);
		menu.add(0, 3, 2, "Settings").setIcon(R.drawable.setting);
		menu.add(0, 4, 3, "Logout");
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		Intent intent;
		switch (item.getItemId()) {
		case 1:
			intent = new Intent(getApplicationContext(), ListActivity.class);
			intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK
					| intent.FLAG_ACTIVITY_CLEAR_TOP
					| Intent.FLAG_ACTIVITY_SINGLE_TOP);
			startActivity(intent);
			return true;
		case 2:
			intent = new Intent(getApplicationContext(), StudInfo.class);
			intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK
					| intent.FLAG_ACTIVITY_CLEAR_TOP
					| Intent.FLAG_ACTIVITY_SINGLE_TOP);
			startActivity(intent);
			return true;
		case 3:
			intent = new Intent(getApplicationContext(), Settings.class);
			intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK
					| intent.FLAG_ACTIVITY_CLEAR_TOP
					| Intent.FLAG_ACTIVITY_SINGLE_TOP);
			startActivity(intent);
			return true;
		case 4:
			intent = new Intent(new Intent(Years.this, LoginActivity.class));
			intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK
					| intent.FLAG_ACTIVITY_CLEAR_TOP
					| Intent.FLAG_ACTIVITY_SINGLE_TOP);
			startActivity(intent);
			return true;

		}

		return super.onOptionsItemSelected(item);

	}

	private class myTask extends AsyncTask<Void, Void, Void> {

		private final ProgressDialog dialog = new ProgressDialog(Years.this);

		@Override
		protected void onPreExecute() {
			dialog.setMessage("We are processing your request");
			dialog.show();
		}

		@Override
		protected Void doInBackground(Void... params) {
			Items = getResults();
			return null;
		}

		@Override
		protected void onPostExecute(Void result) {

			
			if (Items.length == 1 && Items[0].equals("anyType{}")) {
				AlertDialog.Builder builder = new AlertDialog.Builder(
						Years.this);
				builder.setMessage("No Records");
				builder.setPositiveButton("Ok",
						new DialogInterface.OnClickListener() {

							public void onClick(DialogInterface dialog,
									int which) {
								// TODO Auto-generated method stub
								Intent intent = new Intent(Years.this,
										ListActivity.class);
								intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK
										| intent.FLAG_ACTIVITY_CLEAR_TOP
										| Intent.FLAG_ACTIVITY_SINGLE_TOP);
								startActivity(intent);
							}
						});
				builder.show();

			} else {

				icons = new Integer[Items.length];
				for (int i = 0; i < icons.length; i++) {
					icons[i] = R.drawable.icoitem;
				}
				Items adapter = new Items(Years.this, Items, icons);
				ItemsView = (ListView) findViewById(R.id.listView1);
				ItemsView.setAdapter(adapter);
				ListclickEvent();
				if (dialog.isShowing()) {
					dialog.dismiss();
				}

			}
		}
	}
}
