package com.neppplus.deliveryorderpractice_20211108.ui.profile

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import com.google.accompanist.appcompattheme.AppCompatTheme
import com.neppplus.deliveryorderpractice_20211108.R
import com.neppplus.deliveryorderpractice_20211108.ui.nickname.EditNicknameActivity

class ProfileFragment : Fragment() {

    private lateinit var resultLauncher: ActivityResultLauncher<Intent>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                AppCompatTheme {
                    ProfilePreview()
                }
            }
        }
    }

    @Composable
    fun ProfileDraw() {
        val modifier = Modifier.fillMaxWidth()
        var content by rememberSaveable { mutableStateOf(resources.getString(R.string.koolunkle)) }

        Column(modifier = Modifier.padding(20.dp)) {
            Text(text = resources.getString(R.string.nickname))
            Row(
                modifier = modifier,
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(content)
                Button(onClick = { resultLauncherActivity() }) {
                    Text(text = resources.getString(R.string.change_nickname))
                }
            }
        }

        resultLauncher =
            rememberLauncherForActivityResult(ActivityResultContracts.StartActivityForResult()) {
                if (it.resultCode == Activity.RESULT_OK) {
                    content = it.data?.getStringExtra("nickname").toString()
                    showToast()
                }
            }
    }

    @Preview
    @Composable
    fun ProfilePreview() {
        AppCompatTheme {
            ProfileDraw()
        }
    }

    private fun showToast() {
        Toast.makeText(
            requireContext(),
            resources.getString(R.string.complete_new_nickname),
            Toast.LENGTH_SHORT
        ).show()
    }

    private fun resultLauncherActivity() {
        val intent = Intent(requireContext(), EditNicknameActivity::class.java)
        resultLauncher.launch(intent)
    }

}