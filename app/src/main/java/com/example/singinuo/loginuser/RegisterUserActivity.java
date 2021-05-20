package com.example.singinuo.loginuser;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.AppCompatButton;

import com.example.singinuo.R;
import com.example.singinuo.db.Retrofiting;
import com.example.singinuo.model.MyActivity;
import com.example.singinuo.model.User;
import java.util.regex.Pattern;

public class RegisterUserActivity extends MyActivity {
    private AppCompatButton btnRegister;

    private EditText etxConfirmPasswordRegisterUser;

    private EditText etxEmail;

    private EditText etxName;

    private EditText etxPassword;

    private Retrofiting retrofiting;

    private TextView txtLogin;

    public static boolean isEmailValid(String paramString) {
        boolean bool = false;
        if (Pattern.compile("^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$", 2).matcher(paramString).matches())
            bool = true;
        return bool;
    }

    public void onBackPressed() {
        startActivity(new Intent((Context)this, LoginUser.class));
        finish();
    }

    public void onClick(View paramView) {
        int i = paramView.getId();
        if (i != R.id.btnRegisterRegisterUser) {
            if (i == R.id.txtLoginRegisterUser) {
                startActivity(new Intent((Context)this, LoginUser.class));
                finish();
            }
        } else if (!this.etxConfirmPasswordRegisterUser.getText().toString().equals("") && !this.etxPassword.getText().toString().equals("") && !this.etxName.getText().toString().equals("") && !this.etxEmail.getText().toString().equals("")) {
            if (isEmailValid(this.etxEmail.getText().toString())) {
                if (this.etxConfirmPasswordRegisterUser.getText().toString().equals(this.etxPassword.getText().toString())) {
                    User user = new User(this.etxEmail.getText().toString(), this.etxPassword.getText().toString(), this.etxName.getText().toString());
                    this.retrofiting.storeUser(user);
                } else {
                    Toast.makeText((Context)this, "the password is not match ", Toast.LENGTH_LONG).show();
                    this.etxConfirmPasswordRegisterUser.setText("");
                    this.etxPassword.setText("");
                }
            } else {
                this.etxEmail.setText("");
                Toast.makeText((Context)this, "please enter corect email ", Toast.LENGTH_LONG).show();
            }
        } else {
            Toast.makeText((Context)this, "please enter name and email and password ", Toast.LENGTH_LONG).show();
        }
    }

    protected void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        setContentView(R.layout.activity_register_user);
        this.etxEmail = (EditText)findViewById(R.id.etxEmailRegisterUser);
        this.etxName = (EditText)findViewById(R.id.etxNameRegisterUser);
        this.etxPassword = (EditText)findViewById(R.id.etxPasswordRegisterUser);
        this.etxConfirmPasswordRegisterUser = (EditText)findViewById(R.id.etxConfirmPasswordRegisterUser);
        this.btnRegister = (AppCompatButton)findViewById(R.id.btnRegisterRegisterUser);
        TextView textView = (TextView)findViewById(R.id.txtLoginRegisterUser);
        this.txtLogin = textView;
        textView.setOnClickListener(this::onClick);
        this.btnRegister.setOnClickListener(this::onClick);
        this.retrofiting = new Retrofiting(this);
    }

    public void setData(Object paramObject) {
        if (((String)paramObject).equals("true")) {
            Toast.makeText((Context)this, "SuccessFull", Toast.LENGTH_LONG).show();
            startActivity(new Intent((Context)this, LoginUser.class));
            finish();
        } else if (((String)paramObject).equals("false")) {
            Toast.makeText((Context)this, "please enter difrent account this account is used", Toast.LENGTH_LONG).show();
            this.etxEmail.setText("");
            this.etxEmail.requestFocus();
        }
    }
}
