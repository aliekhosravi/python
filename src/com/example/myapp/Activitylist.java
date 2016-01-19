package com.example.myapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


/**
 * Created by farazp30 on 08/12/2015.
 */
public class Activitylist extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_item);

        Bundle bundle = getIntent().getExtras();
        String n = bundle.getString("message");
        String f = bundle.getString("family");
        String s = bundle.getString("spichal");
        String sc=bundle.getString("scheoul");
        String t=bundle.getString("tel");
        TextView scheoul=(TextView)findViewById(R.id.scheouel);
        scheoul.setText(sc);
        TextView editnamedocter = (TextView) findViewById(R.id.editnamedocter);
        editnamedocter.setText(n);
        TextView editfamilydocter = (TextView) findViewById(R.id.editfamilydocter);
        editfamilydocter.setText(f);
        TextView editteldocter = (TextView) findViewById(R.id.editteldocter);
      editteldocter.setText(t);
        TextView spichaldocter = (TextView) findViewById(R.id.spichaldocter);
        spichaldocter.setText(s);
       Button btnshow=(Button)findViewById(R.id.btnshow);
        btnshow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog dialog = new AlertDialog.Builder(Activitylist.this)
                        .setTitle("succisfull")
                        .setMessage("اطلاعات شما با موفقیت ثبت شد")
                        .setPositiveButton("ok", null)
                        .create();
                dialog.show();

            }
        });
        Button btnback = (Button) findViewById(R.id.btnback);
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               startActivity(new Intent(Activitylist.this,Activitydocter.class));
            }

        });

    }
}
