package com.example.musicappui_compose.model

import androidx.annotation.DrawableRes
import com.example.musicappui_compose.R

data class DummyLib(@DrawableRes val icon: Int, val name: String)


val libraries = listOf(
    DummyLib(R.drawable.ic_music, "Music"),
    DummyLib(R.drawable.ic_account, "Account"),
    DummyLib(R.drawable.ic_subscription, "Subscription"),
    DummyLib(R.drawable.ic_add_account, "Add New Account")
)