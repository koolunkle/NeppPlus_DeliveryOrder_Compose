package com.neppplus.deliveryorder_20211108

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.neppplus.deliveryorder_20211108.adapters.MainViewPagerAdapter
import com.neppplus.deliveryorderpractice_20211108.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var mvpa : MainViewPagerAdapter
//  * 변수는 미리 선언하고 작업은 나중에 진행한다. 원하는 시점에 작업 진행 도모 & 오류 방지

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//  * onCreate : Activity에 내가 사용할 View를 생성한다.
        setContentView(R.layout.activity_main)
        setupEvents()
        setValues()
//      * setupEvents() & setValues() : 우리가 원하는 함수를 호출하자!
    }

    fun setupEvents() {

    }

    fun setValues() {
        mvpa = MainViewPagerAdapter(supportFragmentManager)
        mainViewPager.adapter = mvpa
//  * fun setupEvents() & fun setValues() 우리가 원하는 함수를 정의하자!
//  * supportFragmentManager의 도움을 받아 View에 우리가 원하는 데이터를 적용(연결)하자!

        mainTabLayout.setupWithViewPager(mainViewPager)
//      * setupWithViewPager : ViewPager를 토대로 TabLayout을 구성한다.

    }

}