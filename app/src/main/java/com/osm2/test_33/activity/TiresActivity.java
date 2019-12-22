package com.osm2.test_33.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toolbar;

import com.osm2.test_33.R;

public class TiresActivity extends AppCompatActivity {
private Toolbar toolbar;
private ImageView s;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tires);

        s=findViewById(R.id.img_tool);

        s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TiresActivity.this, MainActivity.class);
                //  intent.putExtra("gawda",s);
                startActivity(intent);
            }
        }); // your drawable


    }
}
