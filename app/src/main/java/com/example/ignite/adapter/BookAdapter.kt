package com.example.ignite.adapter

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.ignite.R
import com.example.ignite.model.Book


class BookAdapter(books: List<Book>,mcontext:Context) :
    RecyclerView.Adapter<BookAdapter.MyViewHolder>() {
    var books: List<Book> = books
    var context=mcontext
    override fun onCreateViewHolder(
        viewGroup: ViewGroup,
        i: Int
    ): MyViewHolder {
        val itemView: View = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.recycler_view_item, viewGroup, false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return books.size
    }

   class MyViewHolder(itemView: View) : ViewHolder(itemView) {
        var bookName: TextView
        var authorName: TextView
        var bookImg: ImageView
       var bookLayout:ConstraintLayout

        init {
            bookName = itemView.findViewById(R.id.imgbookname)
            authorName = itemView.findViewById(R.id.imgbookauthorname)
            bookImg = itemView.findViewById(R.id.imgbook)
            bookLayout=itemView.findViewById(R.id.bookLayout)

        }

    }

    override fun onBindViewHolder(holder: BookAdapter.MyViewHolder, position: Int) {

        holder.bookName.setText(books[position].title)
        holder.authorName.setText(books[position].authors.get(0).name)
        Glide.with(context)
            .load(books.get(position).formats.imagejpeg)
            .placeholder(R.drawable.ic_launcher_background)
            .error(R.drawable.ic_launcher_background)
            .skipMemoryCache(true)
            .into(holder.bookImg)

        Log.e("imageurl",books[position].formats.imagejpeg)
        if (books[position].formats.imagejpeg!=null) {
            holder.bookLayout.setOnClickListener {
                val browserIntent =
                    Intent(Intent.ACTION_VIEW, Uri.parse(books[position].formats.texthtml))
                context.startActivity(browserIntent)
            }
        }
    }
}