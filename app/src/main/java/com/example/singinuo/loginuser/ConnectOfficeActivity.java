package com.example.singinuo.loginuser;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;

import com.example.singinuo.R;
import com.example.singinuo.db.Retrofiting;
import com.example.singinuo.model.MyActivity;
import com.example.singinuo.model.Office;

public class ConnectOfficeActivity extends MyActivity {
    public static final String KEYIDOFFICE = "KEYIDOFFICE";

    AppCompatButton button;

    private int id;

    Office office;

    Retrofiting retrofiting;

    private TextView textView;

    public void onClick(View paramView) {
        if (paramView.getId() ==R.id.btnConnect) {
            Intent intent = new Intent("android.intent.action.DIAL");
            intent.setData(Uri.parse("tel:" + this.office.getPhone()));
            startActivity(intent);
        }
    }

    protected void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        setContentView(R.layout.activity_connect_office);
        this.id = getIntent().getIntExtra("KEYIDOFFICE", -1);
        Retrofiting retrofiting = new Retrofiting(this);
        this.retrofiting = retrofiting;
        retrofiting.getOneOffice(this.id);
        this.textView = (TextView)findViewById(R.id.txtconnect);
        AppCompatButton appCompatButton = (AppCompatButton)findViewById(R.id.btnConnect);
        this.button = appCompatButton;
        appCompatButton.setOnClickListener(this::onClick);
    }

    public void setData(Object paramObject) {
        if (paramObject instanceof Office) {
            this.office = (Office) paramObject ;
            if (office.getActive()==1)
            {this.textView.setText(":" + this.office.getName() + "\n: " + this.office.getAddress());}
            else
            { this.textView.setText("sory this office is not avilable");
            button.setVisibility(View.INVISIBLE);}

        }
    }
}
