package com.example.singinuo.loginoffice.admin;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.widget.AppCompatButton;

import com.example.singinuo.R;
import com.example.singinuo.model.MyActivity;

public class AdminActivity extends MyActivity {
    private AppCompatButton btnOffices;

    private AppCompatButton btnUsers;

    public void onClick(View paramView) {
        int i = paramView.getId();

            if (i == R.id.btnUsersAdmin)
                startActivity(new Intent((Context)this, UsersActivity_Admin.class));
         else if (i == R.id.btnOfficesAdmin)
            startActivity(new Intent((Context)this, OfficesActivity_Admin.class));

    }

    protected void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        setContentView(R.layout.activity_admin_activityy);
        this.btnOffices = (AppCompatButton)findViewById(R.id.btnOfficesAdmin);
        AppCompatButton appCompatButton = (AppCompatButton)findViewById(R.id.btnUsersAdmin);
        this.btnUsers = appCompatButton;
        appCompatButton.setOnClickListener(this::onClick);
        this.btnOffices.setOnClickListener(this::onClick);
    }

    public void setData(Object paramObject) {}
}
