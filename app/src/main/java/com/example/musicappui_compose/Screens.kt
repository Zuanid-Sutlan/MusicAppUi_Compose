package com.example.musicappui_compose

import androidx.annotation.DrawableRes

sealed class Screens(val title: String, route: String) {

    sealed class BottomScreens(val bTitle: String, val bRoute: String, @DrawableRes val icon: Int) : Screens(bTitle, bRoute) {
        data object Home : BottomScreens("Home", "home", R.drawable.ic_music)
        data object Search : BottomScreens("Search", "search", R.drawable.ic_subscription)
        data object Library : BottomScreens("Library", "library", R.drawable.ic_account)
    }

    sealed class DrawerScreens(val dTitle: String, val dRoute: String, @DrawableRes val icon: Int) :
        Screens(dTitle, dRoute) {

        data object Account : DrawerScreens(
            "Account",
            "account",
            R.drawable.ic_account
        )

        data object Subscription : DrawerScreens(
            "Subscription",
            "subscription",
            R.drawable.ic_subscription
        )

        data object AddAccount : DrawerScreens(
            "Add Account",
            "addAccount",
            R.drawable.ic_add_account
        )

    }

}