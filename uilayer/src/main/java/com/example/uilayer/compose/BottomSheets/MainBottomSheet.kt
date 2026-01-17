package com.example.uilayer.compose.BottomSheets

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.domain.module.module.Contact
import com.example.uilayer.R
import com.example.uilayer.constants.Strings
import com.example.uilayer.navigation.Graph
import com.example.uilayer.navigation.Screen


data class ManiBottomNavItem(
    val route: String,
    val label: String,
    val icon: Int
)

val bottomNavItems = listOf<ManiBottomNavItem>(

    ManiBottomNavItem(
        Screen.TrackerList.route,
        Strings.TRACKERS,
        R.drawable.trackers
    ),
    ManiBottomNavItem(
        Screen.ContactList.route,
        Strings.CONTACTS,
        R.drawable.contacts
    ),
    ManiBottomNavItem(
        Screen.AccountList.route,
        Strings.ACCOUNTS,
        R.drawable.accounts
    )
)

@Composable
fun AppBottomNavigationBar(
    navController: NavController
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    NavigationBar {
        bottomNavItems.forEach { item ->
            NavigationBarItem(
                selected = currentRoute == item.route,
                onClick = {
                    navController.navigate(item.route) {
                        popUpTo(Graph.List.route) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                icon = {
                    Icon(
                        painter = painterResource(id = item.icon),
                        contentDescription = item.label
                    )
                },
                label = {
                    Text(item.label)
                }
            )
        }
    }


}