package com.osm2.test_33;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 11/15/2019.
 */

public class Send_Data_TEST extends StringRequest {

    private static final String URL_PRODUCTS = "http://ahmed797-001-site1.ftempurl.com/ums.php";
    private Map<String,String> MapData;
    public Send_Data_TEST(String im1, String im2, String im3, String im4,String im5,String im6,Response.Listener<String>listener) {
        super(Method.POST, URL_PRODUCTS, listener, null);
        MapData=new HashMap<>();
        MapData.put("ximage_one",im1);
        MapData.put("ximage_two",im2);
        MapData.put("ximage3",im3);
        MapData.put("ximage4",im4);
        MapData.put("ximageid_one",im5);
        MapData.put("ximageid_two",im6);




    }
    @Override
    public Map<String,String> getParams(){
        return MapData;
    }


}
