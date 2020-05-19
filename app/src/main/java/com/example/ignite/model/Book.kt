package com.example.ignite.model

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName




data class Book(
    @SerializedName("id") var id:Int,
    @SerializedName("title") var title:String,
    @SerializedName("authors") var authors:ArrayList<Author>,
    @SerializedName("formats") var formats:Formats
   )
