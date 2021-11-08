package com.neppplus.deliveryorderpractice_20211108

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_edit_nickname.*

class EditNicknameActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_nickname)
        setupEvents()
        setValues()
    }

    fun setupEvents() {

        btnOk.setOnClickListener {

            val inputNickname = edtNewNickname.text.toString()

            val resultIntent = Intent()
            resultIntent.putExtra("nick", inputNickname)
            setResult(RESULT_OK, resultIntent)

            finish()

        }

    }

    fun setValues() {

    }

}