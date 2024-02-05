package com.expediteapp;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterMobile extends Activity {

	private static String NAMESPACE = "http://tempuri.org/";
	private static String SOAP_ACTION1 = "http://tempuri.org/addSim";
	private static String METHOD_NAME1 = "addSim";
	private static String URL = GetIp.ip();
	private static String simId = "";

	Button ok, Cancel;
	EditText txtpin, txtpin1;
	String pin, pinCopy;
	SoapObject soapResult;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register_mobile);

		ok = (Button) findViewById(R.id.btnRegMobOk);
		Cancel = (Button) findViewById(R.id.btnRegMobCancel);

		txtpin = (EditText) findViewById(R.id.txtRegMobPin);
		txtpin1 = (EditText) findViewById(R.id.txtRegMobPin1);

		ok.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (txtpin.getText().toString().equals("")
						|| txtpin1.getText().toString().equals("")) {
					Toast.makeText(RegisterMobile.this, "Provide details",
							Toast.LENGTH_LONG).show();
				} else {

					new MyTask().execute();
				}
			}
		});
		Cancel.setOnClickListener(new View.OnClickListener() {
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				finish();
			}
		});
		txtpin.requestFocus();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		// getMenuInflater().inflate(R.menu.activity_view_profile, menu);
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
			intent = new Intent(new Intent(RegisterMobile.this,
					LoginActivity.class));
			intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK
					| intent.FLAG_ACTIVITY_CLEAR_TOP
					| Intent.FLAG_ACTIVITY_SINGLE_TOP);
			startActivity(intent);
			return true;
		}
		return super.onOptionsItemSelected(item);

	}

	private class MyTask extends AsyncTask<Void, Void, Void> {

		ProgressDialog dialog = new ProgressDialog(RegisterMobile.this);

		@Override
		protected void onPostExecute(Void result) {
			// TODO Auto-generated method stub

			if (soapResult != null) {

				if (soapResult.getProperty(0).toString().equals("true")) {
					Toast.makeText(RegisterMobile.this,
							"Pin altered successfully", Toast.LENGTH_LONG)
							.show();
					Intent intent = new Intent(RegisterMobile.this,
							SplashScreen.class);
					intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK
							| intent.FLAG_ACTIVITY_CLEAR_TOP
							| Intent.FLAG_ACTIVITY_SINGLE_TOP);
					startActivity(intent);
				} else {
					Toast.makeText(getApplicationContext(), "failure",
							Toast.LENGTH_LONG).show();
				}

			} else {
				Toast.makeText(getApplicationContext(), "No Response",
						Toast.LENGTH_LONG).show();
			}

			if (dialog.isShowing()) {
				dialog.dismiss();
			}
			txtpin.setText("");
			txtpin1.setText("");
			super.onPostExecute(result);
		}

		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			dialog.setMessage("We are processing your request");
			dialog.show();
			super.onPreExecute();
		}

		@Override
		protected Void doInBackground(Void... params) {
			// TODO Auto-generated method stub
			regSim();
			return null;
		}

		void regSim() {
			pin = txtpin.getText().toString();
			pinCopy = txtpin1.getText().toString();

			if (pin.equals(pinCopy)) {

				SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME1);
				request.addProperty("sid", LoginDtls.getSid());
				request.addProperty("pin", pin);
				SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
						SoapEnvelope.VER11);
				envelope.setOutputSoapObject(request);
				envelope.dotNet = true;

				try {
					HttpTransportSE androidHttpTransport = new HttpTransportSE(
							URL);
					androidHttpTransport.call(SOAP_ACTION1, envelope);
					soapResult = (SoapObject) envelope.bodyIn;
				} catch (Exception e) {
					e.printStackTrace();
				}

			} else {
				Toast.makeText(getApplicationContext(),
						"pin and pincopy not same", Toast.LENGTH_LONG).show();
				txtpin.setText("");
				txtpin1.setText("");
				txtpin.requestFocus();
			}
		}

	}
}
