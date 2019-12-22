package com.osm2.test_33.oils;

/**
 * Created by Administrator on 11/02/2019.
 */

public class oil_M {

    private int id;
    private String name_oil;
    private String sae_oil;
    private String api_oil;
    private String size_oil;
    private String patch_oil;
    private String p_oil;
    private String madein_oil;
    private String customer_oil;
    private String img_oils;

    public oil_M(int id, String name_oil, String sae_oil, String api_oil, String size_oil, String patch_oil, String p_oil, String madein_oil, String customer_oil, String img_oils) {
        this.id = id;
        this.name_oil = name_oil;
        this.sae_oil = sae_oil;
        this.api_oil = api_oil;
        this.size_oil = size_oil;
        this.patch_oil = patch_oil;
        this.p_oil = p_oil;
        this.madein_oil = madein_oil;
        this.customer_oil = customer_oil;
        this.img_oils = img_oils;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName_oil() {
        return name_oil;
    }

    public void setName_oil(String name_oil) {
        this.name_oil = name_oil;
    }

    public String getSae_oil() {
        return sae_oil;
    }

    public void setSae_oil(String sae_oil) {
        this.sae_oil = sae_oil;
    }

    public String getApi_oil() {
        return api_oil;
    }

    public void setApi_oil(String api_oil) {
        this.api_oil = api_oil;
    }

    public String getSize_oil() {
        return size_oil;
    }

    public void setSize_oil(String size_oil) {
        this.size_oil = size_oil;
    }

    public String getPatch_oil() {
        return patch_oil;
    }

    public void setPatch_oil(String patch_oil) {
        this.patch_oil = patch_oil;
    }

    public String getP_oil() {
        return p_oil;
    }

    public void setP_oil(String p_oil) {
        this.p_oil = p_oil;
    }

    public String getMadein_oil() {
        return madein_oil;
    }

    public void setMadein_oil(String madein_oil) {
        this.madein_oil = madein_oil;
    }

    public String getCustomer_oil() {
        return customer_oil;
    }

    public void setCustomer_oil(String customer_oil) {
        this.customer_oil = customer_oil;
    }



    public String getImg_oils() {
        return img_oils;
    }

    public void setImg_oils(String img_oils) {
        this.img_oils = img_oils;
    }
}
