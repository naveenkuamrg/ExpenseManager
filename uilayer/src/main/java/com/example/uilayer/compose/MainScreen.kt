package com.example.uilayer.compose

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.uilayer.compose.BottomSheets.AppBottomNavigationBar
import com.example.uilayer.navigation.Graph
import com.example.uilayer.navigation.Screen
import com.example.uilayer.navigation.detailNavGraph
import com.example.uilayer.navigation.listNavGraph
import com.example.uilayer.navigation.settingsNavGraph


@Composable
fun MainScreen(){
    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val route = navBackStackEntry?.destination?.route

            if (route in listOf(
                    Screen.ContactList.route,
                    Screen.TrackerList.route,
                    Screen.AccountList.route
                )
            ) {
                AppBottomNavigationBar(navController)
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
        }
    }
}