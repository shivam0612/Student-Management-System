package com.expediteapp;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import org.w3c.dom.Text;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ViewProfile extends Activity {
	private static String NAMESPACE = "http://tempuri.org/";
	private static String SOAP_ACTION1 = "http://tempuri.org/viewProfile";
	private static String METHOD_NAME1 = "viewProfile";
	private static String URL = GetIp.ip();
	String info;
	String[] parts;

	Bitmap bmpPic;

	TextView id, name, contact, address, email ,dob ,clas;
	TextView lblId, lblName, lblContact, lblAddress, lblEmail ,lblClass,lblDob;
	ImageView picId;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_view_profile);

		id = (TextView) findViewById(R.id.txtId);
		name = (TextView) findViewById(R.id.txtName);
		contact = (TextView) findViewById(R.id.txtContact);
		address = (TextView) findViewById(R.id.txtAddress);
		email = (TextView) findViewById(R.id.txtEmail);
		dob = (TextView)findViewById(R.id.txtDob);
		clas = (TextView)findViewById(R.id.txtClass);
		picId = (ImageView) findViewById(R.id.imageView1);

		lblId = (TextView) findViewById(R.id.lblId);
		lblName = (TextView) findViewById(R.id.lblName);
		lblContact = (TextView) findViewById(R.id.lblContact);
		lblAddress = (TextView) findViewById(R.id.lblAddress);
		lblEmail = (TextView) findViewById(R.id.lblEmail);
		lblClass = (TextView) findViewById(R.id.lblClass);
		lblDob = (TextView) findViewById(R.id.lblDob);

		makeViewsInvisible();

		if (savedInstanceState != null) {
			id.setText(savedInstanceState.getString("id"));
			name.setText(savedInstanceState.getString("name"));
			contact.setText(savedInstanceState.getString("contact"));
			address.setText(savedInstanceState.getString("address"));
			email.setText(savedInstanceState.getString("email"));
			clas.setText(savedInstanceState.getString("class"));
			dob.setText(savedInstanceState.getString("dob"));
			bmpPic = savedInstanceState.getParcelable("picId");
			picId.setImageBitmap(bmpPic);
			
			makeViewsVisible();
		} else {
			new MyTask().execute();
		}

	}

	public void makeViewsInvisible() {
		id.setVisibility(View.INVISIBLE);
		name.setVisibility(View.INVISIBLE);
		contact.setVisibility(View.INVISIBLE);
		address.setVisibility(View.INVISIBLE);
		email.setVisibility(View.INVISIBLE);
		dob.setVisibility(View.INVISIBLE);
		clas.setVisibility(View.INVISIBLE);
		picId.setVisibility(View.INVISIBLE);

		lblId.setVisibility(View.INVISIBLE);
		lblName.setVisibility(View.INVISIBLE);
		lblContact.setVisibility(View.INVISIBLE);
		lblAddress.setVisibility(View.INVISIBLE);
		lblDob.setVisibility(View.INVISIBLE);
		lblClass.setVisibility(View.INVISIBLE);
		lblEmail.setVisibility(View.INVISIBLE);

	}

	public void makeViewsVisible() {
		id.setVisibility(View.VISIBLE);
		name.setVisibility(View.VISIBLE);
		contact.setVisibility(View.VISIBLE);
		address.setVisibility(View.VISIBLE);
		email.setVisibility(View.VISIBLE);
		clas.setVisibility(View.VISIBLE);
		dob.setVisibility(View.VISIBLE);
		picId.setVisibility(View.VISIBLE);

		lblId.setVisibility(View.VISIBLE);
		lblName.setVisibility(View.VISIBLE);
		lblContact.setVisibility(View.VISIBLE);
		lblAddress.setVisibility(View.VISIBLE);
		lblEmail.setVisibility(View.VISIBLE);
		lblClass.setVisibility(View.VISIBLE);
		lblDob.setVisibility(View.VISIBLE);
	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		// TODO Auto-generated method stub

		outState.putString("id", id.getText().toString());
		outState.putString("name", name.getText().toString());
		outState.putString("contact", contact.getText().toString());
		outState.putString("address", address.getText().toString());
		outState.putString("email", email.getText().toString());
		outState.putString("class", clas.getText().toString());
		outState.putString("dob", dob.getText().toString());

		outState.putParcelable("picId", bmpPic);
		
		super.onSaveInstanceState(outState);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		// getMenuInflater().inflate(R.menu.activity_view_profile, menu);
		menu.add(0, 1, 0, "Main Menu").setIcon(R.drawable.taskbar_start_menu);
		menu.add(0, 2, 1, "Student Info").setIcon(R.drawable.information);
		menu.add(0, 3, 2, "Settings").setIcon(R.drawable.setting);
		menu.add(0,4,3,"Logout");
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
			intent = new Intent(new Intent(ViewProfile.this,LoginActivity.class));
			intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK
					| intent.FLAG_ACTIVITY_CLEAR_TOP
					| Intent.FLAG_ACTIVITY_SINGLE_TOP);
			startActivity(intent);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	private class MyTask extends AsyncTask<Void, Void, Void> {

		ProgressDialog dialog = new ProgressDialog(ViewProfile.this);

		protected void onPreExecute() {
			dialog.setMessage("We are processing your request");
			dialog.show();

		}

		@Override
		protected Void doInBackground(Void... params) {
			// TODO Auto-generated method stub
			viewProfile();
			bmpPic = getBitmapFromURL(GetIp.imgStr() + parts[0] + ".png");
			return null;
		}

		protected void onPostExecute(Void result) {

			picId.setImageBitmap(bmpPic);

			id.setText(parts[0]);
			name.setText(parts[1]);
			address.setText(parts[2]);
			contact.setText(parts[3]);
			email.setText(parts[4]);
			dob.setText(parts[5]);
			clas.setText(parts[6]);


			if (dialog.isShowing()) {
				dialog.dismiss();
			}

			makeViewsVisible();

		}

		public Bitmap getBitmapFromURL(String src) {
			try {
				Log.e("src", src);
				URL url = new URL(src);
				HttpURLConnection connection = (HttpURLConnection) url
						.openConnection();
				connection.setDoInput(true);
				connection.connect();
				InputStream input = (InputStream) connection.getInputStream();
				Bitmap myBitmap = BitmapFactory.decodeStream(input);
				Log.e("Bitmap", "returned");
				return myBitmap;
			} catch (IOException e) {
				e.printStackTrace();
				Log.e("Exception", e.getMessage());
				return null;
			}
		}

		private void viewProfile() {

			SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME1);
			request.addProperty("id", LoginDtls.getSid());
			SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
					SoapEnvelope.VER11);
			envelope.setOutputSoapObject(request);
			envelope.dotNet = true;
			try {
				HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);
				androidHttpTransport.call(SOAP_ACTION1, envelope);
				SoapObject result = (SoapObject) envelope.bodyIn;
				if (result != null) {
					info = result.getPropertyAsString(0);
					parts = info.split(",");

				} else {
					Toast.makeText(getApplicationContext(), "No Response",
							Toast.LENGTH_LONG).show();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
}
