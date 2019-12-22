package com.osm2.test_33.model;

/**
 * Created by Administrator on 10/18/2019.
 */

public class List_Address {

    private String name_address ;
    private int img_address;

    public List_Address(String name_address, int img_address) {
        this.name_address = name_address;
        this.img_address = img_address;
    }

    public String getName_address() {
        return name_address;
    }

    public void setName_address(String name_address) {
        this.name_address = name_address;
    }

    public int getImg_address() {
        return img_address;
    }

    public void setImg_address(int img_address) {
        this.img_address = img_address;
    }

    public void changename_address(String text) {
        name_address = text;
    }
}
