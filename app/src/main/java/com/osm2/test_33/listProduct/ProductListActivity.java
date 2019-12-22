package com.osm2.test_33.listProduct;

import android.app.ProgressDialog;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.osm2.test_33.R;
import com.osm2.test_33.adapter.Food_Adapter;
import com.osm2.test_33.model.Foods;
import com.osm2.test_33.sqlite.DatabaseHelper;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ProductListActivity extends AppCompatActivity {

    DatabaseHelper databaseHelper;
    SQLiteDatabase db;
    Cursor cur;
    Button btn;

    TextView txt1,txt2,txt3,txt4;
    public String Search_Name = "";

   // public ArrayList<Foods> mAdapter=new ArrayList<>();

    private Toolbar toolbar;
    private static final String URL_PRODUCTS = "http://ahmed797-001-site1.ftempurl.com/Api.php";

    //a list to store all the products
    List<Foods> productList;
    private ProgressDialog progressDialog;
    private int LimitS = 0;

    //the recyclerview
    RecyclerView recyclerView;
    public Food_Adapter adp;
   
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);

      //  ListView listView_food=(ListView) findViewById(R.id.lv_product);

        toolbar = findViewById(R.id.toolbar);

        toolbar.setTitleTextAppearance(this, R.style.toolbarStyle);
        toolbar.setTitleMarginStart(250);
        toolbar.setTitleTextColor(Color.WHITE);
//        setSupportActionBar(toolbar);
      //  getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Intent i = getIntent();
        String result = i.getStringExtra("name_address");
        toolbar.setTitle(result);
      // ActionBar actionBar = getSupportActionBar();
     //  if (actionBar != null) {
     //      actionBar.setTitle("");
      //      //actionBar.setBackgroundDrawable);
      //  }
//        actionBar.setDisplayHomeAsUpEnabled(true);

        LinearLayoutManager lm = new LinearLayoutManager(this);
        ////
       //  databaseHelper=new DatabaseHelper(this);

        progressDialog = new ProgressDialog(this);

        //Get_All_Users(0);

       /* ArrayList<Food_os> food_os=new ArrayList<>();
        food_os.add(new Food_os(1,"مياه ","صنعاء","0.75ml","9505070441001"));
        food_os.add(new Food_os(2,"ويفر مغطى بالشوكولاته","Zydo","80g","3800065781145"));


        food_os.add(new Food_os(3,"مياه ","صنعاء","0.75ml","9505070441001"));
        food_os.add(new Food_os(4,"ويفر مغطى بالشوكولاته","Zydo","80g","3800065781145"));
        food_os.add(new Food_os(5,"مياه ","صنعاء","0.75ml","9505070441001"));
        food_os.add(new Food_os(6,"ويفر مغطى بالشوكولاته","Zydo","80g","3800065781145"));
        food_os.add(new Food_os(7,"مياه ","صنعاء","0.75ml","9505070441001"));
        food_os.add(new Food_os(8,"ويفر مغطى بالشوكولاته","Zydo","80g","3800065781145"));
        food_os.add(new Food_os(9,"مياه ","صنعاء","0.75ml","9505070441001"));
        food_os.add(new Food_os(10,"ويفر مغطى بالشوكولاته","Zydo","80g","3800065781145"));
        food_os.add(new Food_os(11,"مياه ","صنعاء","0.75ml","9505070441001"));
        food_os.add(new Food_os(12,"ويفر مغطى بالشوكولاته","Zydo","80g","3800065781145"));
        food_os.add(new Food_os(13,"مياه ","صنعاء","0.75ml","9505070441001"));
        food_os.add(new Food_os(14,"ويفر مغطى بالشوكولاته","Zydo","80g","3800065781145"));
        food_os.add(new Food_os(15,"مياه ","صنعاء","0.75ml","9505070441001"));
        food_os.add(new Food_os(16,"ويفر مغطى بالشوكولاته","Zydo","80g","3800065781145"));
        food_os.add(new Food_os(17,"مياه ","صنعاء","0.75ml","9505070441001"));
        food_os.add(new Food_os(18,"ويفر مغطى بالشوكولاته","Zydo","80g","3800065781145"));
        food_os.add(new Food_os(19,"مياه ","صنعاء","0.75ml","9505070441001"));
        food_os.add(new Food_os(20,"ويفر مغطى بالشوكولاته","Zydo","80g","3800065781145")); */

      //  ArrayList<Food_os> food_os=databaseHelper.getAllFOODS();
       // FoodListAdapter foodListAdapter =new FoodListAdapter(this,R.layout.list_item_product,food_os);

       // listView_food.setAdapter(foodListAdapter);
        //

        //getting the recyclerview from xml
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(lm);

        //initializing the productlist
        productList = new ArrayList<>();

        //this method will fetch and parse json
        //to display it in recyclerview
        loadProducts();

    }

    private void loadProducts() {

        /*
        * Creating a String Request
        * The request type is GET defined by first parameter
        * The URL is defined in the second parameter
        * Then we have a Response Listener and a Error Listener
        * In response listener we will get the JSON response as a String
        * */
        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL_PRODUCTS,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            //converting the string to json array object
                            JSONArray array = new JSONArray(response);

                            //traversing through all the object
                            for (int i = 0; i < array.length(); i++) {

                                //getting product object from json array
                                JSONObject Foods = array.getJSONObject(i);

                                //adding the product to product list
                                productList.add(new Foods(
                                        Foods.getString("id"),
                                        Foods.getString("bar_code"),
                                        Foods.getString("name_food"),
                                        Foods.getString("mark_food"),
                                        Foods.getString("size_food"),
                                        Foods.getString("img_food")
                                ));
                            }

                            //creating adapter object and setting it to recyclerview
                          //  Food_Adapter adapter = new Food_Adapter(ProductListActivity.this, productList,);
                          //  recyclerView.setAdapter(adapter);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });

        //adding our stringrequest to queue
        Volley.newRequestQueue(this).add(stringRequest);
    }

}




       // CheckInternetConnection cic = new CheckInternetConnection(getApplicationContext());
      ///  Boolean Ch = cic.isConnectingToInternet();
      //  if (!Ch) {
          //  Toast.makeText(this, R.string.no_internet_connection, Toast.LENGTH_SHORT).show();
      ///  } else {
         //   progressDialog.setMessage(getString(R.string.Waite));
        //    progressDialog.setCancelable(true);
        //    progressDialog.show();
           // progressDialog.setProgressDrawable();



            //


