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

public class PastWeek extends Activity {
    private static String NAMESPACE = "http://tempuri.org/";
    private static String SOAP_ACTION1 = "http://tempuri.org/weekmarks";
    private static String METHOD_NAME1 = "weekmarks";
    private static String URL = GetIp.ip();
    String info;
    String[] parts;

    TableLayout tl;
    TextView id,subject,marks,clas,date;

    TextView txtRecords;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_past_week);
        id = (TextView) findViewById(R.id.id);
        subject = (TextView) findViewById(R.id.subject);
        marks = (TextView) findViewById(R.id.marks);
        clas = (TextView) findViewById(R.id.clas);
        date = (TextView) findViewById(R.id.date);
        txtRecords = (TextView) findViewById(R.id.txtRecords);
        tl = (TableLayout) findViewById(R.id.maintable);
        new MyTask().execute();


    }

    private class MyTask extends AsyncTask<Void, Void, Void> {

        ProgressDialog dialog = new ProgressDialog(PastWeek.this);

        protected void onPreExecute() {
            dialog.setMessage("We are processing your request");
            dialog.show();

        }

        @Override
        protected Void doInBackground(Void... params) {
            // TODO Auto-generated method stub
            viewMarks();

            return null;
        }

        protected void onPostExecute(Void result) {


            if (dialog.isShowing()) {
                dialog.dismiss();
            }


            for (int i = 0; i < parts.length; i++) {
                TableRow tr = new TableRow(PastWeek.this);
                if(i%2==0)
                    tr.setBackgroundColor(getResources().getColor(R.color.silver));
                String[] fields = parts[i].split(",");
                for (int j = 0; j < fields.length; j++) {
                    TextView tv = new TextView(PastWeek.this);

                    if (j == fields.length - 1) {

                        tv.setText( fields[j].substring(0,8));
                    }
                    else
                    {
                        tv.setText(fields[j]);
                    }
                    tv.setMinEms(4);
                    tr.addView(tv);
                    //txtRecords.setText(txtRecords.getText()+fields[j]+"\t\t");
                }
                tl.addView(tr, new TableLayout.LayoutParams(
                        TableLayout.LayoutParams.MATCH_PARENT,
                        TableRow.LayoutParams.WRAP_CONTENT));
                //txtRecords.setText(txtRecords.getText()+"\n");
            }
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

        private void viewMarks() {

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
                    parts = info.split("#");

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
