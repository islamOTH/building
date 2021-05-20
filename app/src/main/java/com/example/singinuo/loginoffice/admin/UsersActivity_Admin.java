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
import com.example.singinuo.model.User;
import java.util.ArrayList;

public class UsersActivity_Admin extends MyActivity {
    private ListView listView;

    private Retrofiting retrofiting;

    private ArrayList<String> strings;

    private SwipeRefreshLayout swipeRefreshLayout;

    private ArrayList<User> users;

    protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
        super.onActivityResult(paramInt1, paramInt2, paramIntent);
        this.retrofiting.getAllUser();
    }

    public void onClick(View paramView) {}

    protected void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        setContentView(R.layout.activity_users__admin);
        this.listView = (ListView)findViewById(R.id.listUserAdmin);
        this.users = new ArrayList<>();
        Retrofiting retrofiting = new Retrofiting(this);
        this.retrofiting = retrofiting;
        retrofiting.getAllUser();
        SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout)findViewById(R.id.refresh);
        this.swipeRefreshLayout = swipeRefreshLayout;
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            public void onRefresh() {
                UsersActivity_Admin.this.retrofiting.getAllUser();
                UsersActivity_Admin.this.swipeRefreshLayout.setRefreshing(false);
            }
        });
    }

    public void setData(Object paramObject) {
        if (paramObject instanceof ArrayList && paramObject != null) {
            this.strings = new ArrayList<>();
            this.users = (ArrayList<User>)paramObject;
            for (byte b = 0; b < this.users.size(); b++)
                this.strings.add(((User)this.users.get(b)).getName());
            this.listView.setAdapter((ListAdapter)new ArrayAdapter((Context)this, android.R.layout.simple_list_item_1, this.strings));
            this.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                public void onItemClick(AdapterView<?> param1AdapterView, View param1View, int param1Int, long param1Long) {
                    Intent intent = new Intent((Context)UsersActivity_Admin.this, UserInfo.class);
                    intent.putExtra("IDUSER", ((User)UsersActivity_Admin.this.users.get(param1Int)).getId());
                    intent.putExtra("NAMEUSER", ((User)UsersActivity_Admin.this.users.get(param1Int)).getName());
                    intent.putExtra("EMAILUSER", ((User)UsersActivity_Admin.this.users.get(param1Int)).getEmail());
                    intent.putExtra("PASSWORDUSER", ((User)UsersActivity_Admin.this.users.get(param1Int)).getPassword());
                    UsersActivity_Admin.this.startActivityForResult(intent, 1);
                }
            });
        }
    }
}
