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
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends Activity {
	private static String NAMESPACE = "http://tempuri.org/";
	private static String SOAP_ACTION = "http://tempuri.org/Authenticate";
	private static String METHOD_NAME = "Authenticate";
	private static String URL = GetIp.ip();

	String id, pin, resp;
	EditText txtId, txtPin;
	Button ok, cancel;

	SoapObject reslt;

	@Override
	protected void onCreate(final Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		setTitle("Login to your account");

		txtId = (EditText) findViewById(R.id.txtId);
		txtId.requestFocus();

		txtPin = (EditText) findViewById(R.id.txtPin);

		ok = (Button) findViewById(R.id.btnLogin);
		ok.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				if ((txtId.getText().toString().equals(""))
						|| (txtPin.getText().toString().equals(""))) {
					Toast.makeText(LoginActivity.this, "Provide details",
							Toast.LENGTH_LONG).show();
				} else {

					new MyTask().execute();

				}
			}
		});

		cancel = (Button) findViewById(R.id.btnCancel);
		cancel.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				// TODO Auto-generated method stub
				txtId.setText("");
				txtPin.setText("");
				txtId.requestFocus();
			}
		});
		if (savedInstanceState != null) {
			txtId.setText(savedInstanceState.getString("id"));
			txtPin.setText(savedInstanceState.getString("pin"));
		}

	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		// TODO Auto-generated method stub

		outState.putString("id", txtId.getText().toString());
		outState.putString("pin", txtPin.getText().toString());
		super.onSaveInstanceState(outState);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_login, menu);
		return true;
	}

	private class MyTask extends AsyncTask<Void, Void, Void> {

		ProgressDialog dialog = new ProgressDialog(LoginActivity.this);

		@Override
		protected void onPreExecute() {
			//txtId.setText("3");
			//txtPin.setText("777");
			id = txtId.getText().toString();
			pin = txtPin.getText().toString();
			txtId.setText("");
			txtPin.setText("");
			txtId.requestFocus();

			dialog.setMessage("We are processing your request");
			dialog.show();
		}

		@Override
		protected Void doInBackground(Void... params) {
			Authenticate();
			return null;
		}

		@Override
		protected void onPostExecute(Void result) {

			if (reslt != null) {
				resp = reslt.getProperty(0).toString();

				if (resp.equals("true")) {
					LoginDtls.setSid(id);
					LoginDtls.setPin(pin);



					Intent intent = new Intent(LoginActivity.this,
							ListActivity.class);
					startActivity(intent);
				}
			} else {
				txtId.setText("");
				txtPin.setText("");
				txtId.requestFocus();
				Toast.makeText(LoginActivity.this, "Incorrect login Details",
						Toast.LENGTH_LONG).show();

			}

			if (dialog.isShowing()) {
				dialog.dismiss();
			}

		}

		private void Authenticate() {

			SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);
			request.addProperty("id", id);
			request.addProperty("pin", pin);
			SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
			envelope.setOutputSoapObject(request);
			envelope.dotNet = true;
			try {

				HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);
				androidHttpTransport.call(SOAP_ACTION, envelope);
				reslt = (SoapObject) envelope.bodyIn;

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

}