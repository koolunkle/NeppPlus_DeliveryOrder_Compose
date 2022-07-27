package com.neppplus.deliveryorderpractice_20211108.navigation.screen.main

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.pagerTabIndicatorOffset
import com.google.accompanist.pager.rememberPagerState
import com.neppplus.deliveryorderpractice_20211108.R
import com.neppplus.deliveryorderpractice_20211108.util.Application
import com.neppplus.deliveryorderpractice_20211108.util.Content
import kotlinx.coroutines.launch

@ExperimentalPagerApi
@Composable
fun MainScreen() {
    val tabData = listOf(
        Application.context().resources.getString(R.string.chicken_order) to Icons.Default.Call,
        Application.context().resources.getString(R.string.profile_setting) to Icons.Default.Person,
        Application.context().resources.getString(R.string.pizza_order) to Icons.Default.Call
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
                    1 -> Content.ProfileContent()
                    2 -> Content.PizzaStoreContent()
                }
            }
        }
    }
}