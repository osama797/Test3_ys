package com.osm2.test_33.API;

import android.content.Context;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.StringRequestListener;
import com.androidnetworking.interfaces.UploadProgressListener;

import java.io.File;
import java.util.Map;

/**
 * Created by Administrator on 12/05/2019.
 */

public class API {
    private Context context;

    public API(Context context) {
        this.context = context;
    }


    public void posImages(Map<String,File> files,StringRequestListener stringRequestListener,UploadProgressListener uploadProgressListener){
        AndroidNetworking.upload("http://ahmed797-001-site1.ftempurl.com/test3.php")
                .addMultipartFile(files)
                .setPriority(Priority.HIGH)
                .build()
                .setUploadProgressListener(uploadProgressListener)
                .getAsString(stringRequestListener);
    }


}
