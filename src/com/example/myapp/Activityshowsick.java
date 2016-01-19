package com.example.myapp;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by farazp30 on 27/12/2015.
 */
public class Activityshowsick extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.showsick);
       Bundle bundle = getIntent().getExtras();
       String name = bundle.getString("namesick");
       String fname = bundle.getString("fsick");
       String telsic = bundle.getString("telsick");

        TextView namesickk=(TextView)findViewById(R.id.namesick);
        namesickk.setText(name);
        TextView fsickk = (TextView) findViewById(R.id.fsick);
        fsickk.setText(fname);
        TextView telsickk = (TextView) findViewById(R.id.telsick);
        telsickk.setText( telsic);
}}
