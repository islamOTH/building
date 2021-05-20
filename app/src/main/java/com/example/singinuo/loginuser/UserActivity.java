package com.example.singinuo.loginuser;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.widget.AppCompatButton;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.singinuo.R;
import com.example.singinuo.db.MSP;
import com.example.singinuo.db.Retrofiting;
import com.example.singinuo.loginoffice.facility.OfficeActivity;
import com.example.singinuo.model.Facility;
import com.example.singinuo.model.MyActivity;
import com.example.singinuo.model.Office;
import com.example.singinuo.model.User;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UserActivity extends MyActivity implements AdapterView.OnItemClickListener {
    private AppCompatButton btnlogoutUser;

    private ArrayList<Facility> facilities;

    private ListView listView;

    private MSP officePref;

    private Retrofiting retrofiting;

    private EditText searchEditText;

    private ArrayList<String> strings;

    private SwipeRefreshLayout swipeRefreshLayout;

    private MSP userPref;

    public void onClick(View paramView) {
        if (paramView.getId() == R.id.btnlogoutUser) {
            this.userPref.deleteUser();
            startActivity(new Intent((Context)this, LoginUser.class));
            finish();
        }
    }

    protected void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        this.userPref = new MSP("USERPREF", (Context)this);
        this.officePref = new MSP("OFFICEPREF", (Context)this);
        User user = this.userPref.getUserPref();
        Office office = this.officePref.getOfficePref();
        if (user != null) {
            setContentView(R.layout.activity_user);
            this.searchEditText = (EditText)findViewById(R.id.searchEditText);
            AppCompatButton appCompatButton = (AppCompatButton)findViewById(R.id.btnlogoutUser);
            this.btnlogoutUser = appCompatButton;
            appCompatButton.setOnClickListener(this::onClick);
            this.listView = (ListView)findViewById(R.id.listUser);
            this.strings = new ArrayList<>();
            SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout)findViewById(R.id.refresh);
            this.swipeRefreshLayout = swipeRefreshLayout;
            swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
                public void onRefresh() {
                    UserActivity.this.retrofiting.getAllFacility();
                    UserActivity.this.searchEditText.setText("");
                    UserActivity.this.swipeRefreshLayout.setRefreshing(false);
                }
            });
            retrofiting = new Retrofiting(this);

            retrofiting.getAllFacility();
        } else if (office != null) {
            startActivity(new Intent((Context)this, OfficeActivity.class));
            finish();
        } else {
            startActivity(new Intent((Context)this, LoginUser.class));
            finish();
        }
    }

    public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong) {
        Intent intent = new Intent((Context)this, ConnectOfficeActivity.class);
        intent.putExtra("KEYIDOFFICE", ((Facility)this.facilities.get(paramInt)).getId_office());
        startActivity(intent);
    }

    public void setData(Object paramObject) {
        if (paramObject instanceof ArrayList) {
            this.strings = new ArrayList<>();
            paramObject = paramObject;
            this.facilities = (ArrayList<Facility>)paramObject;
            Collections.reverse((List<?>)paramObject);
            for (byte b = 0; b < this.facilities.size(); b++)
                this.strings.add("         " + ((Facility)this.facilities.get(b)).getTitle() + "\n " + ((Facility)this.facilities.get(b)).getType() + "\n " + ((Facility)this.facilities.get(b)).getAddress() + "\n " + ((Facility)this.facilities.get(b)).getDes() + "\n " + ((Facility)this.facilities.get(b)).getArea());
            this.searchEditText.addTextChangedListener(new TextWatcher() {
                public void afterTextChanged(Editable param1Editable) {
                    strings= new ArrayList();
                    if (!UserActivity.this.searchEditText.getText().toString().equals("")) {
                        for (byte b = 0; b < UserActivity.this.facilities.size(); b++) {
                            int i = ((Facility)UserActivity.this.facilities.get(b)).getAddress().indexOf(UserActivity.this.searchEditText.getText().toString());
                            if (i >= 0) {
                                UserActivity.this.strings.add("         " + ((Facility)UserActivity.this.facilities.get(b)).getTitle() + "\n " + ((Facility)UserActivity.this.facilities.get(b)).getType() + "\n " + ((Facility)UserActivity.this.facilities.get(b)).getAddress() + "\n " + ((Facility)UserActivity.this.facilities.get(b)).getDes() + "\n " + ((Facility)UserActivity.this.facilities.get(b)).getArea());
                                Toast.makeText((Context)UserActivity.this, "search " + UserActivity.this.searchEditText.getText().toString() + " " + i + " ", Toast.LENGTH_LONG).show();
                            }
                        }
                    } else {
                        for (byte b = 0; b < UserActivity.this.facilities.size(); b++)
                            UserActivity.this.strings.add("         " + ((Facility)UserActivity.this.facilities.get(b)).getTitle() + "\n " + ((Facility)UserActivity.this.facilities.get(b)).getType() + "\n " + ((Facility)UserActivity.this.facilities.get(b)).getAddress() + "\n " + ((Facility)UserActivity.this.facilities.get(b)).getDes() + "\n " + ((Facility)UserActivity.this.facilities.get(b)).getArea());
                    }
                    ListView listView = UserActivity.this.listView;
                    UserActivity userActivity = UserActivity.this;
                    listView.setAdapter((ListAdapter)new ArrayAdapter((Context)userActivity, android.R.layout.simple_list_item_1, userActivity.strings));
                }

                public void beforeTextChanged(CharSequence param1CharSequence, int param1Int1, int param1Int2, int param1Int3) {}

                public void onTextChanged(CharSequence param1CharSequence, int param1Int1, int param1Int2, int param1Int3) {}
            });
            this.listView.setAdapter((ListAdapter)new ArrayAdapter((Context)this, android.R.layout.simple_list_item_1, this.strings));
            this.listView.setOnItemClickListener(this);
        }
    }
}
