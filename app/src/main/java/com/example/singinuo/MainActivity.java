package com.example.singinuo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.widget.AppCompatButton;
import com.example.singinuo.db.Retrofiting;
import com.example.singinuo.loginoffice.LoginOffice;
import com.example.singinuo.loginuser.BrowseActivity;
import com.example.singinuo.loginuser.LoginUser;
import com.example.singinuo.model.Info;
import com.example.singinuo.model.MyActivity;

public class MainActivity extends MyActivity {
    private AppCompatButton mOfficeLoginAppCompatButton;

    private AppCompatButton mUserLoginAppCompatButton;

    private AppCompatButton mbtnBrowseOfficeMain;

    private AppCompatButton mbtnInfo;

    Retrofiting retrofiting;

    public void onBackPressed() {
        startActivity(new Intent((Context)this, LoginUser.class));
        finish();
    }

    public void onClick(View paramView) {
        switch (paramView.getId()) {

            case R.id.btnLoginOfficeMain:
                startActivity(new Intent((Context)this, LoginOffice.class));
                finish();break;
            case R.id.btnLoginUserMain:
                startActivity(new Intent((Context)this, LoginUser.class));
                finish();break;
            case R.id.btnBrowseOfficeMain:
                startActivity(new Intent((Context)this, BrowseActivity.class));

                finish();break;
            case R.id.btnInffoMain:
                startActivity(new Intent((Context)this, Info.class));
                finish();break;
            default:
                return;
        }
    }

    protected void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        setContentView(R.layout.activity_main);
        this.mOfficeLoginAppCompatButton = (AppCompatButton)findViewById(R.id.btnLoginOfficeMain);
        this.mUserLoginAppCompatButton = (AppCompatButton)findViewById(R.id.btnLoginUserMain);
        this.mbtnBrowseOfficeMain = (AppCompatButton)findViewById(R.id.btnBrowseOfficeMain);
        AppCompatButton appCompatButton = (AppCompatButton)findViewById(R.id.btnInffoMain);
        this.mbtnInfo = appCompatButton;
        appCompatButton.setOnClickListener(this::onClick);
        this.mbtnBrowseOfficeMain.setOnClickListener(this::onClick);
        this.mUserLoginAppCompatButton.setOnClickListener(this::onClick);
        this.mOfficeLoginAppCompatButton.setOnClickListener(this::onClick);
        this.retrofiting = new Retrofiting(this);
    }

    public void setData(Object paramObject) {}
}
