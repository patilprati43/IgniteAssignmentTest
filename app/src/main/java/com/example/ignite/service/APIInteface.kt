package com.example.coditastest.service

import com.example.ignite.model.ResultListOfBook
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface APIInteface {

    //abstract function to read data from api
    @GET(".")
    open fun getBookByCategory(@Query("topic") id: String): Call<ResultListOfBook?>?
    @GET(".")
    open fun getBookByCategorySearch(@Query("topic") topic: String,@Query("search") search: String): Call<ResultListOfBook?>?
}