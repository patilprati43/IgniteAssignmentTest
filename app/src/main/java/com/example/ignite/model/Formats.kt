package com.example.ignite.model

import com.google.gson.annotations.SerializedName

data class Formats(@SerializedName("text/html")var texthtml:String,
                   @SerializedName("application/zip")var applicationzip:String,
                   @SerializedName("image/jpeg")var imagejpeg:String,
                   @SerializedName("aapplication/epub+zip")var applicationepubzip:String,
                   @SerializedName("text/plain")var textplain:String,
                   @SerializedName("text/plain; charset=us-ascii")var textplaincharsetusascii:String,
                   @SerializedName("application/x-mobipocket-ebook")var applicationxmobipocketebook:String,
                   @SerializedName("application/rdf+xml")var applicationrdfxml:String
                )
