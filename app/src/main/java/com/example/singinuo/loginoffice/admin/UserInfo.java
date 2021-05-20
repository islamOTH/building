package com.example.singinuo.loginoffice.admin;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.AppCompatButton;

import com.example.singinuo.R;
import com.example.singinuo.db.Retrofiting;
import com.example.singinuo.model.MyActivity;
import com.example.singinuo.model.User;

public class UserInfo extends MyActivity {
    public static final String EMAILUSER = "EMAILUSER";

    public static final String IDUSER = "IDUSER";

    public static final String NAMEUSER = "NAMEUSER";

    public static final String PASSWORDUSER = "PASSWORDUSER";

    private AppCompatButton delete;

    private String email;

    private EditText etxEmail;

    private TextView etxID;

    private EditText etxName;

    private EditText etxPassword;

    private String name;

    private String password;

    private Retrofiting retrofiting;

    private AppCompatButton save;

    private User user;

    private AlertDialog askOption(String paramString) {
        return (new AlertDialog.Builder((Context)this)).setTitle("Delete").setMessage("Do you want to Delete User :" + paramString).setIcon(R.drawable.delete).setPositiveButton("Delete", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface param1DialogInterface, int param1Int) {
                UserInfo.this.retrofiting.deleteOneUser(UserInfo.this.user.getId());
                param1DialogInterface.dismiss();
            }
        }).setNegativeButton("cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface param1DialogInterface, int param1Int) {
                param1DialogInterface.dismiss();
            }
        }).create();
    }

    public void onClick(View paramView) {
        int i = paramView.getId();
       if (i==R.id.btnSaveUserInfo){
                this.user.setEmail(this.email);
                this.user.setName(this.name);
                this.user.setPassword(this.password);
                this.retrofiting.editeUser(this.user);
            }
         else if (R.id.btnDeleteUserInfo==i)
            askOption(this.name).show();
        }


    protected void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        setContentView(R.layout.activity_user_info);
        this.etxEmail = (EditText)findViewById(R.id.emailUserInfo);
        this.etxID = (TextView)findViewById(R.id.idUserInfo);
        this.etxName = (EditText)findViewById(R.id.nameUserInfo);
        this.etxPassword = (EditText)findViewById(R.id.passwordUserInfo);
        this.save = (AppCompatButton)findViewById(R.id.btnSaveUserInfo);
        this.delete = (AppCompatButton)findViewById(R.id.btnDeleteUserInfo);
        this.save.setOnClickListener((View.OnClickListener)this);
        this.delete.setOnClickListener((View.OnClickListener)this);
        Intent intent = getIntent();
        this.retrofiting = new Retrofiting(this);
        User user = new User(intent.getIntExtra("IDUSER", -1), intent.getStringExtra("EMAILUSER"), intent.getStringExtra("PASSWORDUSER"), intent.getStringExtra("NAMEUSER"));
        this.user = user;
        this.etxPassword.setText(user.getPassword());
        this.etxName.setText(this.user.getName());
        this.etxID.setText(this.user.getId() + "");
        this.etxEmail.setText(this.user.getEmail());
        this.email = this.user.getEmail();
        this.name = this.user.getName();
        this.password = this.user.getPassword();
        this.save.setEnabled(false);
        this.etxPassword.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            public boolean onEditorAction(TextView param1TextView, int param1Int, KeyEvent param1KeyEvent) {
                return false;
            }
        });
        this.etxName.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable param1Editable) {
                UserInfo userInfo = UserInfo.this;
             name= userInfo.etxName.getText().toString();
                if (UserInfo.this.user.getName().equals(UserInfo.this.name) && UserInfo.this.user.getPassword().equals(UserInfo.this.password) && UserInfo.this.user.getEmail().equals(UserInfo.this.email)) {
                    UserInfo.this.save.setEnabled(false);
                } else {
                    UserInfo.this.save.setEnabled(true);
                }
            }

            public void beforeTextChanged(CharSequence param1CharSequence, int param1Int1, int param1Int2, int param1Int3) {}

            public void onTextChanged(CharSequence param1CharSequence, int param1Int1, int param1Int2, int param1Int3) {}
        });
        this.etxEmail.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable param1Editable) {
                UserInfo userInfo = UserInfo.this;
             email= userInfo.etxEmail.getText().toString();
                if (UserInfo.this.user.getEmail().equals(UserInfo.this.email) && UserInfo.this.user.getPassword().equals(UserInfo.this.password) && UserInfo.this.user.getName().equals(UserInfo.this.name)) {
                    UserInfo.this.save.setEnabled(false);
                } else {
                    UserInfo.this.save.setEnabled(true);
                }
            }

            public void beforeTextChanged(CharSequence param1CharSequence, int param1Int1, int param1Int2, int param1Int3) {}

            public void onTextChanged(CharSequence param1CharSequence, int param1Int1, int param1Int2, int param1Int3) {}
        });
        this.etxPassword.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable param1Editable) {
                UserInfo userInfo = UserInfo.this;
              password=userInfo.etxPassword.getText().toString();
                if (UserInfo.this.user.getPassword().equals(UserInfo.this.password) && UserInfo.this.user.getName().equals(UserInfo.this.name) && UserInfo.this.user.getEmail().equals(UserInfo.this.email)) {
                    UserInfo.this.save.setEnabled(false);
                } else {
                    UserInfo.this.save.setEnabled(true);
                }
            }

            public void beforeTextChanged(CharSequence param1CharSequence, int param1Int1, int param1Int2, int param1Int3) {}

            public void onTextChanged(CharSequence param1CharSequence, int param1Int1, int param1Int2, int param1Int3) {}
        });
    }

    public void setData(Object paramObject) {
        if (paramObject != null)
            finish();
    }
}
