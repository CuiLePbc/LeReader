package com.cuile.lereader.store

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.cuile.lereader.R
import kotlinx.android.synthetic.main.fragment_store.*

/**
 * 在线书城列表页面
 */
class StoreFragment : Fragment() {
    private val storeViewModel: StoreViewModel by viewModels()

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_store, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        storeRecyclerView.layoutManager = LinearLayoutManager(activity)
        storeRecyclerView.adapter = StoreRecyclerAdapter{
            val action = StoreFragmentDirections.actionStoreFragmentToDetailFragment(it.title)
            findNavController().navigate(action)
        }

        storeViewModel.bookInfoList.observe(this, Observer {
            Log.w("StoreFragmentInit", "getDatas:${it.size}")
            (storeRecyclerView.adapter as StoreRecyclerAdapter).setData(it)
        })
    }
}
