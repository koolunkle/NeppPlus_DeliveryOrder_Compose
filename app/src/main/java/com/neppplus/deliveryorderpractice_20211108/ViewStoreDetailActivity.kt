package com.neppplus.deliveryorder_20211108

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.neppplus.deliveryorder_20211108.datas.StoreData
import com.neppplus.deliveryorderpractice_20211108.R
import kotlinx.android.synthetic.main.activity_view_store_detail.*

class ViewStoreDetailActivity : AppCompatActivity() {

    lateinit var mStoreData : StoreData
//  * 변수는 미리 선언하고 작업은 나중에 진행한다. 원하는 시점에 작업 진행 도모 & 오류 방지

    override fun onCreate(savedInstanceState: Bundle?) {
//  * onCreate : Activity에 내가 사용할 View를 생성한다.
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_store_detail)
        setupEvents()
        setValues()
//      * setupEvents() & setValues() : 우리가 원하는 함수를 호출하자!
    }

    fun setupEvents() {

        btnCall.setOnClickListener {
//      * 버튼 클릭 이벤트를 지정하자!


        }

    }

    fun setValues() {

        mStoreData =  intent.getSerializableExtra("store") as StoreData
//      * getSerializableExtra : Serializable 형태로 변환하여 담은 데이터(putExtra)를 "as 데이터클래스"를 활용하여 받는다.
        txtStoreName.text = mStoreData.name
        txtPhoneNum.text = mStoreData.phoneNum
//       * 기입된 name & phoneNum을 txtStoreName & txtPhoneNum에 출력하자!
        Glide.with(this).load(mStoreData.logoURL).into(imgLogo)
//      * Glide 라이브러리를 활용하여 이미지를 직접 추가하지 않고(drawable) 주소만 받아 불러오자!
//      * 위 과정을 통해 용량 효울을 높일 수 있다.
    }
//  * fun setupEvents() & fun setValues() 우리가 원하는 함수를 정의하자!
}