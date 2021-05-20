package com.example.singinuo.loginoffice.facility;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.AppCompatButton;

import com.example.singinuo.R;
import com.example.singinuo.db.Retrofiting;
import com.example.singinuo.model.Facility;
import com.example.singinuo.model.MyActivity;

public class FacilityInfo extends MyActivity implements TextWatcher {
    public static final String KEYADDRESS = "KEYADDRESS";

    public static final String KEYAREA = "KEYAREA";

    public static final String KEYDES = "KEYDES";

    public static final String KEYID = "KEYID";

    public static final String KEYIDOFFICE = "KEYIDOFFICE";

    public static final String KEYPRICE = "KEYPRICE";

    public static final String KEYTITLE = "KEYTITLE";

    public static final String KEYTYPE = "KEYTYPE";

    private String address;

    private double area;

    private AppCompatButton delete;

    private String des;

    private EditText etxAddress;

    private EditText etxArea;

    private EditText etxDes;

    private EditText etxPrice;

    private EditText etxTitle;

    private EditText etxType;

    private Facility facility;

    private int id;

    private int id_office;

    private double price;

    private Retrofiting retrofiting;

    private AppCompatButton save;

    private String title;

    private TextView txtId;

    private TextView txtIdOffice;

    private String type;

    private AlertDialog askOption(String paramString) {
        return (new AlertDialog.Builder((Context)this)).setTitle("Delete").setMessage("Do you want to Delete Facillity " + paramString).setIcon(R.drawable.delete).setPositiveButton("Delete", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface param1DialogInterface, int param1Int) {
                FacilityInfo.this.retrofiting.deleteOneFacility(FacilityInfo.this.facility.getId());
                param1DialogInterface.dismiss();
            }
        }).setNegativeButton("cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface param1DialogInterface, int param1Int) {
                param1DialogInterface.dismiss();
            }
        }).create();
    }

    public void addTextChange() {
        this.save.setEnabled(false);
        this.etxType.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable param1Editable) {
                FacilityInfo facilityInfo = FacilityInfo.this;
               type= facilityInfo.etxType.getText().toString();
                if (FacilityInfo.this.address.equals(FacilityInfo.this.facility.getAddress()) && FacilityInfo.this.title.equals(FacilityInfo.this.facility.getTitle()) && FacilityInfo.this.price == FacilityInfo.this.facility.getPrice() && FacilityInfo.this.area == FacilityInfo.this.facility.getArea() && FacilityInfo.this.type.equals(FacilityInfo.this.facility.getType()) && FacilityInfo.this.des.equals(FacilityInfo.this.facility.getDes())) {
                    FacilityInfo.this.save.setEnabled(false);
                } else {
                    FacilityInfo.this.save.setEnabled(true);
                }
            }

            public void beforeTextChanged(CharSequence param1CharSequence, int param1Int1, int param1Int2, int param1Int3) {}

            public void onTextChanged(CharSequence param1CharSequence, int param1Int1, int param1Int2, int param1Int3) {}
        });
        this.etxDes.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable param1Editable) {
                FacilityInfo facilityInfo = FacilityInfo.this;
                des= facilityInfo.etxDes.getText().toString();
                if (FacilityInfo.this.address.equals(FacilityInfo.this.facility.getAddress()) && FacilityInfo.this.title.equals(FacilityInfo.this.facility.getTitle()) && FacilityInfo.this.price == FacilityInfo.this.facility.getPrice() && FacilityInfo.this.area == FacilityInfo.this.facility.getArea() && FacilityInfo.this.type.equals(FacilityInfo.this.facility.getType()) && FacilityInfo.this.des.equals(FacilityInfo.this.facility.getDes())) {
                    FacilityInfo.this.save.setEnabled(false);
                } else {
                    FacilityInfo.this.save.setEnabled(true);
                }
            }

            public void beforeTextChanged(CharSequence param1CharSequence, int param1Int1, int param1Int2, int param1Int3) {}

            public void onTextChanged(CharSequence param1CharSequence, int param1Int1, int param1Int2, int param1Int3) {}
        });
        this.etxAddress.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable param1Editable) {
                FacilityInfo facilityInfo = FacilityInfo.this;
                address= facilityInfo.etxAddress.getText().toString();
                if (FacilityInfo.this.address.equals(FacilityInfo.this.facility.getAddress()) && FacilityInfo.this.title.equals(FacilityInfo.this.facility.getTitle()) && FacilityInfo.this.price == FacilityInfo.this.facility.getPrice() && FacilityInfo.this.area == FacilityInfo.this.facility.getArea() && FacilityInfo.this.type.equals(FacilityInfo.this.facility.getType()) && FacilityInfo.this.des.equals(FacilityInfo.this.facility.getDes())) {
                    FacilityInfo.this.save.setEnabled(false);
                } else {
                    FacilityInfo.this.save.setEnabled(true);
                }
            }

            public void beforeTextChanged(CharSequence param1CharSequence, int param1Int1, int param1Int2, int param1Int3) {}

            public void onTextChanged(CharSequence param1CharSequence, int param1Int1, int param1Int2, int param1Int3) {}
        });
        this.etxArea.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable param1Editable) {
                FacilityInfo facilityInfo = FacilityInfo.this;
      area= Double.parseDouble(facilityInfo.etxArea.getText().toString());
                if (FacilityInfo.this.address.equals(FacilityInfo.this.facility.getAddress()) && FacilityInfo.this.title.equals(FacilityInfo.this.facility.getTitle()) && FacilityInfo.this.price == FacilityInfo.this.facility.getPrice() && FacilityInfo.this.area == FacilityInfo.this.facility.getArea() && FacilityInfo.this.type.equals(FacilityInfo.this.facility.getType()) && FacilityInfo.this.des.equals(FacilityInfo.this.facility.getDes())) {
                    FacilityInfo.this.save.setEnabled(false);
                } else {
                    FacilityInfo.this.save.setEnabled(true);
                }
            }

            public void beforeTextChanged(CharSequence param1CharSequence, int param1Int1, int param1Int2, int param1Int3) {}

            public void onTextChanged(CharSequence param1CharSequence, int param1Int1, int param1Int2, int param1Int3) {}
        });
        this.etxPrice.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable param1Editable) {
                FacilityInfo facilityInfo = FacilityInfo.this;
             price= Double.parseDouble(facilityInfo.etxPrice.getText().toString());
                if (FacilityInfo.this.address.equals(FacilityInfo.this.facility.getAddress()) && FacilityInfo.this.title.equals(FacilityInfo.this.facility.getTitle()) && FacilityInfo.this.price == FacilityInfo.this.facility.getPrice() && FacilityInfo.this.area == FacilityInfo.this.facility.getArea() && FacilityInfo.this.type.equals(FacilityInfo.this.facility.getType()) && FacilityInfo.this.des.equals(FacilityInfo.this.facility.getDes())) {
                    FacilityInfo.this.save.setEnabled(false);
                } else {
                    FacilityInfo.this.save.setEnabled(true);
                }
            }

            public void beforeTextChanged(CharSequence param1CharSequence, int param1Int1, int param1Int2, int param1Int3) {}

            public void onTextChanged(CharSequence param1CharSequence, int param1Int1, int param1Int2, int param1Int3) {}
        });
        this.etxTitle.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable param1Editable) {
                FacilityInfo facilityInfo = FacilityInfo.this;
               title= facilityInfo.etxTitle.getText().toString();
                if (FacilityInfo.this.address.equals(FacilityInfo.this.facility.getAddress()) && FacilityInfo.this.title.equals(FacilityInfo.this.facility.getTitle()) && FacilityInfo.this.price == FacilityInfo.this.facility.getPrice() && FacilityInfo.this.area == FacilityInfo.this.facility.getArea() && FacilityInfo.this.type.equals(FacilityInfo.this.facility.getType()) && FacilityInfo.this.des.equals(FacilityInfo.this.facility.getDes())) {
                    FacilityInfo.this.save.setEnabled(false);
                } else {
                    FacilityInfo.this.save.setEnabled(true);
                }
            }

            public void beforeTextChanged(CharSequence param1CharSequence, int param1Int1, int param1Int2, int param1Int3) {}

            public void onTextChanged(CharSequence param1CharSequence, int param1Int1, int param1Int2, int param1Int3) {}
        });
    }

    public void afterTextChanged(Editable paramEditable) {
        if (this.etxPrice.getText().toString().equals("") || this.etxArea.getText().toString().equals("") || this.etxType.getText().toString().equals("") || this.etxTitle.getText().toString().equals("") || this.etxAddress.getText().toString().equals("") || this.etxDes.getText().toString().equals("")) {
            this.save.setEnabled(false);
            return;
        }
        this.save.setEnabled(true);
    }

    public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}

    public void getParamter() {
        Intent intent = getIntent();
        int i = intent.getIntExtra("KEYID", -1);
        this.id = i;
        if (i != -1) {
            Toast.makeText((Context)this, this.id + "", Toast.LENGTH_LONG).show();
            this.id_office = intent.getIntExtra("KEYIDOFFICE", -1);
            this.price = intent.getDoubleExtra("KEYPRICE", -1.0D);
            this.des = intent.getStringExtra("KEYDES");
            this.title = intent.getStringExtra("KEYTITLE");
            this.type = intent.getStringExtra("KEYTYPE");
            this.area = intent.getDoubleExtra("KEYAREA", -1.0D);
            this.address = intent.getStringExtra("KEYADDRESS");
            this.facility = new Facility(this.id, this.id_office, this.title, this.type, this.des, this.price, this.area, this.address);
            this.etxPrice.setText(this.price + "");
            this.etxArea.setText(this.area + "");
            this.etxTitle.setText(this.title);
            this.etxDes.setText(this.des);
            this.etxType.setText(this.type);
            this.txtId.setText(this.id + "");
            this.etxAddress.setText(this.address);
            addTextChange();
        } else {
            Toast.makeText((Context)this, this.id + "", Toast.LENGTH_LONG).show();
            this.id_office = intent.getIntExtra("KEYIDOFFICE", -1);
            this.delete.setEnabled(false);
            this.txtId.setVisibility(View.INVISIBLE);
            this.etxDes.addTextChangedListener(this);
            this.etxType.addTextChangedListener(this);
            this.etxArea.addTextChangedListener(this);
            this.etxTitle.addTextChangedListener(this);
            this.etxAddress.addTextChangedListener(this);
            this.etxPrice.addTextChangedListener(this);
            this.save.setEnabled(false);
        }
    }

    public void onClick(View paramView) {
        int i = paramView.getId();
        if (i != delete.getId()) {
            if (i == save.getId())
                if (this.id != -1) {
                    this.facility.setAddress(this.address);
                    this.facility.setArea(this.area);
                    this.facility.setDes(this.des);
                    this.facility.setId_office(this.id_office);
                    this.facility.setPrice(this.price);
                    this.facility.setTitle(this.title);
                    this.facility.setType(this.type);
                    this.retrofiting.editeFacility(this.facility);
                } else {
                    Toast.makeText((Context)this, "upload new", Toast.LENGTH_LONG).show();
                    this.retrofiting.storeFacility(new Facility(this.id_office, this.etxTitle.getText().toString(), this.etxType.getText().toString(), this.etxDes.getText().toString(), Double.parseDouble(this.etxPrice.getText().toString()), Double.parseDouble(this.etxArea.getText().toString()), this.etxAddress.getText().toString()));
                }
        } else {
            askOption(this.facility.getTitle()).show();
        }
    }

    protected void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        setContentView(R.layout.activity_facility_info);
        this.etxTitle = (EditText)findViewById(R.id.etxTitleFInfo);
        this.etxType = (EditText)findViewById(R.id.etxTypeFInfo);
        this.etxArea = (EditText)findViewById(R.id.etxAreaFInfo);
        this.etxPrice = (EditText)findViewById(R.id.etxPriceFInfo);
        this.etxAddress = (EditText)findViewById(R.id.etxAddressFInfo);
        this.etxDes = (EditText)findViewById(R.id.etxDesFInfo);
        this.txtId = (TextView)findViewById(R.id.txtId);
        this.save = (AppCompatButton)findViewById(R.id.btnSaveFInfo);
        this.delete = (AppCompatButton)findViewById(R.id.btnDeleteFInfo);
        this.save.setOnClickListener((View.OnClickListener)this);
        this.delete.setOnClickListener((View.OnClickListener)this::onClick);
        getParamter();
        this.retrofiting = new Retrofiting(this);
    }

    public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}

    public void setData(Object paramObject) {
        if (paramObject != null)
            finish();
    }
}
