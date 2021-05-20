package com.example.singinuo.loginoffice;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.AppCompatButton;
import com.example.singinuo.MainActivity;
import com.example.singinuo.R;
import com.example.singinuo.db.MSP;
import com.example.singinuo.db.Retrofiting;
import com.example.singinuo.loginoffice.admin.AdminActivity;
import com.example.singinuo.loginoffice.facility.OfficeActivity;
import com.example.singinuo.model.MyActivity;
import com.example.singinuo.model.Office;

public class LoginOffice extends MyActivity {
    private int id;

    private EditText mEmailEditText;

    private AppCompatButton mLoginAppCompatButton;

    private EditText mPasswordEditText;

    private MSP officePref;

    private String password;

    private Retrofiting retrofiting;

    private TextView txtAnotherOptionOffice;

    public void onBackPressed() {
        this.mPasswordEditText.setText("");
        this.mEmailEditText.setText("");
        startActivity(new Intent((Context)this, MainActivity.class));
        finish();
    }

    public void onClick(View paramView) {
        int i = paramView.getId();
        if (i != R.id.btnLoginOffice) {
            if (i == R.id.txtAnotherOptionOffice) {
                startActivity(new Intent((Context)this, MainActivity.class));
                finish();
            }
        } else {
            try {
                this.id = Integer.parseInt(this.mEmailEditText.getText().toString());
                String str = this.mPasswordEditText.getText().toString();
                this.password = str;
                if (this.id == 0 && str.equals("admin")) {
                    startActivity(new Intent((Context)this, AdminActivity.class));
                } else {
                    this.retrofiting.getOneOffice(this.id);
                }
                return;
            } catch (Exception exception) {
                Toast.makeText((Context)this, "please enter number", Toast.LENGTH_LONG).show();
                return;
            }
        }
    }

    protected void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        setContentView(R.layout.activity_login_office);
        this.officePref = new MSP("OFFICEPREF", (Context)this);
        this.mEmailEditText = (EditText)findViewById(R.id.etxIdOffice);
        this.mPasswordEditText = (EditText)findViewById(R.id.etxPasswordOffice);
        this.mLoginAppCompatButton = (AppCompatButton)findViewById(R.id.btnLoginOffice);
        TextView textView = (TextView)findViewById(R.id.txtAnotherOptionOffice);
        this.txtAnotherOptionOffice = textView;
        textView.setOnClickListener(this::onClick);
        this.mLoginAppCompatButton.setOnClickListener(this::onClick);
        this.retrofiting = new Retrofiting(this);
    }

    public void setData(Object paramObject) {
        if (paramObject instanceof Office) {
            Office office = (Office)paramObject;
            if (office.getPassword().equals(this.password) && office.getActive()==1) {
                Toast.makeText((Context)this, "ok", Toast.LENGTH_LONG).show();
                paramObject = new Intent((Context)this, OfficeActivity.class);
                this.officePref.setOffice(office);
                startActivity((Intent)paramObject);
                finish();
            }
        }
    }
}
