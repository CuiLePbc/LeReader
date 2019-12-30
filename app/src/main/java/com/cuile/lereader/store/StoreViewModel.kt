package com.cuile.lereader.store

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cuile.lereader.bean.BookInfo
import com.cuile.lereader.data.Repository
import kotlinx.coroutines.launch

class StoreViewModel : ViewModel() {
    private val repository: Repository = Repository()
    val bookInfoList: MutableLiveData<MutableList<BookInfo>> = MutableLiveData(mutableListOf())

    init {
        viewModelScope.launch {
            val storeBooks = repository.getStoreBooks()
            Log.w(StoreViewModel::javaClass.name, "AllBooks:${storeBooks.size}")
            bookInfoList.value = storeBooks
        }
    }

}