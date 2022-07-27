package com.neppplus.deliveryorderpractice_20211108.navigation.screen.splash

import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.navigation.NavHostController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.neppplus.deliveryorderpractice_20211108.R
import com.neppplus.deliveryorderpractice_20211108.navigation.screen.Screen

@Composable
fun SplashScreen(navController: NavHostController) {
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.anim_splash))
    val logoAnimationState = animateLottieCompositionAsState(composition = composition)

    LottieAnimation(
        composition = composition,
        progress = { logoAnimationState.progress }
    )

    if (logoAnimationState.isAtEnd && logoAnimationState.isPlaying) {
        navController.navigate(Screen.Main.route)
    }
}