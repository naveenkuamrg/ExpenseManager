package com.example.uilayer.compose

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.uilayer.navigation.Graph
import com.example.uilayer.navigation.detailNavGraph
import com.example.uilayer.navigation.listNavGraph
import com.example.uilayer.navigation.settingsNavGraph


@Composable
fun MainScreen(){
    val navController = rememberNavController()

    Scaffold() { innerPadding ->
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