package com.cuile.lereader

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class OnlineRecyclerAdapter(val bookInfos: List<BookInfo>) : RecyclerView.Adapter<OnlineRecyclerAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_online_recyclerview, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int = bookInfos.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bindView(bookInfos[position])
    }


    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val rankTV: TextView = itemView.findViewById(R.id.rankIdOnline)
        private val titleTV: TextView = itemView.findViewById(R.id.bookTitleOnline)
        private val authorTV: TextView = itemView.findViewById(R.id.bookAuthorOnline)
        private val remarkTV: TextView = itemView.findViewById(R.id.bookRemarkOnline)
        private val coverIV: ImageView = itemView.findViewById(R.id.bookCoverOnline)

        fun bindView(bookInfo: BookInfo) {
            with(bookInfo) {
                rankTV.text = rank.toString()
                titleTV.text = title
                authorTV.text = author
                remarkTV.text = remarkScore.toString()
                if (coverImgUrl.isNotEmpty())
                    coverIV.setImageURI(Uri.parse(coverImgUrl))
                else
                    coverIV.setImageResource(R.drawable.ic_launcher_background)
            }
        }

    }
}