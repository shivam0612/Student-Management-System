package com.expediteapp;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.kobjects.base64.Base64;
import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import org.xmlpull.v1.XmlPullParserException;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class UseCam extends Activity {
	private static String NAMESPACE = "http://tempuri.org/";
	private static String SOAP_ACTION1 = "http://tempuri.org/SaveImage";
	private static String METHOD_NAME1 = "SaveImage";
	private static String URL = GetIp.ip();

	String selectedImagePath;

	Button browse, updatePic, rotate;
	ImageView imageView;
	Bitmap bmap, bmap1;
	String base64String;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_use_memory);
		imageView = (ImageView) findViewById(R.id.imageView1);

		rotate = (Button) findViewById(R.id.btnRotatePic);
		rotate.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (bmap != null) {
					Matrix bmapMatrix = new Matrix();

					bmapMatrix.postRotate(90);
					Bitmap bmaprotated;
					bmaprotated = Bitmap.createBitmap(bmap, 0, 0,
							bmap.getWidth(), bmap.getHeight(), bmapMatrix, true);
					bmap = bmaprotated;

					imageView.setImageBitmap(bmap);
				}
			}
		});
		browse = (Button) findViewById(R.id.btnBrowse);
		browse.setText("Capture");
		browse.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub
				base64String = "";

				try {
					Intent CaptureIntent = new Intent(
							MediaStore.ACTION_IMAGE_CAPTURE);

					startActivityForResult(CaptureIntent, 1);
					imageView = (ImageView) findViewById(R.id.imageView1);

				} catch (ActivityNotFoundException anfe) {
					String errorMsg = "NO support for image capture";
					Toast.makeText(getApplicationContext(), errorMsg,
							Toast.LENGTH_LONG).show();
				}

			}
		});

		updatePic = (Button) findViewById(R.id.btnUpdatePic);
		updatePic.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub
				bmap1 = Bitmap.createScaledBitmap(bmap, 100, 120, true);

				new myTask().execute();
			}
		});

		if (savedInstanceState != null) {
			bmap = ((Bitmap) savedInstanceState.getParcelable("bmap"));

			imageView.setImageBitmap(bmap);
		}

	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		// TODO Auto-generated method stub
		outState.putParcelable("bmap", bmap);

		super.onSaveInstanceState(outState);

	}

	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);

		switch (requestCode) {
		case 1: {
			if (resultCode == RESULT_OK) {
				Uri uri = data.getData();
				if (uri != null) {
					try {

						bmap = MediaStore.Images.Media.getBitmap(
								getContentResolver(), uri);

						imageView.setImageBitmap(bmap);

					} catch (Exception e) {

					}
				}
			}
		}
		}
	}

	public void readFile() {
		try {
			ByteArrayOutputStream stream = new ByteArrayOutputStream();
			bmap1.compress(Bitmap.CompressFormat.PNG, 0, stream);

			byte[] byteArray = stream.toByteArray();
			base64String = Base64.encode(byteArray);

		} catch (Exception ioe) {
			ioe.printStackTrace();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		menu.add(0, 1, 0, "Main Menu").setIcon(R.drawable.taskbar_start_menu);
		menu.add(0, 2, 1, "Student Info").setIcon(R.drawable.information);
		menu.add(0, 3, 2, "Settings").setIcon(R.drawable.setting);
		menu.add(0, 4, 3, "Logout");
		return true;
	}

	@SuppressWarnings({ "static-access", "static-access", "static-access" })
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
			intent = new Intent(new Intent(UseCam.this, LoginActivity.class));
			intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK
					| intent.FLAG_ACTIVITY_CLEAR_TOP
					| Intent.FLAG_ACTIVITY_SINGLE_TOP);
			startActivity(intent);
			return true;
		}
		return super.onOptionsItemSelected(item);

	}

	private class myTask extends AsyncTask<Void, Void, Void> {

		ProgressDialog dialog = new ProgressDialog(UseCam.this);

		@Override
		protected void onPostExecute(Void result) {
			// TODO Auto-generated method stub
			super.onPostExecute(result);
			if (dialog.isShowing()) {
				dialog.dismiss();
			}

			Intent intent = new Intent(getApplicationContext(), StudInfo.class);
			intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK
					| intent.FLAG_ACTIVITY_CLEAR_TOP
					| Intent.FLAG_ACTIVITY_SINGLE_TOP);
			startActivity(intent);

		}

		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			super.onPreExecute();
			dialog.setMessage("We are processing your request");
			dialog.show();

		}

		@Override
		protected Void doInBackground(Void... params) {
			// TODO Auto-generated method stub
			updatePic();

			return null;
		}

	}

	void updatePic() {
		try {
			SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME1);
			readFile();
			request.addProperty("imageString", base64String);
			request.addProperty("sid", LoginDtls.getSid());
			SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
					SoapEnvelope.VER11);
			envelope.dotNet = true;
			envelope.setOutputSoapObject(request);
			HttpTransportSE aht = new HttpTransportSE(URL);
			aht.call(SOAP_ACTION1, envelope);
			// HttpTransportSE androidHttpTransport = new
			// HttpTransportSE(URL);
			// androidHttpTransport.call(SOAP_ACTION, envelope);
			/*
			 * SoapObject response = (SoapObject) envelope.bodyIn;
			 * 
			 * Intent intent = new Intent(getApplicationContext(),
			 * StudInfo.class); intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK |
			 * intent.FLAG_ACTIVITY_CLEAR_TOP |
			 * Intent.FLAG_ACTIVITY_SINGLE_TOP); startActivity(intent);
			 */

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (XmlPullParserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
