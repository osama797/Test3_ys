package com.osm2.test_33.oils;

/**
 * Created by Administrator on 11/02/2019.
 */

public class oil_address_M {

    private String id_single;
    private String name_single;
    private int img_address_Single;

    public oil_address_M(String id_single, String name_single, int img_address_Single) {
        this.id_single = id_single;
        this.name_single = name_single;
        this.img_address_Single = img_address_Single;
    }

    public String getId_single() {
        return id_single;
    }

    public void setId_single(String id_single) {
        this.id_single = id_single;
    }

    public String getName_single() {
        return name_single;
    }

    public void setName_single(String name_single) {
        this.name_single = name_single;
    }

    public int getImg_address_Single() {
        return img_address_Single;
    }

    public void setImg_address_Single(int img_address_Single) {
        this.img_address_Single = img_address_Single;
    }
}