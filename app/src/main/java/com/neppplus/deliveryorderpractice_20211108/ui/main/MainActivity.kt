package com.neppplus.deliveryorderpractice_20211108.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.google.android.material.tabs.TabLayoutMediator
import com.neppplus.deliveryorderpractice_20211108.R
import com.neppplus.deliveryorderpractice_20211108.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var mMainViewPagerAdapter: MainViewPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.apply {
            initView()
        }
    }

    private fun ActivityMainBinding.initView() {
        mMainViewPagerAdapter = MainViewPagerAdapter(this@MainActivity)
        mainViewPager.adapter = mMainViewPagerAdapter

        val tabTitleArray = arrayOf(
            resources.getString(R.string.pizza_order),
            resources.getString(R.string.chicken_order),
            resources.getString(R.string.profile_setting)
        )

        TabLayoutMediator(mainTabLayout, mainViewPager) { tab, position ->
            tab.text = tabTitleArray[position]
        }.attach()
    }

}