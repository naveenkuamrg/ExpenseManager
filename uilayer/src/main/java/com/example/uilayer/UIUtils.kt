package com.example.uilayer

import com.example.uilayer.navigation.Screen

object UIUtils {
    fun  routesOfListPages(): List<String> {
        return listOf(
            Screen.ContactList.route,
            Screen.TrackerList.route,
            Screen.AccountList.route
        )
    }

    fun isMainListPage(route: String?): Boolean {
        return route in routesOfListPages()
    }
}