package com.example.ignite.utils

import android.content.Context
import android.net.ConnectivityManager

var c: Context? = null
//class to check intenet connection
class CheckConnection(con: Context?) {
    init {
        c = con
    }
    fun isConnectingToInternet(): Boolean {
        val isConnected: Boolean
        val cm =
            c!!.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork = cm.activeNetworkInfo
        isConnected = (activeNetwork != null
                && activeNetwork.isConnectedOrConnecting)
        return isConnected
    }
}

