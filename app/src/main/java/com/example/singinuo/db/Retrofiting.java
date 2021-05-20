package com.example.singinuo.db;

import android.app.ProgressDialog;
import android.content.Context;
import android.widget.Toast;
import com.example.singinuo.model.ActivityPresenter;
import com.example.singinuo.model.Facility;
import com.example.singinuo.model.JsonPlaceHolderApi;
import com.example.singinuo.model.MyActivity;
import com.example.singinuo.model.Office;
import com.example.singinuo.model.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Converter;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Retrofiting {
    public static final String BASE_URL = "http://192.168.1.107:8000/api/";

    private ActivityPresenter activityPresenter;

    private Context mContext;

    private JsonPlaceHolderApi mJsonPlaceHolderApi;

    private ProgressDialog mProgressDialog;

    private Retrofit mRetrofit;

    public Retrofiting(MyActivity paramMyActivity) {
        this.mContext = (Context)paramMyActivity;
        this.activityPresenter = (ActivityPresenter)paramMyActivity;
        Gson gson = (new GsonBuilder()).setLenient().create();
        Retrofit retrofit = (new Retrofit.Builder()).baseUrl(BASE_URL).addConverterFactory((Converter.Factory)GsonConverterFactory.create(gson)).build();
        this.mRetrofit = retrofit;
        this.mJsonPlaceHolderApi = (JsonPlaceHolderApi)retrofit.create(JsonPlaceHolderApi.class);
        ProgressDialog progressDialog = new ProgressDialog((Context)paramMyActivity);
        this.mProgressDialog = progressDialog;
        progressDialog.setMessage("Loading");
        this.mProgressDialog.setCancelable(false);
    }

    public void deleteOneFacility(int paramInt) {
        this.mProgressDialog.show();
        this.mJsonPlaceHolderApi.deleteFacility(paramInt).enqueue(new Callback<Facility>() {
            public void onFailure(Call<Facility> param1Call, Throwable param1Throwable) {
                if (Retrofiting.this.mProgressDialog.isShowing())
                    Retrofiting.this.mProgressDialog.dismiss();
                Retrofiting.this.messege("you can't connect" + param1Throwable.getMessage());
            }

            public void onResponse(Call<Facility> param1Call, Response<Facility> param1Response) {
                if (!param1Response.isSuccessful()) {
                    if (Retrofiting.this.mProgressDialog.isShowing())
                        Retrofiting.this.mProgressDialog.dismiss();
                    Retrofiting.this.messege("error in server " + param1Response.message());
                    return;
                }
                if (Retrofiting.this.mProgressDialog.isShowing())
                    Retrofiting.this.mProgressDialog.dismiss();
                Facility facility = (Facility)param1Response.body();
                Retrofiting.this.activityPresenter.setData(facility);
            }
        });
    }

    public void deleteOneOffice(int paramInt) {
        this.mProgressDialog.show();
        this.mJsonPlaceHolderApi.deleteOffice(paramInt).enqueue(new Callback<Office>() {
            public void onFailure(Call<Office> param1Call, Throwable param1Throwable) {
                if (Retrofiting.this.mProgressDialog.isShowing())
                    Retrofiting.this.mProgressDialog.dismiss();
                Retrofiting.this.messege("you can't connect" + param1Throwable.getMessage());
            }

            public void onResponse(Call<Office> param1Call, Response<Office> param1Response) {
                if (!param1Response.isSuccessful()) {
                    if (Retrofiting.this.mProgressDialog.isShowing())
                        Retrofiting.this.mProgressDialog.dismiss();
                    Retrofiting.this.messege("error in server " + param1Response.message());
                    return;
                }
                if (Retrofiting.this.mProgressDialog.isShowing())
                    Retrofiting.this.mProgressDialog.dismiss();
                Office office = (Office)param1Response.body();
                Retrofiting.this.activityPresenter.setData(office);
            }
        });
    }

    public void deleteOneUser(int paramInt) {
        this.mProgressDialog.show();
        this.mJsonPlaceHolderApi.deleteUser(paramInt).enqueue(new Callback<User>() {
            public void onFailure(Call<User> param1Call, Throwable param1Throwable) {
                if (Retrofiting.this.mProgressDialog.isShowing())
                    Retrofiting.this.mProgressDialog.dismiss();
                Retrofiting.this.messege("you can't connect" + param1Throwable.getMessage());
            }

            public void onResponse(Call<User> param1Call, Response<User> param1Response) {
                if (!param1Response.isSuccessful()) {
                    if (Retrofiting.this.mProgressDialog.isShowing())
                        Retrofiting.this.mProgressDialog.dismiss();
                    Retrofiting.this.messege("error in server " + param1Response.message());
                    return;
                }
                if (Retrofiting.this.mProgressDialog.isShowing())
                    Retrofiting.this.mProgressDialog.dismiss();
                Retrofiting.this.getAllUser();
            }
        });
    }

    public void editeFacility(Facility paramFacility) {
        this.mProgressDialog.show();
        this.mJsonPlaceHolderApi.mFacilityEdite(paramFacility).enqueue(new Callback<Facility>() {
            public void onFailure(Call<Facility> param1Call, Throwable param1Throwable) {
                if (Retrofiting.this.mProgressDialog.isShowing())
                    Retrofiting.this.mProgressDialog.dismiss();
                Retrofiting.this.messege("you can't connect" + param1Throwable.getMessage());
            }

            public void onResponse(Call<Facility> param1Call, Response<Facility> param1Response) {
                if (!param1Response.isSuccessful()) {
                    if (Retrofiting.this.mProgressDialog.isShowing())
                        Retrofiting.this.mProgressDialog.dismiss();
                    Retrofiting.this.messege("error in server " + param1Response.message());
                    return;
                }
                if (Retrofiting.this.mProgressDialog.isShowing())
                    Retrofiting.this.mProgressDialog.dismiss();
                Facility facility = (Facility)param1Response.body();
                Retrofiting.this.activityPresenter.setData(facility);
            }
        });
    }

    public void editeOffice(Office paramOffice) {
        this.mProgressDialog.show();
        this.mJsonPlaceHolderApi.mOfficeEdite(paramOffice).enqueue(new Callback<Office>() {
            public void onFailure(Call<Office> param1Call, Throwable param1Throwable) {
                if (Retrofiting.this.mProgressDialog.isShowing())
                    Retrofiting.this.mProgressDialog.dismiss();
                Retrofiting.this.messege("you can't connect" + param1Throwable.getMessage());
            }

            public void onResponse(Call<Office> param1Call, Response<Office> param1Response) {
                if (!param1Response.isSuccessful()) {
                    if (Retrofiting.this.mProgressDialog.isShowing())
                        Retrofiting.this.mProgressDialog.dismiss();
                    Retrofiting.this.messege("error in server " + param1Response.message());
                    return;
                }
                if (Retrofiting.this.mProgressDialog.isShowing())
                    Retrofiting.this.mProgressDialog.dismiss();
                Office office = (Office)param1Response.body();
                Retrofiting.this.activityPresenter.setData(office);
            }
        });
    }

    public void editeUser(User paramUser) {
        this.mProgressDialog.show();
        this.mJsonPlaceHolderApi.mUserEdite(paramUser).enqueue(new Callback<User>() {
            public void onFailure(Call<User> param1Call, Throwable param1Throwable) {
                if (Retrofiting.this.mProgressDialog.isShowing())
                    Retrofiting.this.mProgressDialog.dismiss();
                Retrofiting.this.messege("you can't connect" + param1Throwable.getMessage());
            }

            public void onResponse(Call<User> param1Call, Response<User> param1Response) {
                if (!param1Response.isSuccessful()) {
                    if (Retrofiting.this.mProgressDialog.isShowing())
                        Retrofiting.this.mProgressDialog.dismiss();
                    Retrofiting.this.messege("error in server " + param1Response.message());
                    return;
                }
                if (Retrofiting.this.mProgressDialog.isShowing())
                    Retrofiting.this.mProgressDialog.dismiss();
                User user = (User)param1Response.body();
                Retrofiting.this.activityPresenter.setData(user);
            }
        });
    }

    public void getAllFacility() {
        this.mProgressDialog.show();
        this.mJsonPlaceHolderApi.mGetFacility().enqueue(new Callback<List<Facility>>() {
            public void onFailure(Call<List<Facility>> param1Call, Throwable param1Throwable) {
                if (Retrofiting.this.mProgressDialog.isShowing())
                    Retrofiting.this.mProgressDialog.dismiss();
                Retrofiting.this.messege("you can't connect" + param1Throwable.getMessage());
            }

            public void onResponse(Call<List<Facility>> param1Call, Response<List<Facility>> param1Response) {
                if (!param1Response.isSuccessful()) {
                    if (Retrofiting.this.mProgressDialog.isShowing())
                        Retrofiting.this.mProgressDialog.dismiss();
                    Retrofiting.this.messege("error in server " + param1Response.message());
                    return;
                }
                if (Retrofiting.this.mProgressDialog.isShowing())
                    Retrofiting.this.mProgressDialog.dismiss();
                List list = (List)param1Response.body();
                Retrofiting.this.activityPresenter.setData(list);
            }
        });
    }

    public void getAllOffice() {
        this.mProgressDialog.show();
        this.mJsonPlaceHolderApi.mGetOffice().enqueue(new Callback<List<Office>>() {
            public void onFailure(Call<List<Office>> param1Call, Throwable param1Throwable) {
                if (Retrofiting.this.mProgressDialog.isShowing())
                    Retrofiting.this.mProgressDialog.dismiss();
                Retrofiting.this.messege("you can't connect" + param1Throwable.getMessage());
            }

            public void onResponse(Call<List<Office>> param1Call, Response<List<Office>> param1Response) {
                if (!param1Response.isSuccessful()) {
                    if (Retrofiting.this.mProgressDialog.isShowing())
                        Retrofiting.this.mProgressDialog.dismiss();
                    Retrofiting.this.messege("error in server " + param1Response.message());
                    return;
                }
                if (Retrofiting.this.mProgressDialog.isShowing())
                    Retrofiting.this.mProgressDialog.dismiss();
                List list = (List)param1Response.body();
                Retrofiting.this.activityPresenter.setData(list);
            }
        });
    }

    public void getAllUser() {
        this.mProgressDialog.show();
        this.mJsonPlaceHolderApi.mGetUsers().enqueue(new Callback<List<User>>() {
            public void onFailure(Call<List<User>> param1Call, Throwable param1Throwable) {
                if (Retrofiting.this.mProgressDialog.isShowing())
                    Retrofiting.this.mProgressDialog.dismiss();
                Retrofiting.this.messege("you can't connect" + param1Throwable.getMessage());
            }

            public void onResponse(Call<List<User>> param1Call, Response<List<User>> param1Response) {
                if (!param1Response.isSuccessful()) {
                    if (Retrofiting.this.mProgressDialog.isShowing())
                        Retrofiting.this.mProgressDialog.dismiss();
                    Retrofiting.this.messege("error in server " + param1Response.message());
                    return;
                }
                if (Retrofiting.this.mProgressDialog.isShowing())
                    Retrofiting.this.mProgressDialog.dismiss();
                ArrayList arrayList = (ArrayList)param1Response.body();
                Retrofiting.this.activityPresenter.setData(arrayList);
            }
        });
    }

    public void getOneFacility(int paramInt) {
        this.mProgressDialog.show();
        this.mJsonPlaceHolderApi.mGetFacility(paramInt).enqueue(new Callback<List<Facility>>() {
            public void onFailure(Call<List<Facility>> param1Call, Throwable param1Throwable) {
                if (Retrofiting.this.mProgressDialog.isShowing())
                    Retrofiting.this.mProgressDialog.dismiss();
                Retrofiting.this.messege("you can't connect" + param1Throwable.getMessage());
            }

            public void onResponse(Call<List<Facility>> param1Call, Response<List<Facility>> param1Response) {
                if (!param1Response.isSuccessful()) {
                    if (Retrofiting.this.mProgressDialog.isShowing())
                        Retrofiting.this.mProgressDialog.dismiss();
                    Retrofiting.this.messege("error in server " + param1Response.message());
                    return;
                }
                if (Retrofiting.this.mProgressDialog.isShowing())
                    Retrofiting.this.mProgressDialog.dismiss();
                List list = (List)param1Response.body();
                Retrofiting.this.messege("islam" + list.size());
                Retrofiting.this.activityPresenter.setData(list);
            }
        });
    }

    public void getOneOffice(int paramInt) {
        this.mProgressDialog.show();
        this.mJsonPlaceHolderApi.mGetOffice(paramInt).enqueue(new Callback<List<Office>>() {
            public void onFailure(Call<List<Office>> param1Call, Throwable param1Throwable) {
                if (Retrofiting.this.mProgressDialog.isShowing())
                    Retrofiting.this.mProgressDialog.dismiss();
                Retrofiting.this.messege("you can't connect" + param1Throwable.getMessage());
            }

            public void onResponse(Call<List<Office>> param1Call, Response<List<Office>> param1Response) {
                if (!param1Response.isSuccessful()) {
                    if (Retrofiting.this.mProgressDialog.isShowing())
                        Retrofiting.this.mProgressDialog.dismiss();
                    Retrofiting.this.messege("error in server " + param1Response.message());
                    return;
                }
                if (Retrofiting.this.mProgressDialog.isShowing())
                    Retrofiting.this.mProgressDialog.dismiss();
                ArrayList arrayList = (ArrayList)param1Response.body();
                if (arrayList.size() < 1 || arrayList == null) {
                    Retrofiting.this.messege("your password or email is wrong");
                    return;
                }
                Retrofiting.this.activityPresenter.setData(arrayList.get(0));
            }
        });
    }

    public void getOneUser(String paramString) {
        this.mProgressDialog.show();
        this.mJsonPlaceHolderApi.mGetUser(paramString).enqueue(new Callback<List<User>>() {
            public void onFailure(Call<List<User>> param1Call, Throwable param1Throwable) {
                if (Retrofiting.this.mProgressDialog.isShowing())
                    Retrofiting.this.mProgressDialog.dismiss();
                Retrofiting.this.messege("you can't connect" + param1Throwable.getMessage());
            }

            public void onResponse(Call<List<User>> param1Call, Response<List<User>> param1Response) {
                if (!param1Response.isSuccessful()) {
                    if (Retrofiting.this.mProgressDialog.isShowing())
                        Retrofiting.this.mProgressDialog.dismiss();
                    Retrofiting.this.messege("error in server " + param1Response.message());
                    return;
                }
                if (Retrofiting.this.mProgressDialog.isShowing())
                    Retrofiting.this.mProgressDialog.dismiss();
                List list = (List)param1Response.body();
                if (list.size() < 1 || list == null) {
                    Retrofiting.this.messege("your password or email is wrong");
                    return;
                }
                Retrofiting.this.activityPresenter.setData(list.get(0));
            }
        });
    }

    public void messege(String paramString) {
        Toast.makeText(this.mContext, paramString, 1).show();
    }

    public void storeFacility(Facility paramFacility) {
        this.mProgressDialog.show();
        this.mJsonPlaceHolderApi.mPostFacility(paramFacility).enqueue(new Callback<Facility>() {
            public void onFailure(Call<Facility> param1Call, Throwable param1Throwable) {
                if (Retrofiting.this.mProgressDialog.isShowing())
                    Retrofiting.this.mProgressDialog.dismiss();
                Retrofiting.this.messege("you can't connect" + param1Throwable.getMessage());
            }

            public void onResponse(Call<Facility> param1Call, Response<Facility> param1Response) {
                if (!param1Response.isSuccessful()) {
                    if (Retrofiting.this.mProgressDialog.isShowing())
                        Retrofiting.this.mProgressDialog.dismiss();
                    Retrofiting.this.messege("error in server " + param1Response.message());
                    return;
                }
                if (Retrofiting.this.mProgressDialog.isShowing())
                    Retrofiting.this.mProgressDialog.dismiss();
                Facility facility = (Facility)param1Response.body();
                Retrofiting.this.activityPresenter.setData(facility);
            }
        });
    }

    public void storeOffice(Office paramOffice) {
        this.mProgressDialog.show();
        this.mJsonPlaceHolderApi.mPostOffice(paramOffice).enqueue(new Callback<Office>() {
            public void onFailure(Call<Office> param1Call, Throwable param1Throwable) {
                if (Retrofiting.this.mProgressDialog.isShowing())
                    Retrofiting.this.mProgressDialog.dismiss();
                Retrofiting.this.messege("you can't connect" + param1Throwable.getMessage());
            }

            public void onResponse(Call<Office> param1Call, Response<Office> param1Response) {
                if (!param1Response.isSuccessful()) {
                    if (Retrofiting.this.mProgressDialog.isShowing())
                        Retrofiting.this.mProgressDialog.dismiss();
                    Retrofiting.this.messege("error in server " + param1Response.message());
                    return;
                }
                if (Retrofiting.this.mProgressDialog.isShowing())
                    Retrofiting.this.mProgressDialog.dismiss();
                Office office = (Office)param1Response.body();
                Retrofiting.this.activityPresenter.setData(office);
            }
        });
    }

    public void storeUser(User paramUser) {
        this.mProgressDialog.show();
        this.mJsonPlaceHolderApi.mPostUser(paramUser).enqueue(new Callback<String>() {
            public void onFailure(Call<String> param1Call, Throwable param1Throwable) {
                if (Retrofiting.this.mProgressDialog.isShowing())
                    Retrofiting.this.mProgressDialog.dismiss();
                Retrofiting.this.messege("you can't connect" + param1Throwable.getMessage());
            }

            public void onResponse(Call<String> param1Call, Response<String> param1Response) {
                if (!param1Response.isSuccessful()) {
                    if (Retrofiting.this.mProgressDialog.isShowing())
                        Retrofiting.this.mProgressDialog.dismiss();
                    Retrofiting.this.messege("error in server " + param1Response.message());
                    return;
                }
                if (Retrofiting.this.mProgressDialog.isShowing())
                    Retrofiting.this.mProgressDialog.dismiss();
                String str = (String)param1Response.body();
                Retrofiting.this.activityPresenter.setData(str);
            }
        });
    }
}
