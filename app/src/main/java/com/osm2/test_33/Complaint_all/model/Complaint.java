package com.osm2.test_33.Complaint_all.model;


import java.io.Serializable;

public class Complaint
        implements Serializable
{
    public static final String Address_TAG = "address";
    public static final String ComplaintDate_TAG = "complaintDate";
    public static final String ComplaintType_TAG = "complaintType";
    public static final String Id_TAG = "id";
    public static final String Lat_TAG = "lat";
    public static final String Lng_TAG = "lng";
    public static final String Notes_TAG = "notes";
    public static final String ProductName_TAG = "productName";
    public static final String ProductionCompany_TAG = "productionCompany";
    public static final String ProductionDate_TAG = "productionDate";
    private String address;
    private String complaintDate;
    private String complaintType;
    private String email;
    private long id;
    private String img1;
    private String img2;
    private String img3;
    private String img4;
    private double lat;
    private double lng;
    private String mobile;
    private String notes;
    private String productName;
    private String productionCompany;
    private String productionDate;

    public String getAddress()
    {
        return this.address;
    }

    public String getComplaintDate()
    {
        return this.complaintDate;
    }

    public String getComplaintType()
    {
        return this.complaintType;
    }

    public String getEmail()
    {
        return this.email;
    }

    public long getId()
    {
        return this.id;
    }

    public String getImg1()
    {
        return this.img1;
    }

    public String getImg2()
    {
        return this.img2;
    }

    public String getImg3()
    {
        return this.img3;
    }

    public String getImg4()
    {
        return this.img4;
    }

    public double getLat()
    {
        return this.lat;
    }

    public double getLng()
    {
        return this.lng;
    }

    public String getMobile()
    {
        return this.mobile;
    }

    public String getNotes()
    {
        return this.notes;
    }

    public String getProductName()
    {
        return this.productName;
    }

    public String getProductionCompany()
    {
        return this.productionCompany;
    }

    public String getProductionDate()
    {
        return this.productionDate;
    }

    public void setAddress(String paramString)
    {
        this.address = paramString;
    }

    public void setComplaintDate(String paramString)
    {
        this.complaintDate = paramString;
    }

    public void setComplaintType(String paramString)
    {
        this.complaintType = paramString;
    }

    public void setEmail(String paramString)
    {
        this.email = paramString;
    }

    public void setId(long paramLong)
    {
        this.id = paramLong;
    }

    public void setImg1(String paramString)
    {
        this.img1 = paramString;
    }

    public void setImg2(String paramString)
    {
        this.img2 = paramString;
    }

    public void setImg3(String paramString)
    {
        this.img3 = paramString;
    }

    public void setImg4(String paramString)
    {
        this.img4 = paramString;
    }

    public void setLat(double paramDouble)
    {
        this.lat = paramDouble;
    }

    public void setLng(double paramDouble)
    {
        this.lng = paramDouble;
    }

    public void setMobile(String paramString)
    {
        this.mobile = paramString;
    }

    public void setNotes(String paramString)
    {
        this.notes = paramString;
    }

    public void setProductName(String paramString)
    {
        this.productName = paramString;
    }

    public void setProductionCompany(String paramString)
    {
        this.productionCompany = paramString;
    }

    public void setProductionDate(String paramString)
    {
        this.productionDate = paramString;
    }
}