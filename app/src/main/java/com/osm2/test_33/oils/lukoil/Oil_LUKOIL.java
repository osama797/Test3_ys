package com.osm2.test_33.oils.lukoil;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.osm2.test_33.R;
import com.osm2.test_33.activity.CheckInternetConnection;

import com.osm2.test_33.oils.OilsListAdressActivity;
import com.osm2.test_33.oils.oil_M;
import com.wang.avi.AVLoadingIndicatorView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 11/03/2019.
 */

public class Oil_LUKOIL extends AppCompatActivity {
    RecyclerView NewsRecyclerview;
    lukoil_Adapter newsAdapter;
    List<oil_M> mData;
    FloatingActionButton fabSwitcher;
    boolean isDark = false;

    ConstraintLayout rootLayout;
    EditText searchInput ;
    CharSequence search="";
    private ProgressDialog progressDialog;
    private static final String URL_PRODUCTS = "http://ahmed797-001-site1.ftempurl.com/Api_Oils.php";
    public LinearLayout errorLayout;
    public RelativeLayout noInternetLayout;
    public LinearLayout progressLayout;
    public Button btn;
    private AVLoadingIndicatorView progressBar;
    public Toolbar toolbar;

    private int previousTotal = 0;
    private boolean loading = true;
    private int visibleThreshold = 5;
    int firstVisibleItem, visibleItemCount, totalItemCoun;
    LinearLayoutManager mLayoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oils_list);
         toolbar=findViewById(R.id.toolbar_oilss);
       // toolbar.setTitle("المنتجات");
       // toolbar.setTitleTextAppearance(this, R.style.toolbarStyle);
        //toolbar.setTitleMarginStart(150);
       // toolbar.setTitleTextColor(Color.WHITE);
        toolbar.setNavigationIcon(R.drawable.back); // your drawable
        //toolbar.setLogo(R.drawable.ic_menu2);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // onSupportNavigateUp();
                Intent intent = new Intent(Oil_LUKOIL.this, OilsListAdressActivity.class);
                //  intent.putExtra("gawda",s);
                startActivity(intent);
            }
        });

        //toolbar.setNavigationIcon(R.drawable.barcode_menu_1);
        progressBar = (AVLoadingIndicatorView) findViewById(R.id.loading_bar);

//        setSupportActionBar(toolbar);
        //  getSupportActionBar().setDisplayHomeAsUpEnabled(true);
       Intent i = getIntent();
        String resultsv = i.getStringExtra("name_oilso");
        TextView tsts=(TextView) findViewById(R.id.text_oils_title);
        tsts.setText(resultsv);
        Typeface mytypeface=Typeface.createFromAsset(getAssets(),"fonts/flat.ttf");
        tsts.setTypeface(mytypeface);
        // hide the action bar

        //  getSupportActionBar().hide();

        btn=findViewById(R.id.reconnect);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadProducts();
            }
        });



        // ini view

        fabSwitcher = findViewById(R.id.fab_switcher);
        rootLayout = findViewById(R.id.root_layout);
        searchInput = findViewById(R.id.search_input);
        NewsRecyclerview = findViewById(R.id.news_rv);
        mData = new ArrayList<>();

        // load theme state

        isDark = getThemeStatePref();
        if(isDark) {
            // dark theme is on

            searchInput.setBackgroundResource(R.drawable.search_input_dark_style);
            rootLayout.setBackgroundColor(getResources().getColor(R.color.vehicles_search));

        }
        else
        {
            // light theme is on
            searchInput.setBackgroundResource(R.drawable.search_input_style);
            rootLayout.setBackgroundColor(getResources().getColor(R.color.white));

        }
// fill list news with data
        // just for testing purpose i will fill the news list with random data
        // you may get your data from an api / firebase or sqlite database ...
        loadProducts();




// adapter ini and setup
        //  newsAdapter = new Food_Adapter(this,mData,isDark);
        //  newsAdapter = new Food_Adapter(this,mData,isDark);
        //   NewsRecyclerview.setAdapter(newsAdapter);
        mLayoutManager = new LinearLayoutManager(this);
        NewsRecyclerview.setLayoutManager(mLayoutManager);


        fabSwitcher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isDark = !isDark ;
                if (isDark) {

                    rootLayout.setBackgroundColor(getResources().getColor(R.color.black));
                    searchInput.setBackgroundResource(R.drawable.search_input_dark_style);

                }
                else {
                    rootLayout.setBackgroundColor(getResources().getColor(R.color.white));
                    searchInput.setBackgroundResource(R.drawable.search_input_style);
                }

                newsAdapter = new lukoil_Adapter(getApplicationContext(),mData,isDark);
                newsAdapter = new lukoil_Adapter(getApplicationContext(),mData,isDark);
                if (!search.toString().isEmpty()){

                    newsAdapter.getFilter().filter(search);

                }
                NewsRecyclerview.setAdapter(newsAdapter);
                saveThemeStatePref(isDark);




            }
        });



        searchInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {


                newsAdapter.getFilter().filter(s);
                search = s;


            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        // return true;


    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
    private void saveThemeStatePref(boolean isDark) {

        SharedPreferences pref = getApplicationContext().getSharedPreferences("myPref",MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putBoolean("isDark",isDark);
        editor.commit();
    }

    private boolean getThemeStatePref () {

        SharedPreferences pref = getApplicationContext().getSharedPreferences("myPref",MODE_PRIVATE);
        boolean isDark = pref.getBoolean("isDark",false) ;
        return isDark;

    }
    void startAnim(){
        progressBar.setVisibility(View.VISIBLE);
        // or avi.smoothToShow();
    }

    void stopAnim(){
        progressBar.setVisibility(View.INVISIBLE);
        // or avi.smoothToHide();
    }
    private void loadProducts() {

        /*
        * Creating a String Request
        * The request type is GET defined by first parameter
        * The URL is defined in the second parameter
        * Then we have a Response Listener and a Error Listener
        * In response listener we will get the JSON response as a String
        *
        *
        * */


        CheckInternetConnection cic = new CheckInternetConnection(getApplicationContext());
        Boolean Ch = cic.isConnectingToInternet();
        if (!Ch) {
            Toast.makeText(this, R.string.no_internet_connection, Toast.LENGTH_SHORT).show();
            errorLayout=findViewById(R.id.error_layout);
            errorLayout.setVisibility(View.VISIBLE);
            noInternetLayout=findViewById(R.id.no_internet_layout);
            noInternetLayout.setVisibility(View.VISIBLE);

            //  this.errorLayout.setVisibility(View.GONE);
            //  this.noInternetLayout.setVisibility(View.GONE);
        } else {
            // progressDialog.setMessage(getString(R.string.Waite));
            // progressDialog.setCancelable(true);
            // progressDialog.show();
            startAnim();

            errorLayout=findViewById(R.id.error_layout);
            errorLayout.setVisibility(View.INVISIBLE);
            noInternetLayout=findViewById(R.id.no_internet_layout);
            noInternetLayout.setVisibility(View.INVISIBLE);
            //progressDialog.setProgressDrawable();
            //  ReMain2Activity.this.progressLayout.setVisibility(View.GONE);
            //  ReMain2Activity.this.NewsRecyclerview.setVisibility(View.GONE);
            //  ReMain2Activity.this.noInternetLayout.setVisibility(View.GONE);
            //  ReMain2Activity.this.errorLayout.setVisibility(View.VISIBLE);

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
                                    JSONObject oil_M = array.getJSONObject(i);

                                    //adding the product to product list
                                   // mData.add(new oil_M(1,"",));
                                    mData.add(new oil_M(
                                            oil_M.getInt("id"),
                                            oil_M.getString("name_oil"),
                                            oil_M.getString("sae_oil"),
                                            oil_M.getString("api_oil"),
                                            oil_M.getString("size_oil"),
                                            oil_M.getString("patch_oil"),
                                            oil_M.getString("p_oil"),
                                            oil_M.getString("madein_oil"),
                                            oil_M.getString("customer_oil"),
                                            oil_M.getString("img_oils")

                                    ));
                                }

                                //creating adapter object and setting it to recyclerview
                                // newsAdapter = new Food_Adapter(ReMain2Activity.this, mData,isDark);

                                newsAdapter = new lukoil_Adapter(Oil_LUKOIL.this, mData,isDark);
                                NewsRecyclerview.setAdapter(newsAdapter);

                                stopAnim();
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

}