package com.example.musicappui_compose.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.musicappui_compose.Screens
import com.example.musicappui_compose.model.DummyLib
import com.example.musicappui_compose.model.libraries

@Composable
fun LibraryView(pd: PaddingValues) {
    LazyColumn(modifier = Modifier.padding(pd)) {
        items(libraries) {
            LibrariesItemUi(item = it)
        }
    }
}

@Composable
fun LibrariesItemUi(item: DummyLib) {
    Column {


        Row(
            modifier = Modifier.fillMaxWidth().padding(3.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row {
                Spacer(modifier = Modifier.width(3.dp))
                Icon(painter = painterResource(id = item.icon), contentDescription = item.name, tint = Color.Unspecified)
                Spacer(modifier = Modifier.width(2.dp))
                Text(text = item.name, color = Color.Black)
            }
            Icon(
                modifier = Modifier.padding(4.dp),
                imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                contentDescription = "go",
                tint = Color.Unspecified
            )

        }
        Divider(color = Color.Black)

    }
}