package com.example.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.data.Databasehandler;
import com.example.model.Contact;

public class MainActivity extends AppCompatActivity {

    Databasehandler db123;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db123=new Databasehandler(this);
        SQLiteDatabase db=db123.getWritableDatabase();

        Contact co1=new Contact();
         co1.setName("anshu");
         co1.setPhoneno("98000000");
         db123.addcontact(co1);

        Contact co2=new Contact();
        co2.setName("ankit");
        co2.setPhoneno("9800123");
        db123.addcontact(co2);

        Contact co3=new Contact();
        co3.setName("jagd");
        co3.setPhoneno("980134000");
        db123.addcontact(co3);

        Contact coi=db123.getcon(1);

        Log.d("ret","oncreate "+coi.getName()+"/"+coi.getPhoneno());


        Contact coi2=db123.getcon(2);

        Log.d("ret","oncreate "+coi2.getName()+"/"+coi2.getPhoneno());

    }
}
