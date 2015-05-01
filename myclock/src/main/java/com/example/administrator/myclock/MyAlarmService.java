package com.example.administrator.myclock;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by Administrator on 2015/4/28.
 */
public class MyAlarmService extends Service {
    String TAG="My Service";
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        Toast.makeText(getApplicationContext(),"service create",Toast.LENGTH_SHORT).show();
        super.onCreate();
    }

    @Override
    public void onStart(Intent intent, int startId) {
        Toast.makeText(getApplicationContext(),"service start",Toast.LENGTH_SHORT).show();

        Intent it=new Intent(getApplicationContext(),com.example.administrator.myclock.AlarmView.class);
        it.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        it.putExtra("time",intent.getLongExtra("time",3));
        it.putExtra("id",intent.getIntExtra("id",3));

        PendingIntent pit = PendingIntent.getActivity(getApplicationContext(),0,it,0);

        AlarmManager am=(AlarmManager)getSystemService(ALARM_SERVICE);
        am.set(AlarmManager.RTC_WAKEUP,intent.getLongExtra("time",0),pit);

        super.onStart(intent, startId);
    }

    @Override
    public void onDestroy() {
        Toast.makeText(this,"service destroy",Toast.LENGTH_SHORT).show();
        super.onDestroy();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {


        Toast.makeText(getApplicationContext(),"service start command",Toast.LENGTH_SHORT).show();

        return super.onStartCommand(intent, flags, startId);
    }
}
