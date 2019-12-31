package com.cuile.lereader.data

import android.util.Log
import com.cuile.lereader.bean.BookInfo
import kotlinx.coroutines.*

/**
 * 统一提供数据类
 */
class Repository {

    suspend fun getStoreBooks(): MutableList<BookInfo> = withContext(Dispatchers.IO) {
        val books = mutableListOf<BookInfo>()
        for (i in 0..20) {
            books.add(
                BookInfo(
                    "Book Name $i",
                    "TAG $i",
                    "Author is $i",
                    "This book has not introduction $i",
                    5.5f,
                    "",
                    "",
                    "",
                    System.currentTimeMillis(),
                    "来源： $i",
                    "online",
                    "utf-8",
                    i + 1
                )
            )
            Log.w("Repository.getStoreBooks", "Adding:${books.size}")
            delay(200)
        }
        books
    }

    suspend fun getCollectedBooks(): MutableList<BookInfo> = withContext(Dispatchers.IO) {
        val books = mutableListOf<BookInfo>()
        for (i in 0..99) {
            books.add(
                BookInfo(
                    "Book Name $i",
                    "TAG $i",
                    "Author is $i",
                    "This book has not introduction $i",
                    5.5f,
                    "",
                    "",
                    "",
                    System.currentTimeMillis(),
                    "来源： $i",
                    "online",
                    "utf-8",
                    i + 1
                )
            )
        }
        books
    }
}