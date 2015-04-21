package com.example.administrator.myrecordertest;

import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Environment;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


public class MainActivity extends ActionBarActivity{
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
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    TextView tv=null;
    public Button btnRecord =null;
    public Button btnBroad =null;
    public Button btnStop=null;
    public mRecorderAndPlayer RAndP= null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv= (TextView) findViewById(R.id.fileName);
        btnRecord = (Button)findViewById(R.id.record);
        btnBroad = (Button)findViewById(R.id.broadcast);
        btnStop = (Button)findViewById(R.id.stop);
        btnRecord.setOnClickListener(click);
        btnBroad.setOnClickListener(click);
        btnStop.setOnClickListener(click);
        RAndP=new mRecorderAndPlayer();
    }
    private View.OnClickListener click=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String FileName=tv.getText().toString();
            switch(v.getId())
            {
                case R.id.broadcast:
                    if(!RAndP.mediaPlay(FileName))
                        Toast.makeText(MainActivity.this,"Play Failed",Toast.LENGTH_LONG).show();
                    return;
                case R.id.record:
                    if(!RAndP.record(FileName))
                    Toast.makeText(MainActivity.this,"Play Failed",Toast.LENGTH_LONG).show();
                    return;
                case R.id.stop:
                    RAndP.stop();
                    return;
            }
        }
    };
    //stop all media when program be closed
    @Override
    protected void onDestroy() {
        super.onDestroy();
        RAndP.stop();
    }
}
