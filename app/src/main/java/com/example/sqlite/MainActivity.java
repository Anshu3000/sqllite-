package com.example.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.data.Databasehandler;
import com.example.model.Contact;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity  {

    Databasehandler db123;
    private ListView listV;
     private ArrayAdapter<String> Arr;
     private List<String> lic;
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
         listV=findViewById(R.id.list1);
        db123=new Databasehandler(this);
        SQLiteDatabase db=db123.getWritableDatabase();

        lic=new ArrayList<>();

//        {
//        Contact co1=new Contact();
//         co1.setName("anshu");
//         co1.setPhoneno("98000000");
//         db123.addcontact(co1);
//
//        Contact co2=new Contact();
//        co1.setName("ankit");
//        co1.setPhoneno("9898000");
//        db123.addcontact(co1);
//
//        Contact co3=new Contact();
//        co1.setName("hello");
//        co1.setPhoneno("9806654");
//        db123.addcontact(co1);
//
//        Contact co4=new Contact();
//        co1.setName("anshu23");
//        co1.setPhoneno("9806789");
//        db123.addcontact(co1);
//
//        Contact co5=new Contact();
//        co1.setName("anshu677");
//        co1.setPhoneno("9812345");
//        db123.addcontact(co1);
//
//        Contact co6=new Contact();
//        co1.setName("jumanjiu");
//        co1.setPhoneno("980989");
//        db123.addcontact(co1);
//
//        Contact co567=new Contact();
//        co1.setName("vikram");
//        co1.setPhoneno("989876");
//        db123.addcontact(co1); }

//        for(int i=0;i<carr.length; i++){
//            db123.addcontact(carr[i]);
//        }



        List<Contact> lic123=db123.getallc();

        for (Contact c1 : lic123){
            lic.add(c1.getName());
        }

        Arr=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,lic);
          listV.setAdapter(Arr);

          listV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
              @Override
              public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                  Toast.makeText(getApplicationContext(),"position  "+position, Toast.LENGTH_SHORT).show();
              }
          });

    }
}
