package com.example.singinuo.loginoffice.admin;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.singinuo.R;
import com.example.singinuo.db.Retrofiting;
import com.example.singinuo.model.MyActivity;
import com.example.singinuo.model.Office;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;

public class OfficesActivity_Admin extends MyActivity {
    private FloatingActionButton addOffice;

    private ListView listView;

    private ArrayList<Office> offices;

    private Retrofiting retrofiting;

    private ArrayList<String> strings;

    private SwipeRefreshLayout swipeRefreshLayout;

    protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
        super.onActivityResult(paramInt1, paramInt2, paramIntent);
        this.retrofiting.getAllOffice();
    }

    public void onClick(View paramView) {
        if (paramView.getId() == R.id.fbtnOfficeAdmiin)
            startActivityForResult(new Intent((Context)this, OfficeInfo.class), 1);
    }

    protected void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        setContentView(R.layout.activity_offices__admin);
        this.addOffice = (FloatingActionButton)findViewById(R.id.fbtnOfficeAdmiin);
        this.listView = (ListView)findViewById(R.id.listOfficeAdmin);
        this.addOffice.setOnClickListener(this::onClick);
        Retrofiting retrofiting = new Retrofiting(this);
        this.retrofiting = retrofiting;
        retrofiting.getAllOffice();
        SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout)findViewById(R.id.refresh);
        this.swipeRefreshLayout = swipeRefreshLayout;
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            public void onRefresh() {
                OfficesActivity_Admin.this.retrofiting.getAllOffice();
                OfficesActivity_Admin.this.swipeRefreshLayout.setRefreshing(false);
            }
        });
    }

    public void setData(Object paramObject) {
        if (paramObject instanceof ArrayList) {
            this.strings = new ArrayList<>();
            this.offices = (ArrayList<Office>)paramObject;
            for (byte b = 0; b < this.offices.size(); b++)
                this.strings.add(((Office)this.offices.get(b)).getName());
            this.listView.setAdapter((ListAdapter)new ArrayAdapter((Context)this, android.R.layout.simple_list_item_1, this.strings));
            this.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                public void onItemClick(AdapterView<?> param1AdapterView, View param1View, int param1Int, long param1Long) {
                    Intent intent = new Intent((Context)OfficesActivity_Admin.this, OfficeInfo.class);
                    intent.putExtra("IDOFFICE", ((Office)OfficesActivity_Admin.this.offices.get(param1Int)).getId());
                    intent.putExtra("NAMEOFFICE", ((Office)OfficesActivity_Admin.this.offices.get(param1Int)).getName());
                    intent.putExtra("PHONEOFFICE", ((Office)OfficesActivity_Admin.this.offices.get(param1Int)).getPhone());
                    intent.putExtra("ADDRESSOFFICE", ((Office)OfficesActivity_Admin.this.offices.get(param1Int)).getAddress());
                    intent.putExtra("PASSWORDOFFICE", ((Office)OfficesActivity_Admin.this.offices.get(param1Int)).getPassword());
                    intent.putExtra("ACTIVEOFFICE", ((Office)OfficesActivity_Admin.this.offices.get(param1Int)).getActive());
                    OfficesActivity_Admin.this.startActivityForResult(intent, 1);
                }
            });
        }
    }
}
