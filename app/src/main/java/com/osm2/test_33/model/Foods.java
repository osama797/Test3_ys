package com.osm2.test_33.model;

/**
 * Created by Administrator on 10/15/2019.
 */

public class Foods {

        private String id;
        private String bar_code;
        private String name_food;
        private String mark_food;
        private String size_food;
        private String img_food;

    public Foods(String id, String bar_code, String name_food, String mark_food, String size_food, String img_food) {
        this.id = id;
        this.bar_code = bar_code;
        this.name_food = name_food;
        this.mark_food = mark_food;
        this.size_food = size_food;
        this.img_food = img_food;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBar_code() {
        return bar_code;
    }

    public void setBar_code(String bar_code) {
        this.bar_code = bar_code;
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

    public String getImg_food() {
        return img_food;
    }

    public void setImg_food(String img_food) {
        this.img_food = img_food;
    }
}
