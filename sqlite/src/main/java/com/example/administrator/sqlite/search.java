package com.example.administrator.sqlite;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import org.w3c.dom.Text;


public class search extends ActionBarActivity {

    private MyDBManager dbm;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        tv=(TextView)findViewById(R.id.textView2);
        dbm=new MyDBManager(this);
        String mess=getIntent().getStringExtra("message");
        Cursor cs=dbm.FindById(Integer.parseInt(mess));
        String z="";
        while(cs.moveToNext())
        {
            z=z+cs.getColumnIndex("_id")+cs.getInt(cs.getColumnIndex("_id"));
            z=z+cs.getColumnIndex("message")+cs.getInt(cs.getColumnIndex("message"));
        }
        tv.setText(z);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_search, menu);
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
