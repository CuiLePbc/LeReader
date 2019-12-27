package com.cuile.lereader

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_online.*

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class OnlineFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_online, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bookOnlineRecyclerView.layoutManager = LinearLayoutManager(activity)
        bookOnlineRecyclerView.adapter = OnlineRecyclerAdapter(getWrongBooks())
    }
}
