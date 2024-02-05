package com.expediteapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class Attendance extends Activity {
    ListView ItemsView;
    String[] Items = { "Weekly Attendance"};
    Integer[] icons = {R.drawable.icoexmas,R.drawable.icoexmas,R.drawable.icoexmas};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marks);
        Items adapter = new Items(this, Items,icons);
        ItemsView = (ListView) findViewById(R.id.listView1);
        ItemsView.setAdapter(adapter);
        ListclickEvent();

    }

    private void ListclickEvent() {
        ItemsView.setOnItemClickListener(new OnItemClickListener() {

            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                    long arg3) {

                if (arg2 == 0) {
                    Intent intent = new Intent(Attendance.this,WeeklyAttendance.class);
                    startActivity(intent);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK
                            | intent.FLAG_ACTIVITY_CLEAR_TOP
                            | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                    startActivity(intent);
                }

            }
        });
    }
}
