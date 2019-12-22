package com.osm2.test_33;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 11/15/2019.
 */

public class Send_Card extends StringRequest {

    private static final String URL_PRODUCTS = "http://ahmed797-001-site1.ftempurl.com/send_c2.php";
    private Map<String,String> MapData;
    public Send_Card(String address_com, String nmProduct_com, String name_company, String date_product_com, String type_com, String note_com
            , String imge_1, String name_cust, String email_cust, String phone_cust
            ,Response.Listener<String> listener) {
        super(Method.POST, URL_PRODUCTS, listener, null);
        MapData=new HashMap<>();
        MapData.put("xsaddress_com",address_com);
        MapData.put("xsnmProduct_com",nmProduct_com);
        MapData.put("xsname_company",name_company);
        MapData.put("xsdate_product_com",date_product_com);
        MapData.put("xstype_com",type_com);
        MapData.put("xsnote_com",note_com);
        MapData.put("xsimge_1",imge_1);
        MapData.put("xsname_cust",name_cust);
        MapData.put("xsemail_cust",email_cust);
        MapData.put("xsphone_cust",phone_cust);


    }
    @Override
    public Map<String,String> getParams(){
        return MapData;
    }


}
