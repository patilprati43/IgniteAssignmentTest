package com.example.ignite.model

import com.google.gson.annotations.SerializedName

data class ResultListOfBook (
    @SerializedName("count") var count:Int,
    @SerializedName("next") var next:String,
    @SerializedName("previous") var previous:String,
    @SerializedName("results") var results:ArrayList<Book>
)