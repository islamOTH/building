package com.example.singinuo.model;

import com.google.gson.annotations.SerializedName;

public class Office {
    @SerializedName("active")
    private int active;

    @SerializedName("address")
    private String address;

    @SerializedName("id")
    private int id;

    @SerializedName("name")
    private String name;

    @SerializedName("password")
    private String password;

    @SerializedName("phone")
    private String phone;

    public Office(int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt2) {
        this.id = paramInt1;
        this.name = paramString1;
        this.address = paramString2;
        this.phone = paramString3;
        this.password = paramString4;
        this.active = paramInt2;
    }

    public Office(String name, String address, String phone, String password, int active) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.password = password;
        this.active = active;
    }

    public int getActive() {
        return this.active;
    }

    public String getAddress() {
        return this.address;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getPassword() {
        return this.password;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setActive(int paramInt) {
        this.active = paramInt;
    }

    public void setAddress(String paramString) {
        this.address = paramString;
    }

    public void setId(int paramInt) {
        this.id = paramInt;
    }

    public void setName(String paramString) {
        this.name = paramString;
    }

    public void setPassword(String paramString) {
        this.password = paramString;
    }

    public void setPhone(String paramString) {
        this.phone = paramString;
    }
}
