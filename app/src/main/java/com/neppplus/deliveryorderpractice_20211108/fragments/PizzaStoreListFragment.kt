package com.neppplus.deliveryorder_20211108.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.neppplus.deliveryorderpractice_20211108.R

class PizzaStoreListFragment : Fragment() {

    override fun onCreateView(
//      * onCreateView : Fragment에 내가 사용할 View를 생성한다.
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_pizza_store_list, container, false)
//      * fragment_pizza_store_list xml 파일을 객체화하여 불러온다.
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
//      * onActivityCreated : Fragment에 View가 생성되고 난후 이를 Activity에 적용한다.
        super.onActivityCreated(savedInstanceState)

//        동작 관련 코드 작성 예정

    }


}