package com.example.myapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

/**
 * Created by farazp30 on 06/12/2015.
 */
public class Activitysick extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sick);




    Button btnback = (Button) findViewById(R.id.btnback);
    btnback.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            startActivity(new Intent(Activitysick.this, MyActivity.class));
        }

    });
        Button btnnext = (Button) findViewById(R.id.btnnext);
        btnnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //startActivity(new Intent(Activitysick.this, Activitysearch.class));



                Intent intent= new Intent(Activitysick.this, Activitysearch.class);

                TextView namesick = (TextView) findViewById(R.id.namesick);
                TextView fsick=(TextView)findViewById(R.id.fsick);
                TextView telsick = (TextView) findViewById(R.id.telsick);


                //intent.putExtra("spostandocter",name_ostan);
                intent.putExtra("namesick",(namesick.getText()).toString());
                intent.putExtra("fsick", (fsick.getText()).toString());
                intent.putExtra("telsick", (telsick.getText().toString()));


                startActivity(intent);

            }

        });
}}
