package com.example.administrator.myclock;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

/**
 * Created by Administrator on 2015/4/28.
 */
public class MyAlarmService extends Service {
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

}
