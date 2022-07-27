package com.neppplus.deliveryorderpractice_20211108.ui.nickname

import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.neppplus.deliveryorderpractice_20211108.R

class EditNicknameActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EditNicknameContentPreview()
        }
    }

    @Composable
    fun EditNicknameContent() {
        val modifier = Modifier.fillMaxWidth()
        var content by rememberSaveable { mutableStateOf("") }
        val resultIntent = Intent()

        Column(modifier = Modifier.padding(20.dp)) {
            OutlinedTextField(
                modifier = modifier,
                value = content,
                onValueChange = { content = it },
                singleLine = true,
                label = { Text(text = resources.getString(R.string.input_new_nickname)) }
            )
            Spacer(modifier = Modifier.padding(5.dp))
            Button(
                modifier = modifier,
                onClick = {
                    resultIntent.putExtra("nickname", content)
                    setResult(RESULT_OK, resultIntent)
                    finish()
                }) { Text(text = resources.getString(R.string.confirm_new_nickname)) }
        }
    }

    @Preview
    @Composable
    fun EditNicknameContentPreview() {
        Scaffold {
            EditNicknameContent()
        }
    }

}