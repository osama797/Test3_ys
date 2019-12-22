package com.osm2.test_33.listProduct;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.osm2.test_33.R;

import java.text.SimpleDateFormat;
import java.util.Date;



public class ProductDetailActivity extends AppCompatActivity {
    private TextView tvProductBarcode;
    private TextView tvProductName;
    private TextView tvProductPrice;
    private TextView tvProductPurchaseDate;
    private TextView tvProductCommercialWarrantyDate;
    private TextView tvProductConstructorWarrantyDate;

    private TextView tvStoreName;
    private TextView tvStoreCity;
    private TextView tvStoreAddress;
    private TextView tvStoreWebsite;

    private View formOnlineStore;
    private View formOfflineStore;

    private LinearLayout documentContainer;

    //Realm realm;
    //Product product;
    //RealmList<Document> documents;

    String productId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);

        init();

        if (getActionBar() != null) {
            getActionBar().setDisplayHomeAsUpEnabled(true);
        }

        Log.i("ProductDetailActivity", "onCreate");

        if(savedInstanceState != null){
            Log.i("ProductDetailActivity", "savedInstanceState");
            productId = savedInstanceState.getString("path");

        }

    }

    private void init() {
        //tvProductBarcode = findViewById(R.id.tv_barcode);
     //   tvProductName = findViewById(R.id.tv_product_name);
       // tvProductPrice = findViewById(R.id.tv_product_price);
       // tvProductPurchaseDate = findViewById(R.id.tv_purchase_date);



    }

    private void displayProductDetail() {
        tvProductBarcode.setText("565645464");
        tvProductName.setText("مياه معباه");
        tvProductPrice.setText("حدة");
        tvProductPurchaseDate.setText("0.75ml");






    }






    @Override
    protected void onStart() {
        super.onStart();
        Log.i("ProductDetailActivity", "onStart");

        if(productId == null){
            productId = getIntent().getStringExtra("productId");
        }
        Log.i("ProductDetailActivity", "onStart product : "+productId);


    }

    @Override
    protected void onStop() {
        Log.i("ProductDetailActivity", "onStop");


        super.onStop();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        return super.onOptionsItemSelected(item);
    }










    private void showSucces() {
        Toast.makeText(this, "Product deleted !", Toast.LENGTH_SHORT).show();
    }

    private void showError() {
        Toast.makeText(this, "Product not deleted, try again !", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        Log.i("ProductDetailActivity", "onDestroy");
        super.onDestroy();
    }


}
