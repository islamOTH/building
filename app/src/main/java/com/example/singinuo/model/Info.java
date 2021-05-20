package com.example.singinuo.model;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.example.singinuo.MainActivity;

public class Info extends MyActivity {
    public void onBackPressed() {
        startActivity(new Intent((Context)this, MainActivity.class));
        finish();
    }

    public void onClick(View paramView) {}

    protected void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        setContentView(2131427360);
    }

    public void setData(Object paramObject) {}
}
