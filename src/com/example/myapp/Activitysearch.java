package com.example.myapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import java.util.ArrayList;


/**
 * Created by farazp30 on 08/12/2015.
 */
public class Activitysearch extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search);

        Intent intent= new Intent(Activitysearch.this, Activityfilterdocter.class);
        Bundle bundle = getIntent().getExtras();
        String name = bundle.getString("namesick");
        String fname = bundle.getString("fsick");
        String telsic = bundle.getString("telsick");
       // TextView namesick = (TextView) findViewById(R.id.namesick);
        //TextView fsick=(TextView)findViewById(R.id.fsick);
        //TextView telsick = (TextView) findViewById(R.id.telsick);


        //intent.putExtra("spostandocter",name_ostan);
        intent.putExtra("namesick",name);
        intent.putExtra("fsick", fname);
        intent.putExtra("telsick", telsic);


        startActivity(intent);
        final provinceHelper pHelper = new provinceHelper(this);
        int c = pHelper.getAll();
        final ArrayList<String> sitems = new ArrayList<String>();

        for (province item : pHelper.getContacts()) {
            sitems.add(item.name);
        }

        Spinner s = (Spinner) findViewById(R.id.ostan);
        final ArrayAdapter<String> sa = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, sitems);
        s.setAdapter(sa);


        final spichalHelper spHelper=new spichalHelper(this);
        int sp=spHelper.getAll();
        final ArrayList<String> spitems = new ArrayList<String>();

        for (province item : pHelper.getContacts()) {
            sitems.add(item.name);
        }

        Spinner spishal = (Spinner) findViewById(R.id.spishal);
        final ArrayAdapter<String> spc = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, sitems);
        spishal.setAdapter(spc);

        final Spinner spinnerCities = (Spinner) findViewById(R.id.city);

//        cityHelper cHelper=new cityHelper(this);
           s.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Long id_ostan = pHelper.getContacts().get(i).id;
                String name_ostan=(adapterView.getSelectedItem()).toString();

                ArrayList<String> strings = new ArrayList<String>();
                for (city c : pHelper.getCity(id_ostan)){
                    strings.add(c.name);
                }
                ArrayAdapter<String> ci = new ArrayAdapter<String>(Activitysearch.this, android.R.layout.simple_spinner_item, strings);
                spinnerCities.setAdapter(ci);
            }

               @Override
               public void onNothingSelected(AdapterView<?> adapterView) {

               }
           });


            Button btnsearch = (Button) findViewById(R.id.btnsearch);
    btnsearch.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            startActivity(new Intent(Activitysearch.this, Activityfilterdocter.class));
        }

    });
        Button btnback = (Button) findViewById(R.id.btnback);
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Activitysearch.this, Activitysick.class));
            }

        });
}}