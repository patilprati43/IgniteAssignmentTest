package com.example.ignite.model

import com.google.gson.annotations.SerializedName

data class Author(@SerializedName("name") var name:String,
                  @SerializedName("birth_year") var birthyear:Int,
                  @SerializedName("death_year") var deathyear:Int)