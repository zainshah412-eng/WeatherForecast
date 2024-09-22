package com.example.weather.core.ui.prespentation_layer

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.viewpager.widget.ViewPager
import com.example.weather.AppApplication
import com.example.weather.R
import com.example.weather.core.ui.prespentation_layer.adapter.FragmentAdapter
import com.example.weather.core.ui.prespentation_layer.fragments.CurrentWeatherFragment
import com.example.weather.core.ui.prespentation_layer.fragments.ForecastWeatherFragment
import com.example.weather.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import hideKeyboard
import kotlinx.coroutines.flow.collectLatest
import toast

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityMainBinding
    private val listingViewModel: WeatherViewModel by viewModels()
    private val mainTitles = ArrayList<String>()
    private lateinit var adapter: FragmentAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()
        setObservers()
        if (AppApplication.sessionManager.IsDataFound) {
            setupViewPager(binding.viewpager)
            binding.tabs.setupWithViewPager(binding.viewpager)
            binding.viewpager.offscreenPageLimit = 0
        } else {
            Log.wtf("RECORD", "NOT FOUND")
        }
    }


    fun initView() {
        binding.searchBar.setOnEditorActionListener(TextView.OnEditorActionListener { v, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                var inputString = binding.searchBar.text.toString()
                if (inputString.length >= 4) {
                    binding.searchBar.hideKeyboard()
                    listingViewModel.getListing(inputString)
                } else {
                    toast(getString(R.string.enter_aleast_4_digits))
                }
                true
            } else false
        })

        binding.tvDone.setOnClickListener {
            binding.searchBar.hideKeyboard()
            listingViewModel.getListing(binding.searchBar.text.toString())
        }

        binding.searchBar.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {

            }

            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {

                if (s.isNotEmpty()) {
                    binding.backButton.setImageResource(R.drawable.ic_back_arrow_blue)
                } else {
                    binding.backButton.setImageResource(R.drawable.ic_back_arrow_disable)
                }


                if (s.toString().length >= 4) {
                    binding.tvDone.visibility = View.VISIBLE
                } else {
                    binding.tvDone.visibility = View.GONE
                }
            }
        })

        mainTitles.add("Current Weather")
        mainTitles.add("Forecast Weather")


    }

    private fun setObservers() {
        lifecycleScope.launchWhenStarted {
            listingViewModel.listing.collectLatest {
                if (it.isLoading) {
                    binding.progressBar.visibility = View.VISIBLE
                }
                if (it.error.isNotBlank()) {
                    binding.progressBar.visibility = View.GONE
                    Toast.makeText(this@MainActivity, it.error, Toast.LENGTH_LONG).show()
                    binding.tabsGroup.visibility = View.GONE
                }
                it.data?.let {
                    binding.progressBar.visibility = View.GONE
                    AppApplication.sessionManager.saveWeatherDetail(it)
                    AppApplication.sessionManager.dataStore(true)
                    binding.tabsGroup.visibility = View.VISIBLE
                    setupViewPager(binding.viewpager)
                    binding.tabs.setupWithViewPager(binding.viewpager)
                    binding.viewpager.offscreenPageLimit = 0
                }
            }

        }
    }

    private fun setupViewPager(viewPager: ViewPager) {
        adapter = FragmentAdapter(supportFragmentManager)
        adapter.addFrag(CurrentWeatherFragment(), "Current Weather")
        adapter.addFrag(ForecastWeatherFragment(), "Forecast Weather")
        viewPager.adapter = adapter
    }

    override fun onClick(v: View?) {
        when (v) {

        }
    }


}