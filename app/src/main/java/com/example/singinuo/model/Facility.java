package com.example.singinuo.model;

import com.google.gson.annotations.SerializedName;

public class Facility {
    @SerializedName("address")
    private String address;

    @SerializedName("area")
    private double area;

    @SerializedName("des")
    private String des;

    @SerializedName("id")
    private int id;

    @SerializedName("id_office")
    private int id_office;

    @SerializedName("price")
    private double price;

    @SerializedName("title")
    private String title;

    @SerializedName("type")
    private String type;

    public Facility(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, double paramDouble1, double paramDouble2, String paramString4) {
        this.id = paramInt1;
        this.id_office = paramInt2;
        this.title = paramString1;
        this.type = paramString2;
        this.des = paramString3;
        this.price = paramDouble1;
        this.area = paramDouble2;
        this.address = paramString4;
    }

    public Facility(int paramInt, String paramString1, String paramString2, String paramString3, double paramDouble1, double paramDouble2, String paramString4) {
        this.id_office = paramInt;
        this.title = paramString1;
        this.type = paramString2;
        this.des = paramString3;
        this.price = paramDouble1;
        this.area = paramDouble2;
        this.address = paramString4;
    }

    public String getAddress() {
        return this.address;
    }

    public double getArea() {
        return this.area;
    }

    public String getDes() {
        return this.des;
    }

    public int getId() {
        return this.id;
    }

    public int getId_office() {
        return this.id_office;
    }

    public double getPrice() {
        return this.price;
    }

    public String getTitle() {
        return this.title;
    }

    public String getType() {
        return this.type;
    }

    public void setAddress(String paramString) {
        this.address = paramString;
    }

    public void setArea(double paramDouble) {
        this.area = paramDouble;
    }

    public void setDes(String paramString) {
        this.des = paramString;
    }

    public void setId(int paramInt) {
        this.id = paramInt;
    }

    public void setId_office(int paramInt) {
        this.id_office = paramInt;
    }

    public void setPrice(double paramDouble) {
        this.price = paramDouble;
    }

    public void setTitle(String paramString) {
        this.title = paramString;
    }

    public void setType(String paramString) {
        this.type = paramString;
    }
}