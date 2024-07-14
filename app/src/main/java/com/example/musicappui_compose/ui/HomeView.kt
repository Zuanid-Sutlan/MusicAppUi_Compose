package com.example.musicappui_compose.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.musicappui_compose.R

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeView(pd: PaddingValues) {
    val categories =
        listOf("hints", "Happy", "Sad", "Excited", "Angry", "Other", "Yoga", "Meditation")
    val grouped = listOf("New Release", "Favourites", "Trending").groupBy { it[0] }

    LazyColumn(modifier = Modifier.padding(pd)) {
        grouped.forEach { item ->
            stickyHeader {
                Text(text = item.value[0], modifier = Modifier.padding(8.dp), color = Color.Black)

                LazyRow {
                    items(categories) {
                        HomeItemUi(cat = it, drawable = R.drawable.ic_music)
                    }
                }
            }
        }
    }
}

@Composable
fun HomeItemUi(modifier: Modifier = Modifier, cat: String, drawable: Int) {
    Card(
        modifier = modifier
            .padding(8.dp)
            .size(200.dp), border = BorderStroke(3.dp, Color.Blue)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = cat, color = Color.Black)
            Icon(painter = painterResource(id = drawable), contentDescription = "icon", tint = Color.Unspecified)
        }
    }
}