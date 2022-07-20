package com.neppplus.deliveryorderpractice_20211108.ui.nickname

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.neppplus.deliveryorderpractice_20211108.R
import com.neppplus.deliveryorderpractice_20211108.databinding.ActivityEditNicknameBinding

class EditNicknameActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEditNicknameBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_edit_nickname)
        binding.apply {
            activity = this@EditNicknameActivity
        }
    }

    fun setResultIntent() {
        val inputNickname = binding.edtNickname.text.toString()
        val resultIntent = Intent()

        resultIntent.putExtra("nick", inputNickname)
        setResult(RESULT_OK, resultIntent)

        finish()
    }

}