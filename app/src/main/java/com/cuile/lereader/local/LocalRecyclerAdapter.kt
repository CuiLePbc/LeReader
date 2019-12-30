package com.cuile.lereader.local

import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.cuile.lereader.R
import com.cuile.lereader.bean.BookInfo

class LocalRecyclerAdapter(private val itemClickListener: (BookInfo) -> Unit) : RecyclerView.Adapter<LocalRecyclerAdapter.MyViewHolder>() {

    private val bookInfos: MutableList<BookInfo> = mutableListOf()

    fun setData(books: MutableList<BookInfo>) {
        bookInfos.clear()
        bookInfos.addAll(books)
        notifyDataSetChanged()
    }

    fun addData(books: MutableList<BookInfo>) {
        bookInfos.addAll(books)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_local_recyclerview, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int = bookInfos.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        bookInfos.let {
            holder.bindView(it[position], itemClickListener)
        }
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val titleTV: TextView = itemView.findViewById(R.id.bookTitleLocal)
        private val coverIV: ImageView = itemView.findViewById(R.id.bookCoverLocal)

        fun bindView(bookInfo: BookInfo, clickListener: (BookInfo) -> Unit) {
            with(bookInfo) {
                titleTV.text = title
                if (coverImgUrl.isNotEmpty())
                    coverIV.setImageURI(Uri.parse(coverImgUrl))
                else
                    coverIV.setImageResource(R.drawable.ic_launcher_background)

                itemView.setOnClickListener {
                    clickListener(bookInfo)
                }
            }
        }

    }
}