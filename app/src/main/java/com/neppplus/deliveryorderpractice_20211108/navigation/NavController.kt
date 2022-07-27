package com.neppplus.deliveryorderpractice_20211108.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.google.accompanist.pager.ExperimentalPagerApi
import com.neppplus.deliveryorderpractice_20211108.navigation.screen.Screen
import com.neppplus.deliveryorderpractice_20211108.navigation.screen.main.MainScreen
import com.neppplus.deliveryorderpractice_20211108.navigation.screen.splash.SplashScreen

@ExperimentalPagerApi
@Composable
fun SetupNavController(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.Splash.route
    ) {
        composable(route = Screen.Splash.route) {
            SplashScreen(navController = navController)
        }

        composable(route = Screen.Main.route) {
            MainScreen()
        }
    }
}