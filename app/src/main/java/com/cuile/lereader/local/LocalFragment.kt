package com.cuile.lereader.local

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.cuile.lereader.R
import kotlinx.android.synthetic.main.fragment_local.*

/**
 * 已收藏的书籍列表
 */
class LocalFragment : Fragment() {

    private val localViewModel: LocalViewModel by viewModels()

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_local, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        localRecyclerView.layoutManager = GridLayoutManager(activity, 3)
        localRecyclerView.adapter = LocalRecyclerAdapter {
            val action = LocalFragmentDirections.actionLocalFragmentToDetailFragment(it.title)
            findNavController().navigate(action)
        }

        localViewModel.bookInfoList.observe(this, Observer {
            (localRecyclerView.adapter as LocalRecyclerAdapter).setData(it)
        })
    }
}
