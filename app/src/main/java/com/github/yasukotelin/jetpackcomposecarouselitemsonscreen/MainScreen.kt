package com.github.yasukotelin.jetpackcomposecarouselitemsonscreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.github.yasukotelin.jetpackcomposecarouselitemsonscreen.ui.theme.JetpackComposeCarouselItemsOnScreenTheme
import kotlin.math.absoluteValue

@Composable
fun MainScreen() {
    Scaffold(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
        ) {
            ImageCarousel(
                itemNumber = 3.2f,
                modifier = Modifier.fillMaxWidth(),
                startPadding = 8.dp,
                endPadding = 8.dp,
            )
        }
    }
}

@Composable
@Preview
fun MainScreenPreview() {
    JetpackComposeCarouselItemsOnScreenTheme {
        MainScreen()
    }
}

@Composable
fun ImageCarousel(
    itemNumber: Float,
    modifier: Modifier = Modifier,
    startPadding: Dp = 0.dp,
    endPadding: Dp = 0.dp,
) {
    BoxWithConstraints(
        modifier = modifier,
    ) {
        val space = 8.dp
        val spacedCount = itemNumber.absoluteValue
        val itemWidth = (maxWidth - startPadding - (space * spacedCount)) / itemNumber

        LazyRow(
            contentPadding = PaddingValues(start = startPadding, end = endPadding),
            horizontalArrangement = Arrangement.spacedBy(space),
        ) {
            items(10) {
                Box(
                    modifier = Modifier
                        .width(itemWidth)
                        .wrapContentHeight()
                ) {
                    AsyncImage(
                        model = ImageRequest.Builder(LocalContext.current)
                            .data("https://placehold.jp/3d4070/ffffff/150x120.png")
                            .crossfade(true)
                            .build(),
                        contentDescription = null,
                        contentScale = ContentScale.FillWidth,
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color(0xFFEDEDED))
                    )
                }
            }
        }
    }
}

@Composable
@Preview
fun ImageCarouselPreview() {
    JetpackComposeCarouselItemsOnScreenTheme {
        ImageCarousel(itemNumber = 3.2f, startPadding = 16.dp)
    }
}