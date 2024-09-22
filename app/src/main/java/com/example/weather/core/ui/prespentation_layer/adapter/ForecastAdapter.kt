package com.example.weather.core.ui.prespentation_layer.adapter

import android.content.Context
import android.os.Build
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.example.weather.core.ui.data_layer.model.Forecastday
import com.example.weather.databinding.ForecastItemBinding
import loadImage

class ForecastAdapter(
    private val context: Context,
    private var dataList: ArrayList<Forecastday>,
) :
    RecyclerView.Adapter<ForecastAdapter.BindViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BindViewHolder {
        val rootView =
            ForecastItemBinding.inflate(LayoutInflater.from(context), parent, false)

        return BindViewHolder(rootView)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onBindViewHolder(viewHolder: BindViewHolder, position: Int) {
        val item = dataList[position]

        viewHolder.itemBinding.weatherIcon.loadImage(item.day?.condition?.icon.toString())
        viewHolder.itemBinding.temperature.text = item.day?.avgtempF.toString() + " °F"
        viewHolder.itemBinding.weatherDescription.text = item.day?.condition?.text.toString()
        viewHolder.itemBinding.high.text = item.day?.maxtempF.toString() + " °F"
        viewHolder.itemBinding.low.text = item.day?.mintempF.toString() + " °F"
    }


    class BindViewHolder(val itemBinding: ForecastItemBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
    }

}