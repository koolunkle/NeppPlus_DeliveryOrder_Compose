package com.neppplus.deliveryorderpractice_20211108.ui.main

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.Scaffold
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.neppplus.deliveryorderpractice_20211108.navigation.SetupNavController

@ExperimentalPagerApi
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Scaffold {
                SetupNavController(rememberNavController())
            }
        }
    }

}