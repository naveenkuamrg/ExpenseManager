package com.example.uilayer.navigation

sealed class Graph(val route: String) {
    object Root : Graph("root")
    object List : Graph("list")
    object Detail: Graph("detail")
}