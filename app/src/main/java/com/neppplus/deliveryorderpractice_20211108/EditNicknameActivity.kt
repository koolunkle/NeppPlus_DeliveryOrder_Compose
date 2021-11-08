package com.neppplus.deliveryorder_20211108

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.neppplus.deliveryorderpractice_20211108.R
import kotlinx.android.synthetic.main.activity_edit_nickname.*

class EditNicknameActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
//  * onCreate : Activity에 내가 사용할 View를 생성한다.
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_nickname)
        setupEvents()
        setValues()
//      * setupEvents() & setValues() : 우리가 원하는 함수를 호출하자!
    }

    fun setupEvents() {

        btnOk.setOnClickListener {
//      * 버튼 클릭 이벤트를 지정하자!
            val inputNickname = edtNewNickname.text.toString()
//          * 새 닉네임이 입력될 때 이를 담아두자!
            val resultIntent = Intent()
            resultIntent.putExtra("nick", inputNickname)
            setResult(RESULT_OK, resultIntent)

            finish()
//          * 입력된 새 닉네임을 결과창으로 전환 및 출력한다.
        }


    }

    fun setValues() {

    }
//  * fun setupEvents() & fun setValues() 우리가 원하는 함수를 정의하자!

}