package com.example.ignite.view

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
import com.example.ignite.R
import com.example.ignite.adapter.BookAdapter
import com.example.ignite.adapter.EndlessScrollListener
import com.example.ignite.model.Book
import com.example.ignite.model.ResultListOfBook
import com.example.ignite.presenter.Presenter
import com.example.ignite.utils.CheckConnection
import kotlinx.android.synthetic.main.activity_display.*
import kotlinx.android.synthetic.main.toolbar.*


class DisplayActivity : AppCompatActivity() , Mainview {
    private var adapter: BookAdapter? = null
    private var cc: CheckConnection? = null
    private val books: ArrayList<Book> = ArrayList()
    private var resultListOfBookAll:ResultListOfBook?=null
    private var genre: String = "fiction"
    private var scrollListener: EndlessScrollListener? = null

    var presenter:Presenter?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display)
        presenter= Presenter(this,applicationContext)
        val b = intent.extras

        cc= CheckConnection(this)
        if (b != null) {
            genre= b.getString("genre").toString()
            txttitle.text=genre
            genre?.let {
                presenter!!.callAPIForBooks( it) }

        }
        imgbackpress.setOnClickListener{
            onBackPressed()
        }
        adapter = BookAdapter(books,this@DisplayActivity)
        val manager: RecyclerView.LayoutManager = GridLayoutManager(this, 3)
        recyclerView.setLayoutManager(manager)
        recyclerView.setAdapter(adapter)
      mSwipeRefreshLayout.setOnRefreshListener(
            OnRefreshListener {
                if (cc!!.isConnectingToInternet()) {
                    if(resultListOfBookAll!=null) {
                        presenter!!.callAPIForNext(resultListOfBookAll?.next)

                    }
                } else {
                    mSwipeRefreshLayout.setRefreshing(
                        false
                    )
                    Toast.makeText(
                    applicationContext,
                    R.string.error,
                    Toast.LENGTH_LONG
                ).show() //display the response on screen
                }
            })
        //text xhnge listener to serach when user gives inout to search edittext
        searchBoxTextview.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(search: CharSequence?, p1: Int, p2: Int, p3: Int) {
                Log.e("onTextChanged:","come")
                if (cc!!.isConnectingToInternet()) {
                    if(resultListOfBookAll!=null) {
                        presenter!!.callAPIForSearchForbooksandauthor( search.toString(),genre)
                    }
                } else {
                    mSwipeRefreshLayout.setRefreshing(
                        false
                    )
                    Toast.makeText(
                        applicationContext,
                        R.string.error,
                        Toast.LENGTH_LONG
                    ).show() //display the response on screen
                }
            }
        })
        //to find last item in recyclerlust
//        recyclerView.onScrollStateChanged(scrollListener)
        }

    override fun getBooksNextBookSearch(resultListOfBook: ResultListOfBook?) {
        resultListOfBookAll=resultListOfBook
        mSwipeRefreshLayout.isRefreshing = false
        if (resultListOfBook != null) {
            if(resultListOfBookAll!!.count==0)
            {
                Toast.makeText(
                    applicationContext,
                    "No result found",
                    Toast.LENGTH_LONG)
            }
            books.clear()
            books.addAll(resultListOfBook.results)
        }
     adapter!!.notifyDataSetChanged()
        recyclerView.setOnScrollListener(object : EndlessScrollListener() {
            override fun onLoadMore(
                page: Int,
                totalItemsCount: Int
            ): Boolean { // Triggered only when new data needs to be appended to the list
            // Add whatever code is needed to append new items to your AdapterView
                if (cc!!.isConnectingToInternet()) {
                    if(resultListOfBookAll!=null) {
                        presenter!!.callAPIForNext(resultListOfBookAll?.next)
                    }
                } else {
                    mSwipeRefreshLayout.setRefreshing(
                        false
                    )
                    Toast.makeText(
                        applicationContext,
                        R.string.error,
                        Toast.LENGTH_LONG
                    ).show() //display the response on screen
                }
                // or loadNextDataFromApi(totalItemsCount);
                return true // ONLY if more data is actually being loaded; false otherwise.
            }
        })
    }

    override fun getBooks(resultListOfBook: ResultListOfBook?) {
        Log.e("resultListOfBook",resultListOfBook.toString())
        resultListOfBookAll=resultListOfBook
        mSwipeRefreshLayout.isRefreshing = false
        if (resultListOfBook != null) {
            if(resultListOfBookAll!!.count==0)
            {
                Toast.makeText(
                    applicationContext,
                    "No result found",
                    Toast.LENGTH_LONG)
            }
            books.addAll(resultListOfBook.results)
        }
        adapter!!.notifyDataSetChanged()
        recyclerView.setOnScrollListener(object : EndlessScrollListener() {
            override fun onLoadMore(
                page: Int,
                totalItemsCount: Int
            ): Boolean { // Triggered only when new data needs to be appended to the list
            // Add whatever code is needed to append new items to your AdapterView
                if (cc!!.isConnectingToInternet()) {
                    if(resultListOfBookAll!=null) {
                        presenter!!.callAPIForNext(resultListOfBookAll?.next)
                    }
                } else {
                    mSwipeRefreshLayout.setRefreshing(false)
                    Toast.makeText(
                        applicationContext,
                        R.string.error,
                        Toast.LENGTH_LONG
                    ).show() //display the response on screen
                }
                // or loadNextDataFromApi(totalItemsCount);
                return true // ONLY if more data is actually being loaded; false otherwise.
            }
        })
    }

    override fun getBooksNextBook(resultListOfBook: ResultListOfBook?) {
        if (resultListOfBook != null) {
            books.addAll(resultListOfBook.results)
        }
        adapter!!.notifyDataSetChanged()
    }

}
