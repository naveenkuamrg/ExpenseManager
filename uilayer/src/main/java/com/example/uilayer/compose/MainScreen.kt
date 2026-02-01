package com.example.uilayer.compose

import android.widget.Toast
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.uilayer.R
import com.example.uilayer.UIUtils
import com.example.uilayer.compose.BottomSheets.AppBottomNavigationBar
import com.example.uilayer.navigation.Graph
import com.example.uilayer.navigation.Screen
import com.example.uilayer.navigation.detailNavGraph
import com.example.uilayer.navigation.editNavGraph
import com.example.uilayer.navigation.listNavGraph
import com.example.uilayer.navigation.settingsNavGraph


@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()

    Scaffold(
        bottomBar = {
            val route = navBackStackEntry?.destination?.route
            if (UIUtils.isMainListPage(route)) {
                AppBottomNavigationBar(navController)
            }
        },
        floatingActionButton = {
            val route = navBackStackEntry?.destination?.route
            if (UIUtils.isMainListPage(route)) {
                FloatingActionButton(
                    onClick = {
                        when(route) {
                            "tracker_list" -> {navController.navigate(Screen.TrackerEdit.route)}
                            "contact_list" -> {TODO()}
                            "account_list" -> {TODO()}
                        }
                    }
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.add_2),
                        contentDescription = "Tracker"
                    )
                }
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Graph.List.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            listNavGraph(navController)
            detailNavGraph(navController)
            settingsNavGraph(navController)
            editNavGraph(navController)
        }
    }
}