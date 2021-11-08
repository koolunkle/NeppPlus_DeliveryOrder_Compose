package com.neppplus.deliveryorder_20211108.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.neppplus.deliveryorder_20211108.EditNicknameActivity
import com.neppplus.deliveryorderpractice_20211108.R
import kotlinx.android.synthetic.main.fragment_my_profile.*

class MyProfileFragment : Fragment() {

    val REQ_CODE_NICKNAME = 1000
//  * "1000"이 무엇을 의미하는지 기록

    override fun onCreateView(
//      * onCreateView : Fragment에 내가 사용할 View를 생성한다.
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_my_profile, container, false)
//      * fragment_my_profile xml 파일을 객체화하여 불러온다.
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
//      * onActivityCreated : Fragment에 View가 생성되고 난후 이를 Activity에 적용한다.
        super.onActivityCreated(savedInstanceState)

//        동작 관련 코드 작성 예정

        btnEditNickname.setOnClickListener {
//      * 버튼 클릭 이벤트를 지정하자!
            val myIntent = Intent(requireContext(), EditNicknameActivity::class.java)
            startActivityForResult(myIntent, REQ_CODE_NICKNAME)
//          * 버튼을 누르면 닉네임 변경 화면으로 전환시킨다.

        }


    }


}