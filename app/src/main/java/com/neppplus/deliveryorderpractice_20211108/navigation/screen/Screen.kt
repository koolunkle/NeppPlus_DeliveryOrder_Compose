package com.neppplus.deliveryorderpractice_20211108.navigation.screen

sealed class Screen(val route: String) {
    object Splash : Screen("splash_screen")
    object Main : Screen("main_screen")
}