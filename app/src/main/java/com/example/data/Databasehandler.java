package com.example.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.model.Contact;
import com.example.util.Util;






public class Databasehandler extends SQLiteOpenHelper {
     Context context;
    public Databasehandler(@Nullable Context context) {
        super(context, Util.database_name, null,Util.databaseversion);
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String create="CREATE TABLE "+Util.table_name+" ( "+Util.column_id+" INTEGER PRIMARY KEY , "+Util.column_name+" TEXT ,"+Util.column_phone+" TEXT )";
         db.execSQL(create);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
      //  SQLiteDatabase db=this.getWritableDatabase();
        String drop="DROP TABLE IF EXISTS "+Util.table_name;
        db.execSQL(drop);
        onCreate(db);

    }

    public  void  addcontact(Contact con){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues co=new ContentValues();
        co.put(Util.column_name,con.getName());
        co.put(Util.column_phone,con.getPhoneno());

        db.insert(Util.table_name,con.getName(),co);

        Toast.makeText(context.getApplicationContext(),"insertion succesfull" ,Toast.LENGTH_SHORT).show();
    }

    public  Contact getcon(int id){
        SQLiteDatabase db=this.getReadableDatabase();
        String colu[]={Util.column_name,Util.column_phone};

        Cursor cu=db.query(Util.table_name,colu,Util.column_id+"=?",new String[] {String.valueOf(id)},null,null,null);

         if(cu!=null)
         { cu.moveToNext();
           Contact co1=new Contact(id,cu.getString(cu.getColumnIndex(Util.column_name)),cu.getString(cu.getColumnIndex(Util.column_phone)));
           return co1;
         }

      return null;
    }

   public  int updat(Contact co){
        SQLiteDatabase db=this.getWritableDatabase();

        ContentValues co1=new ContentValues();
        co1.put(Util.column_name,co.getName());
        co1.put(Util.column_phone,co.getPhoneno());

        return db.update(Util.table_name,co1,Util.column_id+"=?",new String[]{String.valueOf(co.getId())});
   }

   public void del(int id){
        SQLiteDatabase db=this.getReadableDatabase();
        db.delete(Util.table_name,Util.column_id+"=?",new String[]{String.valueOf(id)});

   }

}
