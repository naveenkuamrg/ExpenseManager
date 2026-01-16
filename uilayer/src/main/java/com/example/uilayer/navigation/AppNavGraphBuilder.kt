package com.example.uilayer.navigation

import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.example.uilayer.compose.AccountDetailScreen
import com.example.uilayer.compose.AccountScreen
import com.example.uilayer.compose.ProfileScreen
import com.example.uilayer.compose.SettingsScreen
import com.example.uilayer.viewmodel.AccountPageViewModel


fun NavGraphBuilder.settingsNavGraph(
    navController: NavController
) {
    composable(Screen.Settings.route) {
        SettingsScreen(onBack = {
            navController.popBackStack()
        }, onOpenProfile = {
            navController.navigate(Screen.Profile.route)
        })
    }

    composable(Screen.Profile.route) {
        ProfileScreen(
            onBack = {
                navController.popBackStack()
            })
    }
}


fun NavGraphBuilder.listNavGraph(navController: NavController) {

    navigation(
        route = Graph.List.route, startDestination = Screen.AccountList.route
    ) {

        composable(Screen.ContactList.route) {
            TODO()
        }

        composable(Screen.TrackerList.route) {
            TODO()
        }

        composable(Screen.AccountList.route) {

            AccountScreen(navController)
        }


    }
}

fun NavGraphBuilder.detailNavGraph(navController: NavController) {

    composable(
        route = Screen.ContactDetail.route, arguments = listOf(navArgument("id") {
            type = NavType.StringType
        })
    ) {
        TODO()
    }

    composable(
        route = Screen.TrackerDetail.route, arguments = listOf(navArgument("id") {
            type = NavType.StringType
        })
    ) {
        TODO()
    }

    composable(
        route = Screen.AccountDetail.route,
        arguments = listOf(navArgument("id") { type = NavType.StringType })
    ) { backStackEntry ->
        val viewModel: AccountPageViewModel = hiltViewModel(backStackEntry)

        AccountDetailScreen(
            viewModel = viewModel,
            onBack = { navController.popBackStack() }
        )
    }

}

