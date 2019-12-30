package com.cuile.lereader.local

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cuile.lereader.bean.BookInfo
import com.cuile.lereader.data.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class LocalViewModel : ViewModel() {

    val bookInfoList: MutableLiveData<MutableList<BookInfo>> = MutableLiveData(mutableListOf())
    private val repository = Repository()

    init {
        viewModelScope.launch {
            val collectedBooks = repository.getCollectedBooks()
            bookInfoList.value = collectedBooks
        }
    }

}