package com.example.musicappui_compose.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
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
fun BrowseView(pd: PaddingValues) {
    val categories =
        listOf("hints", "Happy", "Sad", "Excited", "Angry", "Other", "Yoga", "Meditation")

    LazyVerticalGrid(columns = GridCells.Fixed(2), modifier = Modifier.padding(pd)){
        items(categories) {
            BrowseItemUi(cat = it, drawable = R.drawable.ic_music)
        }
    }
}

@Composable
fun BrowseItemUi(modifier: Modifier = Modifier, cat: String, drawable: Int) {
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