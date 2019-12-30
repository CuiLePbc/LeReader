package com.cuile.lereader.store

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

class StoreRecyclerAdapter(private val itemClickListener: (BookInfo) -> Unit) : RecyclerView.Adapter<StoreRecyclerAdapter.MyViewHolder>() {

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
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_store_recyclerview, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int = bookInfos.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bindView(bookInfos[position], itemClickListener)
    }


    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val rankTV: TextView = itemView.findViewById(R.id.rankIdStore)
        private val titleTV: TextView = itemView.findViewById(R.id.bookTitleStore)
        private val authorTV: TextView = itemView.findViewById(R.id.bookAuthorStore)
        private val remarkTV: TextView = itemView.findViewById(R.id.bookRemarkStore)
        private val coverIV: ImageView = itemView.findViewById(R.id.bookCoverStore)

        fun bindView(bookInfo: BookInfo, onclickListener: (BookInfo) -> Unit) {
            with(bookInfo) {
                rankTV.text = rank.toString()
                titleTV.text = title
                authorTV.text = author
                remarkTV.text = remarkScore.toString()
                if (coverImgUrl.isNotEmpty())
                    coverIV.setImageURI(Uri.parse(coverImgUrl))
                else
                    coverIV.setImageResource(R.drawable.ic_launcher_background)

                itemView.setOnClickListener {
                    onclickListener(this)
                }
            }
        }

    }
}