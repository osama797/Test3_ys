package com.osm2.test_33.listProduct;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.osm2.test_33.TestActivity;
import com.osm2.test_33.activity.MainActivity;
import com.osm2.test_33.R;
import com.osm2.test_33.activity.ReMain2Activity;
import com.osm2.test_33.activity.TiresActivity;
import com.osm2.test_33.model.List_Address;
import com.osm2.test_33.adapter.list_address_Adapter;

import java.util.ArrayList;

public class ProductListAdressActivity extends AppCompatActivity  {
    private ArrayList<List_Address> mExampleList;
   // private ArrayList<list_address_Adapter> mExampleLists;

    public RecyclerView mRecyclerView;
   public list_address_Adapter mAdapter;
    public RecyclerView.LayoutManager mLayoutManager;
    // public  list_address_Adapter adpt;
Typeface mytypeface;

    public Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list_adress);

        toolbar = findViewById(R.id.toolbar);
        //toolbar.setTitle("المنتجات المسجله لدى الهيئة اليمنية");
        toolbar.setTitleTextAppearance(this, R.style.toolbarStyle);

       // toolbar.setTitleMarginStart(250);
        ///toolbar.setTitleMarginEnd(250);
      // toolbar.setTitleTextColor(Color.WHITE);
       toolbar.setNavigationIcon(R.drawable.back); // your drawable
       // toolbar.setTitleMarginStart(150);
       // toolbar.setTitleMarginBottom(10);
       // toolbar.setTitleTextColor(Color.WHITE);
        //toolbar.setLogo(R.drawable.ic_menu2);
      toolbar.setNavigationOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
                // onSupportNavigateUp();
               Intent intent = new Intent(ProductListAdressActivity.this, MainActivity.class);
               //  intent.putExtra("gawda",s);
              startActivity(intent);
         }
        });



        Typeface  mytypeface=Typeface.createFromAsset(getAssets(),"fonts/flat.ttf");
        TextView txt=(TextView) findViewById(R.id.text_d) ;
       txt.setTypeface(mytypeface);


//       setSupportActionBar(toolbar);
//         getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // ActionBar actionBar = getSupportActionBar();
        //  if (actionBar != null) {
        //   actionBar.setTitle("");
        //actionBar.setBackgroundDrawable);
        // }
       // actionBar.setDisplayHomeAsUpEnabled(true);
       // getSupportActionBar().setDisplayHomeAsUpEnabled(true);



        createExampleList();
        buildRecyclerView();


    }

    public void createExampleList() {
        mExampleList = new ArrayList<>();
        mExampleList = new ArrayList<>();
        mExampleList.add(new List_Address("الكيميائية والبترولية والغزل والنسيج", R.drawable.next));
        mExampleList.add(new List_Address("القياس والمعايرة", R.drawable.next));
        mExampleList.add(new List_Address("الغذائية والزراعية", R.drawable.next));
        mExampleList.add(new List_Address("الميكانيكية والمعدنية", R.drawable.next));
        mExampleList.add(new List_Address("الكهربائية والإلكترونية والمقاييس والموازين", R.drawable.next));
        mExampleList.add(new List_Address("الغزل والنسيج والبيئة", R.drawable.next));
        mExampleList.add(new List_Address("التشييد ومواد البناء والمواد العامة", R.drawable.next));
        mExampleList.add(new List_Address("المواد العامة", R.drawable.next));

       // mytypeface=Typeface.createFromAsset(getAssets(),"fonts/flat.ttf");


        // mExampleList.add(new List_Address("", R.color.card_bg_color));
        //mExampleList.add(new List_Address("", R.color.card_bg_color));
    }

    public void buildRecyclerView() {
      //  LinearLayoutManager lm = new LinearLayoutManager(this);
        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new list_address_Adapter(mExampleList);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener(new list_address_Adapter.OnItemClickListener() {
            @Override
            public void onItemClick(int posistion,View view) {
                Context context=view.getContext();
                Intent intent=new Intent();
                switch (posistion){
                    case 0:
                        intent =  new Intent(context, TiresActivity.class);
                        context.startActivity(intent);
                        break;
                    case 1:
                        intent =  new Intent(context, TiresActivity.class);
                        context.startActivity(intent);
                        break;
                    case 2:
                        String list1Text = mExampleList.get(posistion).getName_address();
                        intent =  new Intent(context, ReMain2Activity.class);
                        intent.putExtra("name_address", list1Text);
                        context.startActivity(intent);
                        break;
                    case 3:
                        intent =  new Intent(context, TiresActivity.class);
                        context.startActivity(intent);
                        break;
                    case 4:
                        intent =  new Intent(context, TiresActivity.class);
                        context.startActivity(intent);
                        break;
                    case 5:
                        intent =  new Intent(context, TiresActivity.class);
                        context.startActivity(intent);
                        break;
                    case 6:
                        intent =  new Intent(context, TiresActivity.class);
                        context.startActivity(intent);
                        break;
                    case 7:
                        intent =  new Intent(context, TiresActivity.class);
                        context.startActivity(intent);
                        break;

                    default:


                        break;
                }

                context.startActivity(intent);
            }
        });

    }





}
