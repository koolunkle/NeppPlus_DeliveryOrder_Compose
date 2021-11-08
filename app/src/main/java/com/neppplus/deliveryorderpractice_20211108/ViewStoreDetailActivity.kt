package com.neppplus.deliveryorder_20211108

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.neppplus.deliveryorderpractice_20211108.R

class ViewStoreDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
//  * onCreate : Activity에 내가 사용할 View를 생성한다.
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_store_detail)
        setupEvents()
        setValues()
//      * setupEvents() & setValues() : 우리가 원하는 함수를 호출하자!
    }

    fun setupEvents() {

    }

    fun setValues() {

    }
//  * fun setupEvents() & fun setValues() 우리가 원하는 함수를 정의하자!
}