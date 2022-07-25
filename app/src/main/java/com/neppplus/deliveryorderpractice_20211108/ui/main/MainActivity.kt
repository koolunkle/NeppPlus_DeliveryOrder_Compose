package com.neppplus.deliveryorderpractice_20211108.ui.main

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.appcompattheme.AppCompatTheme
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.pagerTabIndicatorOffset
import com.google.accompanist.pager.rememberPagerState
import com.neppplus.deliveryorderpractice_20211108.R
import com.neppplus.deliveryorderpractice_20211108.ui.nickname.EditNicknameActivity
import com.neppplus.deliveryorderpractice_20211108.util.Content
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var resultLauncher: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppCompatTheme {
                MainPreview()
            }
        }
    }

    @OptIn(ExperimentalPagerApi::class)
    @Composable
    fun MainDraw() {
        val tabData = listOf(
            resources.getString(R.string.chicken_order) to Icons.Default.Call,
            resources.getString(R.string.profile_setting) to Icons.Default.Person,
            resources.getString(R.string.pizza_order) to Icons.Default.Call
        )

        val pagerState = rememberPagerState(
            pageCount = tabData.size,
            initialPage = 1,
            initialOffscreenLimit = 2,
            infiniteLoop = true
        )

        val tabIndex = pagerState.currentPage
        val coroutineScope = rememberCoroutineScope()

        Column {
            TabRow(
                selectedTabIndex = tabIndex,
                backgroundColor = Color.White,
                contentColor = Color.Black,
                indicator = { tabPositions ->
                    TabRowDefaults.Indicator(
                        Modifier.pagerTabIndicatorOffset(pagerState, tabPositions),
                        color = Color.Black
                    )
                }
            ) {
                tabData.forEachIndexed { index, pair ->
                    Tab(
                        selected = tabIndex == index,
                        onClick = { coroutineScope.launch { pagerState.animateScrollToPage(index) } },
                        text = {
                            Text(
                                pair.first,
                                color = if (tabIndex == index) Color.Black else Color.LightGray
                            )
                        },
                        icon = { Icon(imageVector = pair.second, contentDescription = null) }
                    )
                }
            }
            HorizontalPager(state = pagerState) { index ->
                Column(modifier = Modifier.fillMaxSize()) {
                    when (index) {
                        0 -> Content.ChickenStoreContent()
                        1 -> ProfileContent()
                        2 -> Content.PizzaStoreContent()
                    }
                }
            }
        }
    }

    @Preview
    @Composable
    fun MainPreview() {
        AppCompatTheme {
            MainDraw()
        }
    }

    @Composable
    fun ProfileContent() {
        val modifier = Modifier.fillMaxWidth()
        var content by rememberSaveable { mutableStateOf(resources.getString(R.string.nickname)) }

        resultLauncher =
            rememberLauncherForActivityResult(
                ActivityResultContracts.StartActivityForResult()
            ) {
                if (it.resultCode == RESULT_OK) {
                    content = it.data?.getStringExtra("nickname").toString()
                    Toast.makeText(
                        this,
                        resources.getString(R.string.complete_new_nickname),
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

        Column(modifier = Modifier.padding(20.dp)) {
            Text(text = resources.getString(R.string.title_nickname))
            Row(
                modifier = modifier,
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(content)
                Button(onClick = {
                    val intent = Intent(this@MainActivity, EditNicknameActivity::class.java)
                    resultLauncher.launch(intent)
                }) {
                    Text(text = resources.getString(R.string.change_nickname))
                }
            }
        }
    }

}