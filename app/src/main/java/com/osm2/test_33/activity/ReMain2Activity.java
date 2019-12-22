package com.osm2.test_33.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
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
import com.facebook.shimmer.ShimmerFrameLayout;
import com.osm2.test_33.R;
import com.osm2.test_33.listProduct.ProductListAdressActivity;
import com.osm2.test_33.adapter.Food_Adapter;
import com.osm2.test_33.model.Foods;
import com.wang.avi.AVLoadingIndicatorView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ReMain2Activity extends AppCompatActivity {
    RecyclerView NewsRecyclerview;
    Food_Adapter newsAdapter;
    List<Foods> mData;
    FloatingActionButton fabSwitcher;
    boolean isDark = false;

    ConstraintLayout rootLayout;
    EditText searchInput ;
    CharSequence search="";
    private ProgressDialog progressDialog;
    private static final String URL_PRODUCTS = "http://ahmed797-001-site1.ftempurl.com/Api.php";
    //private static final String URL_PRODUCTS = "http://dvxvx.c1.biz/Api.php";
    public LinearLayout errorLayout;
    public RelativeLayout noInternetLayout,containers;

    public LinearLayout progressLayout;
    public Button btn;
    private AVLoadingIndicatorView progressBar;
    private ShimmerFrameLayout shimmerFrameLayout;
    private CardView cardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // requestWindowFeature(Window.FEATURE_NO_TITLE);
      //  getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
              //  WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.re_main2);
        // let's make this activity on full screen

        shimmerFrameLayout = (ShimmerFrameLayout) findViewById(R.id.shimmer_view_container);



///        getSupportActionBar().hide();
        Toolbar toolbar=findViewById(R.id.toolbar);

        toolbar.setTitleTextAppearance(this, R.style.toolbarStyle);
        toolbar.setTitleMarginStart(250);
        toolbar.setTitleTextColor(Color.WHITE);
       toolbar.setNavigationIcon(R.drawable.back); // your drawable
        //toolbar.setLogo(R.drawable.ic_menu2);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // onSupportNavigateUp();
                Intent intent = new Intent(ReMain2Activity.this, ProductListAdressActivity.class);
                //  intent.putExtra("gawda",s);
                startActivity(intent);
            }
        });

        //toolbar.setNavigationIcon(R.drawable.barcode_menu_1);
        progressBar = (AVLoadingIndicatorView) findViewById(R.id.loading_bar);

//        setSupportActionBar(toolbar);
        //  getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Intent i = getIntent();
        String result = i.getStringExtra("name_address");
        TextView tst=(TextView) findViewById(R.id.text_main_title);
        tst.setText(result);
        Typeface mytypeface=Typeface.createFromAsset(getAssets(),"fonts/flat.ttf");
        tst.setTypeface(mytypeface);

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
        NewsRecyclerview.setItemAnimator(new DefaultItemAnimator());
        mData = new ArrayList<>();

        // load theme state


// fill list news with data
        // just for testing purpose i will fill the news list with random data
        // you may get your data from an api / firebase or sqlite database ...
       loadProducts();




// adapter ini and setup
      //  newsAdapter = new Food_Adapter(this,mData,isDark);
      //  newsAdapter = new Food_Adapter(this,mData,isDark);
     //   NewsRecyclerview.setAdapter(newsAdapter);
        LinearLayoutManager lm = new LinearLayoutManager(this);
        NewsRecyclerview.setHasFixedSize(true);
        NewsRecyclerview.setLayoutManager(lm);
        NewsRecyclerview.setLayoutManager(new LinearLayoutManager(this));






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
            shimmerFrameLayout.startShimmerAnimation();
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
            shimmerFrameLayout.stopShimmerAnimation();
            shimmerFrameLayout.setVisibility(View.GONE);
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
                                    JSONObject Foods = array.getJSONObject(i);

                                    //adding the product to product list
                                    mData.add(new Foods(
                                            Foods.getString("id"),
                                            Foods.getString("bar_code"),
                                            Foods.getString("name_food"),
                                            Foods.getString("mark_food"),
                                            Foods.getString("size_food"),
                                            Foods.getString("img_food")
                                    ));
                                }

                                //creating adapter object and setting it to recyclerview
                               // newsAdapter = new Food_Adapter(ReMain2Activity.this, mData,isDark);

                               newsAdapter = new Food_Adapter(ReMain2Activity.this, mData);
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