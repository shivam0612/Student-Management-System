package com.expediteapp;

import java.io.File;
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
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

public class Timetable extends Activity {
    private static String NAMESPACE = "http://tempuri.org/";
    private static String SOAP_ACTION1 = "http://tempuri.org/pdfurl";
    private static String METHOD_NAME1 = "pdfurl";
    private static String URL = GetIp.ip();
    String info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timetable);
        new MyTask().execute();
    }

    private class MyTask extends AsyncTask<Void, Void, Void> {

        ProgressDialog dialog = new ProgressDialog(Timetable.this);

        protected void onPreExecute() {
            dialog.setMessage("We are processing your request");
            dialog.show();


        }

        @Override
        protected Void doInBackground(Void... params) {
            // TODO Auto-generated method stub
            getpdf();

            return null;
        }

        protected void onPostExecute(Void result) {
            if (dialog.isShowing()) {
                dialog.dismiss();
            }
            String s = info.substring(2);
            //handbook/s.pdf
            String url = "http://192.168.43.155/sms/" + s + "";
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url));
            startActivity(i);


        }


    }

    private void getpdf() {

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

            } else {
                Toast.makeText(getApplicationContext(), "No Response",
                        Toast.LENGTH_LONG).show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

