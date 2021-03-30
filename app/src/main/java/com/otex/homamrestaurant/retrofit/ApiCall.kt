package com.otex.homamrestaurant.retrofit

import com.otex.homamrestaurant.view.home.model.ModelHomeDashBord
import com.otex.homamrestaurant.view.login.model.ModelLogin
import retrofit2.Call
import retrofit2.http.*
import java.util.HashMap


interface ApiCall {

    @GET("services/rest/?")
    fun getPhotos(@QueryMap requestBody: HashMap<String, String?>?): Call<String?>?

    @FormUrlEncoded
    @POST("restaurant/login")
    fun login(@FieldMap map: HashMap<String, String?>?): Call<ModelLogin?>?

    @GET("restaurant/dashboard")
    fun homeDashBord():Call<ModelHomeDashBord?>?



}