package com.osm2.test_33.Complaint_all.model;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 11/15/2019.
 */

public class Send_Data extends StringRequest {

    private static final String URL_PRODUCTS = "http://osama77-001-site1.dtempurl.com/send_Complaint.php";
    private Map<String,String> MapData;
    public Send_Data(String address_com, String nmProduct_com, String name_mark,String country
            ,String name_company,String patch_number,  String day1, String month1, String year1
            ,  String day2, String month2, String year2
            , String type_c, String note
            , String img1//, String img2, String img3, String img4
            , String name, String email, String phone//, String img_id, String img_idd
            ,Response.Listener<String> listener) {
        super(Method.POST, URL_PRODUCTS, listener, null);
        MapData=new HashMap<>();
        MapData.put("xxaddress_com",address_com);
        MapData.put("xxnmProduct_com",nmProduct_com);
        MapData.put("xname_mark",name_mark);
        MapData.put("xxcountry",country);
        MapData.put("xxname_company",name_company);
        MapData.put("xxpatch_number",patch_number);
        MapData.put("xxday1",day1);
        MapData.put("xxmonth1",month1);
        MapData.put("xyear1",year1);
        MapData.put("xxday2",day2);
        MapData.put("xxmonth2",month2);
        MapData.put("xyear2",year2);
        MapData.put("xxtype_c",type_c);
        MapData.put("xxnote",note);
        MapData.put("xximg1",img1);
//        MapData.put("xximg2",img2);
//        MapData.put("xximg3",img3);
//        MapData.put("xximg4",img4);
        MapData.put("xxname",name);
        MapData.put("xxemail",email);
        MapData.put("xxphone",phone);
//        MapData.put("xximg_id",img_id);
//        MapData.put("xximg_idd",img_idd);




    }
    @Override
    public Map<String,String> getParams(){
        return MapData;
    }


}
