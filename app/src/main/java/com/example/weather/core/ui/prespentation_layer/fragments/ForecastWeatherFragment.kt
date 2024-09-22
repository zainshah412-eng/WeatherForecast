package com.example.weather.core.ui.prespentation_layer.fragments

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.weather.AppApplication
import com.example.weather.core.ui.data_layer.model.Forecastday
import com.example.weather.core.ui.prespentation_layer.adapter.ForecastAdapter
import com.example.weather.databinding.FragmentForecastBinding

import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ForecastWeatherFragment : Fragment(), View.OnClickListener {

    private lateinit var binding: FragmentForecastBinding
    private lateinit var adapter: ForecastAdapter
    private lateinit var forecastList: ArrayList<Forecastday>

    var fragmentStatus = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentForecastBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        forecastList = ArrayList<Forecastday>()
        forecastList =
            (AppApplication.sessionManager.weatherDetail?.forecastDTO?.forecastday as ArrayList<Forecastday>?)!!
        setUpRecyclerViewForecast(forecastList)
    }


    private fun setUpRecyclerViewForecast(list: ArrayList<Forecastday>) {
        binding.weatherList.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        adapter = ForecastAdapter(requireContext(), list)
        binding.weatherList.adapter = adapter
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (resultCode) {

        }
    }


    override fun onClick(p0: View?) {
        when (p0) {

        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        fragmentStatus = "onAttach"
    }


}

