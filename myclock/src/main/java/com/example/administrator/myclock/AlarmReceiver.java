package com.example.administrator.myclock;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import static android.support.v4.app.ActivityCompat.startActivity;

/**
 * Created by Administrator on 2015/4/27.
 */
public class AlarmReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        Toast.makeText(context,"alarm",Toast.LENGTH_SHORT).show();
        Log.d("myClock", "alarm success");
        int id=intent.getIntExtra("id",0);
        Intent it = new Intent(context, AlarmView.class);
        it.putExtra("id",id);
        it.putExtra("time",intent.getStringExtra("time"));
        it.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_LAUNCHED_FROM_HISTORY);
        Log.d("myClock",context.toString());
        context.startActivity(it);
    }
}
