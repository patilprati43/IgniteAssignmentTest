package com.example.ignite.presenter

import android.content.Context
import android.util.Log
import android.view.View
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.VolleyLog.TAG
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.ignite.model.ResultListOfBook
import com.example.ignite.view.Mainview
import com.google.gson.Gson


//Presenter to handle communication between model and view
class Presenter(view: Mainview ,context:Context) {
    private var mStringRequest: StringRequest? = null
    private val url = "http://gutendex.com/books/"

    private var mainview: Mainview? = null
    private var context: Context? = null

   init{
        this.mainview = view
       this.context=context
    }

    fun callAPIForBooks(arg:String) { //RequestQueue initialized
        var mRequestQueue: RequestQueue? = null

        var newurl=url+"?topic="+arg;
        Log.e("newurl",newurl);
        mRequestQueue = Volley.newRequestQueue(context)
        //String Request initialized
        mStringRequest = StringRequest(
            Request.Method.GET,
            newurl,
            Response.Listener { response ->
                var responseBook: ResultListOfBook
                responseBook= Gson().fromJson(response,ResultListOfBook::class.java)
//
                mainview!!.getBooks(responseBook)
            },
            Response.ErrorListener { error -> Log.i(TAG, "Error :$error") })
        mRequestQueue.add(mStringRequest?:return)
    }

    fun callAPIForNext(url: String?) {
        var mRequestQueue: RequestQueue? = null

        var newurl=url
        Log.e("newurl",newurl);
        mRequestQueue = Volley.newRequestQueue(context)
        //String Request initialized
        mStringRequest = StringRequest(
            Request.Method.GET,
            newurl,
            Response.Listener { response ->
                var responseBook: ResultListOfBook
                responseBook= Gson().fromJson(response,ResultListOfBook::class.java)
//
                mainview!!.getBooks(responseBook)
            },
            Response.ErrorListener { error -> Log.i(TAG, "Error :$error") })
        mRequestQueue.add(mStringRequest?:return)
    }
    fun callAPIForSearchForbooksandauthor(searchstr: String?, genre: String) {
        var mRequestQueue: RequestQueue? = null

        var newurl=url+"?topic="+genre+"&search="+searchstr;
        Log.e("newurl",newurl);
        mRequestQueue = Volley.newRequestQueue(context)

        //String Request initialized
        mStringRequest = StringRequest(
            Request.Method.GET,
            newurl,
            Response.Listener { response ->
                var responseBook: ResultListOfBook
                responseBook= Gson().fromJson(response,ResultListOfBook::class.java)
//
                mainview!!.getBooks(responseBook)
            },
            Response.ErrorListener { error -> Log.i(TAG, "Error :$error") })
        mRequestQueue.add(mStringRequest?:return)
    }
}

