package com.example.singinuo.model;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Query;

public interface JsonPlaceHolderApi {
    @DELETE("factily/deleteone")
    Call<Facility> deleteFacility(@Query("id") int paramInt);

    @DELETE("office/deleteone")
    Call<Office> deleteOffice(@Query("id") int paramInt);

    @DELETE("user/deleteone")
    Call<User> deleteUser(@Query("id") int paramInt);

    @PUT("factily/editeone")
    Call<Facility> mFacilityEdite(@Body Facility paramFacility);

    @GET("factily/getall")
    Call<List<Facility>> mGetFacility();

    @POST("factily/getone")
    Call<List<Facility>> mGetFacility(@Query("id") int paramInt);

    @GET("office/getall")
    Call<List<Office>> mGetOffice();

    @POST("office/getone")
    Call<List<Office>> mGetOffice(@Query("id") int paramInt);

    @POST("user/getone")
    Call<List<User>> mGetUser(@Query("email") String paramString);

    @GET("user/getall")
    Call<List<User>> mGetUsers();

    @POST("islam")
    Call<String> mIslam(@Query("id") int paramInt);

    @PUT("office/editeone")
    Call<Office> mOfficeEdite(@Body Office paramOffice);

    @POST("factily/storeone")
    Call<Facility> mPostFacility(@Body Facility paramFacility);

    @POST("office/storeone")
    Call<Office> mPostOffice(@Body Office paramOffice);

    @POST("user/storeone")
    Call<String> mPostUser(@Body User paramUser);

    @PUT("user/editeone")
    Call<User> mUserEdite(@Body User paramUser);
}
