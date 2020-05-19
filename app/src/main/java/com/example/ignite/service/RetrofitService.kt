//package com.example.coditastest.service
//
//import android.util.Log
//import okhttp3.OkHttpClient
//import okhttp3.logging.HttpLoggingInterceptor
//import retrofit2.Retrofit
//import retrofit2.converter.gson.GsonConverterFactory
//
//
//class RetrofitService {
//    //retrofit object
//    private var retrofit: Retrofit? = null
//    /**
//     * This method creates a new instance of the API interface.
//     *
//     * @return The API interface
//     */
//    fun getAPI(): APIInteface? {
//        val baseURL = "http://skunkworks.ignitesol.com:8000/"
//        if (retrofit == null) {
//            Log.e("baseurl",baseURL)
//            retrofit = Retrofit.Builder()
//                .baseUrl(baseURL)
//                .addConverterFactory(GsonConverterFactory.create())
//                .build()
//        }
//        return retrofit!!.create<APIInteface>(APIInteface::class.java)
//    }
//
//}