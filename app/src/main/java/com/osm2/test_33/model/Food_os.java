package com.osm2.test_33.model;


public class Food_os{

   // private int id_food;
   private String id_code;
    private String name_food;
    private String mark_food;
    private String size_food;


    public Food_os(String id_code,String name_food, String mark_food, String size_food) {
        this.id_code = id_code;
        this.name_food = name_food;
        this.mark_food = mark_food;
        this.size_food = size_food;

    }

    public String getId_code() {
        return id_code;
    }

    public void setId_code(String id_code) {
        this.id_code = id_code;
    }

    public String getName_food() {
        return name_food;
    }

    public void setName_food(String name_food) {
        this.name_food = name_food;
    }

    public String getMark_food() {
        return mark_food;
    }

    public void setMark_food(String mark_food) {
        this.mark_food = mark_food;
    }

    public String getSize_food() {
        return size_food;
    }

    public void setSize_food(String size_food) {
        this.size_food = size_food;
    }



}