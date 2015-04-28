package com.example.administrator.myclock;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;


public class MainActivity extends ActionBarActivity {

    public TimePicker tp=null;
    public DatePicker dp=null;
    public Button btn=null;
    public Button btn2=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tp=(TimePicker) findViewById(R.id.timePicker);
        dp=(DatePicker) findViewById(R.id.datePicker);
        tp.getCurrentHour();
        tp.getCurrentMinute();
        btn= (Button) findViewById(R.id.btn_confirm);
        btn.setOnClickListener(confirmClick);
        btn2= (Button) findViewById(R.id.btn_cancel);

        btn2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AlarmReceiver.class);
                PendingIntent pendingIntent = PendingIntent.getBroadcast(
                        getApplicationContext(),0, intent, 0);
                AlarmManager am;
                                /* 获取闹钟管理的实例 */
                am = (AlarmManager) getSystemService(ALARM_SERVICE);
                                /* 取消 */
                am.cancel(pendingIntent);
                Log.d("myClock","cancel");
            }
        });

    }
    View.OnClickListener confirmClick=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String z=tp.getCurrentHour().toString()+":"+tp.getCurrentMinute().toString();
            Toast.makeText(MainActivity.this,z,Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(getApplicationContext(),
                    AlarmReceiver.class);

            intent.putExtra("id",5);
            intent.putExtra("time",z);
            PendingIntent pendingIntent = PendingIntent
                    .getBroadcast(getApplicationContext(), 0,
                            intent, 0);

            AlarmManager am;

            am = (AlarmManager) getSystemService(ALARM_SERVICE);
            Calendar calender= Calendar.getInstance();
            calender.set(dp.getYear(),dp.getMonth(),dp.getDayOfMonth(),tp.getCurrentHour(),tp.getCurrentMinute());
            calender.add(Calendar.SECOND,5);
            am.set(AlarmManager.RTC_WAKEUP,calender.getTimeInMillis(),pendingIntent);
            String p=dp.getDayOfMonth()+":"+(dp.getMonth()+1)+":"+dp.getYear();
            Log.d("myClock","create22:"+calender.getTime().toString()+p);

            //startService(new Intent("com.example.administrator.myclock.MyAlarmService"));
        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
