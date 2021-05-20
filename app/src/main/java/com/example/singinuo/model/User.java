package com.example.singinuo.model;

import com.google.gson.annotations.SerializedName;

public class User {
    @SerializedName("email")
    private String email;

    @SerializedName("id")
    private int id;

    @SerializedName("name")
    private String name;

    @SerializedName("password")
    private String password;

    public User(int paramInt, String paramString1, String paramString2, String paramString3) {
        this.id = paramInt;
        this.email = paramString1;
        this.password = paramString2;
        this.name = paramString3;
    }

    public User(String paramString1, String paramString2, String paramString3) {
        this.email = paramString1;
        this.password = paramString2;
        this.name = paramString3;
    }

    public String getEmail() {
        return this.email;
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

    public void setEmail(String paramString) {
        this.email = paramString;
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
}
