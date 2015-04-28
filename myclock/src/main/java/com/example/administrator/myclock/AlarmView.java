package com.example.administrator.myclock;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

/**
 * Created by Administrator on 2015/4/27.
 */
public class AlarmView extends Activity{
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alarm_layout);
        int id=getIntent().getIntExtra("id",0);
        String time=getIntent().getStringExtra("time");
        TextView tv=(TextView)findViewById(R.id.message);
        Log.d("myClock","show："+time);
        tv.setText("id: "+id+" at time: "+time);
    }


}
