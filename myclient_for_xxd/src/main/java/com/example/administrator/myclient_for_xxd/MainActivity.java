package com.example.administrator.myclient_for_xxd;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;


public class MainActivity extends ActionBarActivity {

    TextView tv= null;
    EditText ev=null;
    EditText ip=null;
    Button send=null;
    private String content = "";
    public Handler mHandler = new Handler() {
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            tv.setText(content);
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv= (TextView) findViewById(R.id.outputTV);
        ev=(EditText) findViewById(R.id.editText);
        send=(Button) findViewById(R.id.send);
        send.setOnClickListener(click);
        ip=(EditText) findViewById(R.id.IP);
        ms=new MySocket("2");
    }
    MySocket ms;
    View.OnClickListener click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            Thread t=new Thread(new mythread());
            t.start();
        }
    };
    public class mythread implements  Runnable
    {
        @Override
        public void run() {
            ms=new MySocket(ev.getText().toString());
            ms.Required(ip.getText().toString(),8080);
            content=ms.get;
            mHandler.sendMessage(mHandler.obtainMessage());
        }
    }
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
