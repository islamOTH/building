package com.example.singinuo.loginuser;

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
import com.example.singinuo.model.MyActivity;
import com.example.singinuo.model.User;

public class LoginUser extends MyActivity implements View.OnClickListener {
    private String email;

    private EditText mEmailEditText;

    private AppCompatButton mLoginAppCompatButton;

    private EditText mPasswordEditText;

    MSP msp;

    private String password;

    private Retrofiting retrofiting;

    private TextView txtAnotherOptionUser;

    private TextView txtRegister;

    public void onClick(View paramView) {
        int i = paramView.getId();
        if (i != R.id.btnLoginUser) {
            if (i != R.id.txtAnotherOptionUser) {
                if (i == R.id.txtRegisterUser) {
                    startActivity(new Intent((Context)this, RegisterUserActivity.class));
                    finish();
                }
            } else {
                startActivity(new Intent((Context)this, MainActivity.class));
                finish();
            }
        } else {
            this.email = this.mEmailEditText.getText().toString();
            this.password = this.mPasswordEditText.getText().toString();
            this.retrofiting.getOneUser(this.email);
        }
    }

    protected void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        setContentView(R.layout.activity_login_user);
        this.mEmailEditText = (EditText)findViewById(R.id.etxEmailUser);
        this.mPasswordEditText = (EditText)findViewById(R.id.etxPasswordUser);
        this.mLoginAppCompatButton = (AppCompatButton)findViewById(R.id.btnLoginUser);
        this.txtAnotherOptionUser = (TextView)findViewById(R.id.txtAnotherOptionUser);
        TextView textView = (TextView)findViewById(R.id.txtRegisterUser);
        this.txtRegister = textView;
        textView.setOnClickListener(this::onClick);
        this.mLoginAppCompatButton.setOnClickListener(this::onClick);
        this.retrofiting = new Retrofiting(this);
        this.txtAnotherOptionUser.setOnClickListener(this::onClick);
        this.msp = new MSP("USERPREF", (Context)this);
    }

    public void setData(Object obj) {
        if (obj instanceof User) {
           User paramObject = (User) obj;
            if (paramObject.getPassword().equals(this.password)) {
                Toast.makeText((Context)this, "ok", Toast.LENGTH_LONG).show();
                this.msp.setUser((User)paramObject);
                startActivity(new Intent((Context)this, UserActivity.class));
                finish();
            }
        }
    }
}
