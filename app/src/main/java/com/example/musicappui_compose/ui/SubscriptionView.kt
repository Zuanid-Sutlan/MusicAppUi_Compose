package com.example.musicappui_compose.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ExitToApp
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SubscriptionView(pd: PaddingValues) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(pd)
    ) {
        Title()
        Spacer(modifier = Modifier.width(4.dp))
        MiddleMembershipView()
        Spacer(modifier = Modifier.width(4.dp))
        GetAPlanView()
    }
}

@Composable
fun Title() {
    Text(
        text = "Manage Your Subscription",
        fontSize = 18.sp,
        modifier = Modifier.fillMaxWidth(),
        textAlign = TextAlign.Center
    )
}

@Composable
fun MiddleMembershipView() {
    Card(modifier = Modifier.fillMaxWidth(),
        elevation = 4.dp) {
        Column(
            modifier = Modifier.fillMaxWidth(),
        ) {
            Text(text = "Musical \nFree Tier", modifier = Modifier.fillMaxWidth())
            TextButton(modifier = Modifier.align(Alignment.End), onClick = { /*TODO*/ }) {
                Text(text = "See All Plans")
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                    contentDescription = null
                )
            }
        }
    }

}

@Composable
fun GetAPlanView() {
    Card(modifier = Modifier
        .fillMaxWidth(),
        elevation = 4.dp) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(imageVector = Icons.AutoMirrored.Filled.ExitToApp, contentDescription = null)
            Spacer(modifier = Modifier.width(4.dp))
            Text(text = "Get a Plan")
        }
    }
}