package com.example.administrator.sqlite;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class Messageinput extends ActionBarActivity {

    Button bt;
    EditText et1;
    EditText et2;
    EditText et3;
    EditText et4;
    clockMessage cm;
    private MyDBManager dbm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messageinput);
        bt=(Button)findViewById(R.id.button);
        et1=(EditText)findViewById(R.id.editText);
        et2=(EditText)findViewById(R.id.editText2);
        et3=(EditText)findViewById(R.id.editText3);
        et4=(EditText)findViewById(R.id.editText4);
        bt.setOnClickListener(click);
        dbm=new MyDBManager(this);
    }

    View.OnClickListener click=new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            cm=new clockMessage(Integer.parseInt(et1.getText().toString()),et2.getText().toString(),Integer.parseInt(et3.getText().toString()),et4.getText().toString());
            dbm.Insert(cm);
        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_messageinput, menu);
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
