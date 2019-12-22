package com.osm2.test_33.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;


import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.StringRequestListener;
import com.androidnetworking.interfaces.UploadProgressListener;
//import com.darsh.multipleimageselect.models.Image;
//import com.esafirm.imagepicker.model.Image;

//import com.darsh.multipleimageselect.models.Image;
//import com.esafirm.imagepicker.features.ImagePicker;
import com.esafirm.imagepicker.features.ImagePicker;
import com.esafirm.imagepicker.model.Image;
import com.osm2.test_33.API.API;
import com.osm2.test_33.R;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class UploadActivity extends AppCompatActivity {
   Map<String,File> files =new HashMap<>();
   API api;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload);
        api= new API(this);
        ImagePicker.create(this)
                .multi() // multi mode (default mode)
                .limit(5)
               .start(1000);



    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1000 && resultCode == RESULT_OK && data != null) {
            //ArrayList<Image> images =(ArrayList<Image>) ImagePicker.getImages(data);
            ArrayList<Image> images = (ArrayList<Image>) ImagePicker.getImages(data);
            for(int i =0;i < images.size()-1;i++){
                files.put("documents["+i+"]",new File(images.get(i).getPath()));
            }
            api.posImages(files, new StringRequestListener() {
                @Override
                public void onResponse(String response) {

                }

                @Override
                public void onError(ANError anError) {

                }
            }, new UploadProgressListener() {
                @Override
                public void onProgress(long bytesUploaded, long totalBytes) {
                    Log.i("UploadActivity",bytesUploaded+"");
                }
            });

        }
    }
}
