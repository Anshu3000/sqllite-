package com.example.sqlite;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.adapter.Recycleview1;
import com.example.data.Databasehandler;
import com.example.model.Contact;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity  {

    Databasehandler db123;
      private RecyclerView r1;
     private ArrayAdapter<String> Arr;
       private Recycleview1 recyAd;
     private List<Contact> lic;
   private   Contact carr[]={
             new Contact("koli","89990110"),
             new Contact("happy","982067"),
             new Contact("jalebi","0000000"),
             new Contact("ali","123453"),
             new Contact("leo","87659012"),
             new Contact("ios","6789054"),
             new Contact("android","908765421"),
             new Contact("hello","000008911"),
             new Contact("JIO","00054132"),
             new Contact("koli12","98765412"),
             new Contact("sushant","8910876"),
             new Contact("susantraj","00087562")
     };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        r1=findViewById(R.id.rec1);
        r1.setHasFixedSize(true);
        r1.setLayoutManager(new LinearLayoutManager(this));

        db123=new Databasehandler(this);
        SQLiteDatabase db=db123.getWritableDatabase();
        lic=new ArrayList<>();

        List<Contact> lic123=db123.getallc();
        Log.d("pos1","lis"+lic123);

        for (Contact c1 : lic123){
            lic.add(c1);
        }

         recyAd=new Recycleview1(this,lic);
          r1.setAdapter(recyAd);

        Log.d("pos","lis"+lic);

//        for (Contact c1 : lic123){
//            lic.add(c1.getName());
//        }



    }
}
