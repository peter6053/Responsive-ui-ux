package com.sriyank.globotour.city

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.globaltour.R
import com.example.globaltour.VacationSpots
import com.example.globaltour.city.CityAdapter


class CityListFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_city_list, container, false)

        setupReclerview(view)

        return view
    }

    private  fun setupReclerview(view: View){
        val context = requireContext()
        val cityAdapter = CityAdapter(context,VacationSpots.cityList!!)
        val recyclerView = view?.findViewById<RecyclerView>(R.id.city_recycler_view)
        recyclerView?.adapter = cityAdapter
        recyclerView.setHasFixedSize(true)


        val layoutManager = LinearLayoutManager(context)
        layoutManager.orientation = recyclerView.verticalScrollbarPosition
        recyclerView?.layoutManager = layoutManager



    }


}