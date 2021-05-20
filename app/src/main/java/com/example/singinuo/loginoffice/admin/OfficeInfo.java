package com.example.singinuo.loginoffice.admin;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.AppCompatButton;

import com.example.singinuo.R;
import com.example.singinuo.db.Retrofiting;
import com.example.singinuo.model.MyActivity;
import com.example.singinuo.model.Office;

public class OfficeInfo extends MyActivity implements TextWatcher {
    public static final String ACTIVEOFFICE = "ACTIVEOFFICE";

    public static final String ADDRESSOFFICE = "ADDRESSOFFICE";

    public static final String IDOFFICE = "IDOFFICE";

    public static final String NAMEOFFICE = "NAMEOFFICE";

    public static final String PASSWORDOFFICE = "PASSWORDOFFICE";

    public static final String PHONEOFFICE = "PHONEOFFICE";

    private int active;

    private Switch activeSwitch;

    private String address;

    private AppCompatButton delete;

    private EditText etxAddress;

    private TextView txtId;

    private EditText etxName;

    private EditText etxPassword;

    private EditText etxPhone;

    private int id;

    private String name;

    private Office office;

    private String password;

    private String phone;

    private Retrofiting retrofiting;

    private AppCompatButton save;

    private AlertDialog askOption(String paramString) {
        return (new AlertDialog.Builder((Context)this)).setTitle("Delete").setMessage("Do you want to Delete Office " + paramString).setIcon(R.drawable.delete ).setPositiveButton("Delete", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface param1DialogInterface, int param1Int) {
                OfficeInfo.this.retrofiting.deleteOneOffice(OfficeInfo.this.office.getId());
                param1DialogInterface.dismiss();
            }
        }).setNegativeButton("cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface param1DialogInterface, int param1Int) {
                param1DialogInterface.dismiss();
            }
        }).create();
    }

    public void afterTextChanged(Editable paramEditable) {
        if (this.id == -1) {
            if (this.etxPhone.getText().toString().equals("") || this.etxPassword.getText().toString().equals("") || this.etxAddress.getText().toString().equals("") || this.etxName.getText().toString().equals("")) {
                this.save.setEnabled(false);
                return;
            }
            this.save.setEnabled(true);
        }
    }

    public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}

    public void onClick(View paramView) {
        int i = paramView.getId();
        if (i == R.id.btnSaveFInfo) {

                if (this.id == -1) {
                    office=new Office(name,address,phone,password,active);

                if (this.activeSwitch.isChecked()) {
                    this.retrofiting.storeOffice(new Office(this.etxName.getText().toString(), this.etxAddress.getText().toString(), this.etxPhone.getText().toString(), this.etxPassword.getText().toString(), 1));
                } else
                    this.retrofiting.storeOffice(new Office(this.etxName.getText().toString(), this.etxAddress.getText().toString(), this.etxPhone.getText().toString(), this.etxPassword.getText().toString(), 0));

        } else  {
                    office.setActive(active);
                    office.setAddress(address);
                    office.setName(name);
                    office.setPassword(password);
                    office.setPhone(phone);
                    this.retrofiting.editeOffice(office);

                }
        }
        if (i== R.id.btnDeleteFInfo)            askOption(this.office.getName()).show();

    }

    protected void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        setContentView(R.layout.activity_office_info);
        this.etxAddress = (EditText)findViewById(R.id.etxAddressOfficeInfo);
        this.txtId = (TextView)findViewById(R.id.etxId);
        this.etxName = (EditText)findViewById(R.id.etxNameOfficeInfo);
        this.etxPassword = (EditText)findViewById(R.id.etxPasswordOfficeInfo);
        this.etxPhone = (EditText)findViewById(R.id.etxPhoneOfficeInfo);
        this.activeSwitch = (Switch)findViewById(R.id.switchOfficeInfo);
        this.save = (AppCompatButton)findViewById(R.id.btnSaveFInfo);
        this.delete = (AppCompatButton)findViewById(R.id.btnDeleteFInfo);
        this.save.setOnClickListener((View.OnClickListener)this);
        this.delete.setOnClickListener((View.OnClickListener)this);
        Intent intent = getIntent();
        this.id = intent.getIntExtra("IDOFFICE", -1);
        this.retrofiting = new Retrofiting(this);
        if (this.id != -1) {
            this.name = intent.getStringExtra("NAMEOFFICE");
            this.address = intent.getStringExtra("ADDRESSOFFICE");
            this.active = intent.getIntExtra("ACTIVEOFFICE", -1);
            this.password = intent.getStringExtra("PASSWORDOFFICE");
            this.phone = intent.getStringExtra("PHONEOFFICE");
            this.office = new Office(this.id, this.name, this.address, this.phone, this.password, this.active);
            this.etxPhone.setText(this.phone);
            this.etxPassword.setText(this.password);
            this.etxName.setText(this.name);
            this.txtId.setText(intent.getIntExtra("IDOFFICE", -1) + "");
            this.etxAddress.setText(this.address);
            if (this.active == 1) {
                this.activeSwitch.setChecked(true);
            } else {
                this.activeSwitch.setChecked(false);
            }
            this.save.setEnabled(false);
            this.etxAddress.addTextChangedListener(new TextWatcher() {
                public void afterTextChanged(Editable param1Editable) {
                    OfficeInfo officeInfo = OfficeInfo.this;
                    address=officeInfo.etxAddress.getText().toString();
                    if (OfficeInfo.this.address.equals(OfficeInfo.this.office.getAddress()) && OfficeInfo.this.name.equals(OfficeInfo.this.office.getName()) && OfficeInfo.this.password.equals(OfficeInfo.this.office.getPassword()) && OfficeInfo.this.active == OfficeInfo.this.office.getActive() && OfficeInfo.this.phone.equals(OfficeInfo.this.office.getPhone())) {
                        OfficeInfo.this.save.setEnabled(false);
                    } else {
                        OfficeInfo.this.save.setEnabled(true);
                    }
                }

                public void beforeTextChanged(CharSequence param1CharSequence, int param1Int1, int param1Int2, int param1Int3) {}

                public void onTextChanged(CharSequence param1CharSequence, int param1Int1, int param1Int2, int param1Int3) {}
            });
            this.etxName.addTextChangedListener(new TextWatcher() {
                public void afterTextChanged(Editable param1Editable) {
                    OfficeInfo officeInfo = OfficeInfo.this;
                   name= officeInfo.etxName.getText().toString();
                    if (OfficeInfo.this.address.equals(OfficeInfo.this.office.getAddress()) && OfficeInfo.this.name.equals(OfficeInfo.this.office.getName()) && OfficeInfo.this.password.equals(OfficeInfo.this.office.getPassword()) && OfficeInfo.this.active == OfficeInfo.this.office.getActive() && OfficeInfo.this.phone.equals(OfficeInfo.this.office.getPhone())) {
                        OfficeInfo.this.save.setEnabled(false);
                    } else {
                        OfficeInfo.this.save.setEnabled(true);
                    }
                }

                public void beforeTextChanged(CharSequence param1CharSequence, int param1Int1, int param1Int2, int param1Int3) {}

                public void onTextChanged(CharSequence param1CharSequence, int param1Int1, int param1Int2, int param1Int3) {}
            });
            this.etxPassword.addTextChangedListener(new TextWatcher() {
                public void afterTextChanged(Editable param1Editable) {
                    OfficeInfo officeInfo = OfficeInfo.this;
                   password= officeInfo.etxPassword.getText().toString();
                    if (OfficeInfo.this.address.equals(OfficeInfo.this.office.getAddress()) && OfficeInfo.this.name.equals(OfficeInfo.this.office.getName()) && OfficeInfo.this.password.equals(OfficeInfo.this.office.getPassword()) && OfficeInfo.this.active == OfficeInfo.this.office.getActive() && OfficeInfo.this.phone.equals(OfficeInfo.this.office.getPhone())) {
                        OfficeInfo.this.save.setEnabled(false);
                    } else {
                        OfficeInfo.this.save.setEnabled(true);
                    }
                }

                public void beforeTextChanged(CharSequence param1CharSequence, int param1Int1, int param1Int2, int param1Int3) {}

                public void onTextChanged(CharSequence param1CharSequence, int param1Int1, int param1Int2, int param1Int3) {}
            });
            this.etxPhone.addTextChangedListener(new TextWatcher() {
                public void afterTextChanged(Editable param1Editable) {
                    OfficeInfo officeInfo = OfficeInfo.this;
                  phone= officeInfo.etxPhone.getText().toString();
                    if (OfficeInfo.this.address.equals(OfficeInfo.this.office.getAddress()) && OfficeInfo.this.name.equals(OfficeInfo.this.office.getName()) && OfficeInfo.this.password.equals(OfficeInfo.this.office.getPassword()) && OfficeInfo.this.active == OfficeInfo.this.office.getActive() && OfficeInfo.this.phone.equals(OfficeInfo.this.office.getPhone())) {
                        OfficeInfo.this.save.setEnabled(false);
                    } else {
                        OfficeInfo.this.save.setEnabled(true);
                    }
                }

                public void beforeTextChanged(CharSequence param1CharSequence, int param1Int1, int param1Int2, int param1Int3) {}

                public void onTextChanged(CharSequence param1CharSequence, int param1Int1, int param1Int2, int param1Int3) {}
            });
            this.activeSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                public void onCheckedChanged(CompoundButton param1CompoundButton, boolean param1Boolean) {
                    if (OfficeInfo.this.activeSwitch.isChecked()) {
                       active=1;
                    } else {
                        active=0;
                    }
                    if (OfficeInfo.this.address.equals(OfficeInfo.this.office.getAddress()) && OfficeInfo.this.name.equals(OfficeInfo.this.office.getName()) && OfficeInfo.this.password.equals(OfficeInfo.this.office.getPassword()) && OfficeInfo.this.active == OfficeInfo.this.office.getActive() && OfficeInfo.this.phone.equals(OfficeInfo.this.office.getPhone())) {
                        OfficeInfo.this.save.setEnabled(false);
                    } else {
                        OfficeInfo.this.save.setEnabled(true);
                    }
                }
            });
        } else {
            this.delete.setEnabled(false);
            this.txtId.setVisibility(View.INVISIBLE);
            this.etxName.addTextChangedListener(this);
            this.etxAddress.addTextChangedListener(this);
            this.etxPassword.addTextChangedListener(this);
            this.etxName.addTextChangedListener(this);
            this.save.setEnabled(false);
            this.etxPhone.setInputType(2);
        }
    }

    public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}

    public void setData(Object paramObject) {
        if (paramObject != null)
            finish();
    }
}
