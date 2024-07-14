package com.example.musicappui_compose.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.musicappui_compose.MainViewModel
import com.example.musicappui_compose.Screens
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterialApi::class)
@Composable
fun MainView() {

    val screensInDrawer = listOf(
        Screens.DrawerScreens.Account,
        Screens.DrawerScreens.Subscription,
        Screens.DrawerScreens.AddAccount
    )

    val screensInBottom = listOf(
        Screens.BottomScreens.Home,
        Screens.BottomScreens.Search,
        Screens.BottomScreens.Library
    )

    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()

    val viewModel: MainViewModel = viewModel()

    // it allow us to find which "View" we currently are.
    val controller = rememberNavController()
    val navBackStackEntry by controller.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    // TODO change that to current screen.title
    val currentScreen = remember { viewModel.currentScreen.value }
    val title = remember { mutableStateOf(currentScreen.title) }

    val background = if (isSystemInDarkTheme()) Color.Black else Color.White

    val isSheetFullScreen by remember { mutableStateOf(false) }
    val modifier = if (isSheetFullScreen) Modifier.fillMaxSize() else Modifier.fillMaxWidth()

    val modelSheetState = rememberModalBottomSheetState(
        initialValue = ModalBottomSheetValue.Hidden,
        confirmValueChange = { it != ModalBottomSheetValue.HalfExpanded }
    )

    // bottom bar setting up
    val bottomBar: @Composable () -> Unit = {

        if (currentScreen is Screens.DrawerScreens || currentScreen is Screens.BottomScreens) {
            BottomNavigation(modifier = Modifier
                .wrapContentSize()
                .graphicsLayer {
                    shape = RoundedCornerShape(topStart = 10.dp, topEnd = 10.dp)
                    clip = true
                }) {
                screensInBottom.forEach { item ->
                    BottomNavigationItem(
                        selected = currentRoute == item.bRoute, icon = {
                            Icon(
                                painter = painterResource(id = item.icon),
                                contentDescription = null
                            )
                        },
                        onClick = {
                            controller.navigate(item.bRoute)
                                  title.value = item.bTitle
                                  },
                        label = { Text(text = item.bTitle) },
                        selectedContentColor = Color.White,
                        unselectedContentColor = Color.White.copy(alpha = 0.4f),
                        alwaysShowLabel = false
                    )
                }
            }
        }
    }


    ModalBottomSheetLayout(
        sheetState = modelSheetState,
        sheetShape = RoundedCornerShape(topStart = 10.dp, topEnd = 10.dp),
        sheetContent = { BottomSheetItems() }
    ) {
        Scaffold(
            bottomBar = bottomBar,
            topBar = {
                TopAppBar(
                    modifier = Modifier
                        .padding(bottom = 4.dp)
                        .background(
                            color = MaterialTheme.colorScheme.primaryContainer,
                            shape = RoundedCornerShape(bottomStart = 4.dp, bottomEnd = 4.dp)
                        ),
                    title = {
                        Text(
                            text = title.value,
                            color = if (isSystemInDarkTheme()) Color.White else Color.Black,
                            fontSize = 18.sp
                        )
                    },
                    navigationIcon = {
                        IconButton(
                            onClick = {
                                /*TODO open the nav drawer*/
                                scope.launch {
                                    scaffoldState.drawerState.open()
                                }
                            }) {
                            Icon(
                                imageVector = Icons.Default.Menu,
                                contentDescription = null,
                                tint = if (isSystemInDarkTheme()) Color.White else Color.Black
                            )
                        }
                    },
                    actions = {
                        IconButton(
                            onClick = {
                                scope.launch {
                                    if (modelSheetState.isVisible){
                                        modelSheetState.hide()
                                    }else{
                                        modelSheetState.show()
                                    }
                                }
                            }) {
                            Icon(
                                imageVector = Icons.Default.MoreVert,
                                contentDescription = null,
                                tint = if (isSystemInDarkTheme()) Color.White else Color.Black
                            )
                        }
                    },
                    scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(canScroll = { false })
                )
            },
            scaffoldState = scaffoldState,
            drawerContent = {
                LazyColumn(modifier = Modifier.padding(16.dp)) {
                    items(screensInDrawer) { item ->
                        DrawerItems(
                            title = item.dTitle,
                            isSelected = currentRoute == item.dRoute,
                            item = item,
                            onItemClicked = {

                                if (item.dRoute == "addAccount") {
                                    // open dialog
                                    viewModel.addAccountDialogState.value = true
                                } else {
                                    controller.navigate(item.dRoute)
                                    title.value = item.dTitle
                                }

                                scope.launch {
                                    scaffoldState.drawerState.close()
                                }
                            })
                    }
                }
            },
            /*drawerBackgroundColor = background,*/
            /*drawerContentColor = if (isSystemInDarkTheme()) Color.White else Color.Black*/
        ) {
            Navigation(controller, viewModel, it)
            AccountDialog(showDialog = viewModel.addAccountDialogState)
        }
    }

}

@Composable
fun BottomSheetItems(modifier: Modifier = Modifier) {

    Column(modifier = modifier.fillMaxHeight(0.3f)) {
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start) {
            Icon(imageVector = Icons.Default.Settings, contentDescription = "setting")
            Spacer(modifier = Modifier.width(4.dp))
            Text(text = "Settings")
        }
    }
}


@Composable
fun DrawerItems(
    title: String,
    isSelected: Boolean,
    item: Screens.DrawerScreens,
    onItemClicked: () -> Unit
) {

    val background = if (isSelected) Color.Gray else Color.Transparent

    Box(modifier = Modifier
        .fillMaxWidth()
        .padding(4.dp)
        .clickable { onItemClicked() }
        .background(background, RoundedCornerShape(8.dp))) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(6.dp)
                .background(background, RoundedCornerShape(8.dp)),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Icon(
                painter = painterResource(id = item.icon),
                contentDescription = null,
                tint = if (isSystemInDarkTheme()) {
                    if (isSelected) Color.White else Color.Black
                } else {
                    if (isSelected) Color.White else Color.Black
                },
                modifier = Modifier.padding(top = 4.dp, end = 8.dp)
            )

            Text(
                text = item.dTitle, style = MaterialTheme.typography.headlineMedium,
                color = if (isSystemInDarkTheme()) {
                    if (isSelected) Color.White else Color.Black
                } else {
                    if (isSelected) Color.White else Color.Black
                }
            )

        }
    }

}

// Todo navigation of this app
@Composable
fun Navigation(navController: NavController, viewModel: MainViewModel, pd: PaddingValues) {
    NavHost(
        navController = navController as NavHostController,
        startDestination = Screens.DrawerScreens.Account.dRoute
    ) {
        composable(Screens.DrawerScreens.Account.dRoute) {
            AccountView(pd)
        }
        composable(Screens.DrawerScreens.Subscription.dRoute) {
            SubscriptionView(pd)
        }

        composable(Screens.BottomScreens.Home.bRoute) {
            HomeView(pd)
        }
        composable(Screens.BottomScreens.Search.bRoute) {
            BrowseView(pd)
        }
        composable(Screens.BottomScreens.Library.bRoute) {
            LibraryView(pd = pd)
        }
    }
}