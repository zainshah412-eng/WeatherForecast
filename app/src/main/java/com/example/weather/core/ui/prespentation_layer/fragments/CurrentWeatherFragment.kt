package com.example.weather.core.ui.prespentation_layer.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.weather.AppApplication
import com.example.weather.core.ui.data_layer.model.CurrentDTO
import com.example.weather.databinding.FragmentCurrentBinding
import dagger.hilt.android.AndroidEntryPoint
import loadImage


@AndroidEntryPoint
class CurrentWeatherFragment : Fragment(), View.OnClickListener {
    private lateinit var binding: FragmentCurrentBinding
    private lateinit var current: CurrentDTO

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentCurrentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        current = AppApplication.sessionManager.weatherDetail?.currentDTO!!
        current.condition?.icon?.let { binding.weatherIcon.loadImage(it) }
        binding.temperature.text = current.tempF.toString() + " °F"
        binding.weatherDescription.text = current.condition?.text
        binding.humidity.text = current.humidity.toString() + " °F"
        binding.windSpeed.text = current.windKph.toString() + " °F"
    }

    override fun onClick(p0: View?) {
        when (p0) {

        }
    }


}