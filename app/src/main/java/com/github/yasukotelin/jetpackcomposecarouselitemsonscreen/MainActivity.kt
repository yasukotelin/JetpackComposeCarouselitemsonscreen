package com.github.yasukotelin.jetpackcomposecarouselitemsonscreen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.github.yasukotelin.jetpackcomposecarouselitemsonscreen.ui.theme.JetpackComposeCarouselItemsOnScreenTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeCarouselItemsOnScreenTheme {
                MainScreen()
            }
        }
    }
}

