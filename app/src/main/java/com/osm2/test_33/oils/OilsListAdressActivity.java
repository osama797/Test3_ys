package com.osm2.test_33.oils;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.osm2.test_33.R;
import com.osm2.test_33.TestActivity;
import com.osm2.test_33.activity.MainActivity;
import com.osm2.test_33.activity.ReMain2Activity;
import com.osm2.test_33.oils.lukoil.Oil_LUKOIL;


import java.util.ArrayList;


public class OilsListAdressActivity extends AppCompatActivity {
    private ArrayList<oil_address_M> mExampleList;
    // private ArrayList<list_address_Adapter> mExampleLists;

    public RecyclerView mRecyclerView;
    public address_S_Adapter mAdapter;
    public RecyclerView.LayoutManager mLayoutManager;
    // public  list_address_Adapter adpt;
    Typeface mytypeface;

    public Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oils_list_adress);
        toolbar = findViewById(R.id.toolbar_oils_adress);
        //toolbar.setTitle("دليل زيوت المحركات المسجله لدى الهيئة اليمنية");
        toolbar.setTitleTextAppearance(this, R.style.toolbarStyle);

        // toolbar.setTitleMarginStart(250);
        // toolbar.setTitleMarginEnd(250);
       // toolbar.setTitleTextColor(Color.WHITE);
        toolbar.setNavigationIcon(R.drawable.back); // your drawable
        //toolbar.setTitleMarginStart(150);
        // toolbar.setTitleMarginBottom(10);
        //toolbar.setTitleTextColor(Color.WHITE);

        //toolbar.setLogo(R.drawable.ic_menu2);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // onSupportNavigateUp();
                Intent intent = new Intent(OilsListAdressActivity.this, MainActivity.class);
                //  intent.putExtra("gawda",s);
                startActivity(intent);
            }
        });



        Typeface  mytypeface=Typeface.createFromAsset(getAssets(),"fonts/flat.ttf");
        TextView txt=(TextView) findViewById(R.id.text_o) ;
        txt.setTypeface(mytypeface);

//        setSupportActionBar(toolbar);
        //  getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ///  ActionBar actionBar = getSupportActionBar();
        //  if (actionBar != null) {
        //   actionBar.setTitle("");
        //actionBar.setBackgroundDrawable);
        // }
//        actionBar.setDisplayHomeAsUpEnabled(true);


        createExampleList();
        buildRecyclerView();


        //  mRecyclerView = findViewById(R.id.recyclerView);
        // mRecyclerView.setHasFixedSize(true);
        // mLayoutManager = new LinearLayoutManager(this);
        //  mAdapter = new list_address_Adapter(exampleList);

        //  mRecyclerView.setLayoutManager(mLayoutManager);
        //  mRecyclerView.setAdapter(mAdapter);
    }

    public void createExampleList() {
        mExampleList = new ArrayList<>();
        mExampleList = new ArrayList<>();
        mExampleList.add(new oil_address_M("1","ناشيونال سوبر ديوتي", R.drawable.next));
        mExampleList.add(new oil_address_M("2","LUK OIL", R.drawable.next));
        mExampleList.add(new oil_address_M("3","RAVENOL", R.drawable.next));
        mExampleList.add(new oil_address_M("4","بيرتامينا", R.drawable.next));
        mExampleList.add(new oil_address_M("5","SINOPEC", R.drawable.next));
        mExampleList.add(new oil_address_M("6","الصقر", R.drawable.next));
        mExampleList.add(new oil_address_M("7","TOTAL", R.drawable.next));
        mExampleList.add(new oil_address_M("8","ABRO", R.drawable.next));
        mExampleList.add(new oil_address_M("9","توب 1", R.drawable.next));
        mExampleList.add(new oil_address_M("10","Maj", R.drawable.next));
        mExampleList.add(new oil_address_M("11","RECKORD", R.drawable.next));
        mExampleList.add(new oil_address_M("12","GULF", R.drawable.next));


        // mytypeface=Typeface.createFromAsset(getAssets(),"fonts/flat.ttf");


        // mExampleList.add(new List_Address("", R.color.card_bg_color));
        //mExampleList.add(new List_Address("", R.color.card_bg_color));
    }

    public void buildRecyclerView() {
        //  LinearLayoutManager lm = new LinearLayoutManager(this);
        mRecyclerView = findViewById(R.id.recyclerView_oils_adress);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new address_S_Adapter(mExampleList);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener(new address_S_Adapter.OnItemClickListener() {
            @Override
            public void onItemClick(int posistion,View view) {
                Context context=view.getContext();
                Intent intent=new Intent();
                switch (posistion){
                    case 0:
                        intent =  new Intent(context, Oil_LUKOIL.class);
                        String list1Text = mExampleList.get(posistion).getName_single();
                        intent.putExtra("name_oilso", list1Text);
                        context.startActivity(intent);

                        //context.startActivity(intent);
                        break;
                    case 1:
                        intent =  new Intent(context, TestActivity.class);
                        context.startActivity(intent);
                        break;
                    case 2:
                        intent =  new Intent(context, TestActivity.class);
                        context.startActivity(intent);
                        break;
                    case 3:
                        intent =  new Intent(context, TestActivity.class);
                        context.startActivity(intent);
                        break;
                    case 4:
                        intent =  new Intent(context, TestActivity.class);
                        context.startActivity(intent);
                        break;
                    case 5:
                        intent =  new Intent(context, TestActivity.class);
                        context.startActivity(intent);
                        break;
                    case 6:
                        intent =  new Intent(context, TestActivity.class);
                        context.startActivity(intent);
                        break;
                    case 7:
                        intent =  new Intent(context, TestActivity.class);
                        context.startActivity(intent);
                        break;
                    case 8:
                        intent =  new Intent(context, TestActivity.class);
                        context.startActivity(intent);
                        break;
                    case 9:
                        intent =  new Intent(context, TestActivity.class);
                        context.startActivity(intent);
                        break;
                    case 10:
                        intent =  new Intent(context, TestActivity.class);
                        context.startActivity(intent);
                        break;
                    case 11:
                        intent =  new Intent(context, TestActivity.class);
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
