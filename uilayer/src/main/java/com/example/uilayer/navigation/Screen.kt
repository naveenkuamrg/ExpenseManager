package com.example.uilayer.navigation

sealed class Screen(val route: String) {
    object ContactList : Screen("contact_list")
    object TrackerList : Screen("tracker_list")
    object AccountList : Screen("account_list")


    object ContactDetail : Screen("contact_detail/{id}") {
        fun route(id: String) = "contact_detail/$id"
    }

    object TrackerDetail : Screen("tracker_detail/{id}") {
        fun route(id: String) = "tracker_detail/$id"
    }

    object AccountDetail : Screen("account_detail/{id}") {
        fun route(id: String) = "account_detail/$id"
    }

    object Settings : Screen("settings")

    object Profile: Screen("profile")
}