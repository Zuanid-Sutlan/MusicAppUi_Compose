package com.example.musicappui_compose

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private val _currentScreen: MutableState<Screens> = mutableStateOf(Screens.DrawerScreens.Account)

    var addAccountDialogState = mutableStateOf(false)

    val currentScreen : MutableState<Screens>
        get() = _currentScreen

    fun setCurrentScreen(screens: Screens){
        _currentScreen.value = screens
    }

}