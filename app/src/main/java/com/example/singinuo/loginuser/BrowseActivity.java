package com.example.singinuo.loginuser;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.example.singinuo.MainActivity;
import com.example.singinuo.R;
import com.example.singinuo.db.Retrofiting;
import com.example.singinuo.model.Facility;
import com.example.singinuo.model.MyActivity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BrowseActivity extends MyActivity implements AdapterView.OnItemClickListener {
    private ListView listView;

    private Retrofiting retrofiting;

    private ArrayList<String> strings;

    private SwipeRefreshLayout swipeRefreshLayout;

    public void onBackPressed() {
        startActivity(new Intent((Context)this, MainActivity.class));
        finish();
    }

    public void onClick(View paramView) {}

    protected void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        setContentView(R.layout.activity_browse);
        this.listView = (ListView)findViewById(R.id.listUser);
        this.strings = new ArrayList<>();
        SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout)findViewById(R.id.refresh);
        this.swipeRefreshLayout = swipeRefreshLayout;
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            public void onRefresh() {
                BrowseActivity.this.retrofiting.getAllFacility();
                BrowseActivity.this.swipeRefreshLayout.setRefreshing(false);
            }
        });
        Retrofiting retrofiting = new Retrofiting(this);
        this.retrofiting = retrofiting;
        retrofiting.getAllFacility();
    }

    public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong) {
        startActivity(new Intent((Context)this, LoginUser.class));
        finish();
    }

    public void setData(Object obj) {
        if (obj instanceof ArrayList) {
            this.strings = new ArrayList<>();
           ArrayList<Facility> paramObject =( ArrayList<Facility> ) obj;
            Collections.reverse((List<?>)paramObject);
            for (byte b = 0; b < paramObject.size(); b++)
                this.strings.add("Office: " + ((Facility)paramObject.get(b)).getId_office() + "\n Title: " + ((Facility)paramObject.get(b)).getTitle() + "\n Type: " + ((Facility)paramObject.get(b)).getType() + "\n Address: " + ((Facility)paramObject.get(b)).getAddress() + "\n Des: " + ((Facility)paramObject.get(b)).getDes() + "\n Area= " + ((Facility)paramObject.get(b)).getArea());
            this.listView.setAdapter((ListAdapter)new ArrayAdapter((Context)this, android.R.layout.simple_list_item_1, this.strings));
            this.listView.setOnItemClickListener(this);
        }
    }
}
