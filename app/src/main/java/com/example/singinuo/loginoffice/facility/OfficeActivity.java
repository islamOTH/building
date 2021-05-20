package com.example.singinuo.loginoffice.facility;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.singinuo.R;
import com.example.singinuo.db.MSP;
import com.example.singinuo.db.Retrofiting;
import com.example.singinuo.loginoffice.LoginOffice;
import com.example.singinuo.model.Facility;
import com.example.singinuo.model.MyActivity;
import com.example.singinuo.model.Office;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;

public class OfficeActivity extends MyActivity {
    private FloatingActionButton addFacility;

    private AppCompatButton btnlogoutoffice;

    private ListView listView;

    private Office mOffice;

    private MSP officePrefrence;

    private Retrofiting retrofiting;

    private ArrayList<String> strings;

    private SwipeRefreshLayout swipeRefreshLayout;

    public void onClick(View paramView) {
        int i = paramView.getId();
        if (i != addFacility.getId()) {
            if (i == btnlogoutoffice.getId()) {
                this.officePrefrence.deleteOffice();
                startActivity(new Intent((Context)this, LoginOffice.class));
                finish();
            }
        } else {
            Intent intent = new Intent((Context)this, FacilityInfo.class);
            intent.putExtra("KEYIDOFFICE", this.mOffice.getId());
            startActivity(intent);
        }
    }

    protected void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        setContentView(R.layout.activity_office);
        MSP mSP = new MSP("OFFICEPREF", (Context)this);
        this.officePrefrence = mSP;
        Office office = mSP.getOfficePref();
        this.mOffice = office;
        if (office != null) {
            this.addFacility = findViewById(R.id.addFacility);
            addFacility.setOnClickListener(this::onClick);
            btnlogoutoffice=findViewById(R.id.btnlogoutoffice);
            btnlogoutoffice.setOnClickListener(this::onClick);
            this.listView = (ListView)findViewById(R.id.listFOffice);
            Retrofiting retrofiting = new Retrofiting(this);
            this.retrofiting = retrofiting;
            retrofiting.getOneFacility(this.mOffice.getId());
            SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout)findViewById(R.id.refresh);
            this.swipeRefreshLayout = swipeRefreshLayout;
            swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
                public void onRefresh() {
                    OfficeActivity.this.retrofiting.getOneFacility(OfficeActivity.this.mOffice.getId());
                    OfficeActivity.this.swipeRefreshLayout.setRefreshing(false);
                }
            });
        } else {
            finish();
        }
    }

    public void setData( Object object) {
        if (object instanceof ArrayList) {
            this.strings = new ArrayList<>();
            ArrayList<Facility> facilities = (ArrayList<Facility>) object;
            for (byte b = 0; b < facilities.size(); b++)
                this.strings.add("title :" + ((Facility)facilities.get(b)).getTitle() + "\n Area: " + ((Facility)facilities.get(b)).getArea() + "\n Address: " + ((Facility)facilities.get(b)).getAddress() + "\n Des: " + ((Facility)facilities.get(b)).getDes());
            this.listView.setAdapter((ListAdapter)new ArrayAdapter((Context)this, android.R.layout.simple_list_item_1, this.strings));
            this.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                public void onItemClick(AdapterView<?> param1AdapterView, View param1View, int param1Int, long param1Long) {
                    Intent intent = new Intent((Context)OfficeActivity.this, FacilityInfo.class);
                    intent.putExtra("KEYIDOFFICE", OfficeActivity.this.mOffice.getId());
                    intent.putExtra("KEYID", ((Facility)facilities.get(param1Int)).getId());
                    intent.putExtra("KEYADDRESS", ((Facility)facilities.get(param1Int)).getAddress());
                    intent.putExtra("KEYAREA", ((Facility)facilities.get(param1Int)).getArea());
                    intent.putExtra("KEYPRICE", ((Facility)facilities.get(param1Int)).getPrice());
                    intent.putExtra("KEYTYPE", ((Facility)facilities.get(param1Int)).getType());
                    intent.putExtra("KEYTITLE", ((Facility)facilities.get(param1Int)).getTitle());
                    intent.putExtra("KEYDES", ((Facility)facilities.get(param1Int)).getDes());
                    OfficeActivity.this.startActivity(intent);
                }
            });
        }
    }
}
