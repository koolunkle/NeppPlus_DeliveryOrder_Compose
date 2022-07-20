package com.neppplus.deliveryorderpractice_20211108.ui.main

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.neppplus.deliveryorderpractice_20211108.ui.store.chicken.ChickenStoreFragment
import com.neppplus.deliveryorderpractice_20211108.ui.store.pizza.PizzaStoreFragment
import com.neppplus.deliveryorderpractice_20211108.ui.profile.ProfileFragment

class MainViewPagerAdapter(activity: FragmentActivity) : FragmentStateAdapter(activity) {

    private val itemCount: Int = 3

    override fun getItemCount() = itemCount

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> PizzaStoreFragment()
            1 -> ChickenStoreFragment()
            else -> ProfileFragment()
        }
    }

}