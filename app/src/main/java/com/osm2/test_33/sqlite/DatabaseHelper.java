package com.osm2.test_33.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.osm2.test_33.model.Food_os;

import java.util.ArrayList;


public class DatabaseHelper extends SQLiteOpenHelper  {
     static final String DBNAME = "gawda_db";
     static final int VERSION = 1;



    public DatabaseHelper (Context context) {
       super(context,DBNAME,null,VERSION);
       //this.mContext=context;
        //AUTOICREMENT

    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String sdb="create table Foods (id_code VARCHAR PRIMARY KEY ,name_food VARCHAR(150),mark_food VARCHAR(50),size_food VARCHAR(50)) ";
       db.execSQL(sdb);
       // String sdb2="create table Foodss (id_code VARCHAR PRIMARY KEY ,name_food VARCHAR(150),mark_food VARCHAR(50),size_food VARCHAR(50)) ";
      //  db.execSQL(sdb2);
      // String isr="INSERT INTO Foods (name_food, mark_food, size_food, id_code ) VALUES ('9505070441001','0.75ml','صنعاء','مياه')";
     //   db.execSQL(isr);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldversion, int newversion) {

        String delete_qury="DROP Table Foods IF EXITS";
        db.execSQL(delete_qury);

        onCreate(db);


    }

    public void add_food (Food_os fo){

        SQLiteDatabase db=this.getWritableDatabase();

        ContentValues values=new ContentValues();
       // values.put("id",fo.getId_food());
        values.put("id_code",fo.getId_code());
        values.put("name_food",fo.getName_food());
        values.put("mark_food",fo.getMark_food());
        values.put("size_food",fo.getSize_food());

        db.insert("Foods",null,values);


    }

    public ArrayList<Food_os> getAllFOODS (){

        ArrayList<Food_os> foods= new ArrayList<>();

        String select_food1="SELECT * FROM Foods";

        SQLiteDatabase db=this.getReadableDatabase();
       Cursor cursor= db.rawQuery(select_food1,null);


       if (cursor.moveToFirst()){

           do {
               String barcodes=cursor.getString(cursor.getColumnIndex("id_code"));
               String name=cursor.getString(cursor.getColumnIndex("name_food"));
               String mark=cursor.getString(cursor.getColumnIndex("mark_food"));
               String size=cursor.getString(cursor.getColumnIndex("size_food"));

              // Integer ids=cursor.getInt(cursor.getColumnIndex("id"));

               Food_os foodss = new Food_os(barcodes,name,mark,size);

               foods.add(foodss);

           }while (cursor.moveToNext());
           cursor.close();
       }
        return foods;

    }

   /// public ArrayList get_ALL_Titles(){

     //   ArrayList arrayList=new ArrayList<>();
      //  SQLiteDatabase dbs =this.getReadableDatabase();
     //   String sql_select="select * from all_ys_gawda";

      //  Cursor res=dbs.rawQuery(sql_select,null);
      //  res.moveToFirst();
      //  while (res.isAfterLast() ==false){
       //     arrayList.add(res.getString(res.getColumnIndex("name")));
       //     res.moveToNext();
     //   }
      
     ///   return arrayList;
 //   }

}
