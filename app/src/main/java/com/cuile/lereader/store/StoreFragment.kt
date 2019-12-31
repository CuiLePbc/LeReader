package com.cuile.lereader.store

import android.app.SearchManager
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.core.view.MenuItemCompat
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

        storeToolbar.setNavigationOnClickListener {
            findNavController().navigateUp()
        }

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

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_store_fragment, menu)
        val searchView = menu.findItem(R.id.search_book_edittext).actionView as SearchView

        searchView.setOnQueryTextListener(object: SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                Toast.makeText(context, query, Toast.LENGTH_SHORT).show()
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                Toast.makeText(context, newText, Toast.LENGTH_SHORT).show()
                return false
            }

        })
    }

    override fun onPrepareOptionsMenu(menu: Menu) {
        super.onPrepareOptionsMenu(menu)
    }
}
