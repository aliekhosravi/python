package com.example.myapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.*;

import java.util.ArrayList;

/**
 * Created by farazp30 on 08/12/2015.
 */
public class Activitydocter extends Activity {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.docter);
        final int id_ostan;
        final  int id_city;
        final String name_ostan;
        final String name_city;
        Button btnshow = (Button) findViewById(R.id.btnshow);

        final provinceHelper pHelper = new provinceHelper(this);
        int c = pHelper.getAll();
        final ArrayList<String> sitems = new ArrayList<String>();

        for (province item : pHelper.getContacts()) {
            sitems.add(item.name);
        }

        Spinner s = (Spinner) findViewById(R.id.spostandocter);
        final ArrayAdapter<String> sa = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, sitems);
        s.setAdapter(sa);

        final Spinner spinnerCities = (Spinner) findViewById(R.id.spcitydocter);

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
                ArrayAdapter<String> ci = new ArrayAdapter<String>(Activitydocter.this, android.R.layout.simple_spinner_item, strings);
                spinnerCities.setAdapter(ci);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        spinnerCities.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
               final long id_city=pHelper.getContacts().get(i).id;
               final String name_city= (adapterView.getSelectedItem()).toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        btnshow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent= new Intent(Activitydocter.this, Activitylist.class);
                Spinner spostandocter = (Spinner) findViewById(R.id.spostandocter);
                Spinner spcitydocter=(Spinner)findViewById(R.id.spcitydocter);
                TextView editnamedocter = (TextView) findViewById(R.id.editnamedocter);
                TextView scheouel=(TextView)findViewById(R.id.scheouel);
                TextView editfamilydocter = (TextView) findViewById(R.id.editfamilydocter);
                TextView editteldocter = (TextView) findViewById(R.id.editteldocter);
                TextView spichaldocter = (TextView) findViewById(R.id.spichaldocter);

                //intent.putExtra("spostandocter",name_ostan);
                intent.putExtra("scheoul",(scheouel.getText()).toString());
                intent.putExtra("message", (editnamedocter.getText()).toString());
                intent.putExtra("family", (editfamilydocter.getText().toString()));
                intent.putExtra("tel", (editteldocter.getText().toString()));
               intent.putExtra("spichal",(spichaldocter.getText().toString()));

                startActivity(intent);

            }

       });
    }

  //  public void getCityS(){

//        final Spinner city=(Spinner)findViewById(R.id.spcitydocter);
//        int c = pHelper.getAllcity();
//        ArrayList<String> sitemss = new ArrayList<String>();
//       for (city item : pHelper.getCities()) {
//            sitemss.add(item.name);
//        }
//        ArrayAdapter<String> sa = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, sitemss);
//        city.setAdapter(sa);

    }
