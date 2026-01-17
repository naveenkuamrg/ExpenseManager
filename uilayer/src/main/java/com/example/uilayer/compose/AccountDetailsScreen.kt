package com.example.uilayer.compose

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.uilayer.navigation.Screen

import com.example.uilayer.viewmodel.AccountPageViewModel

@Composable
fun AccountScreen(navController: NavController) {

    Button(onClick = {
        navController.navigate(
            Screen.AccountDetail.route("naveen kumar")
        ) {
            launchSingleTop = true
        }


    }) {
        Text("Click Me")
    }
}


@Composable
fun AccountDetailScreen(
    onBack: () -> Unit,
    viewModel: AccountPageViewModel
) {
    Column {
        Text(text = "Account ID: ${viewModel.accountId}")
        Button(onClick = onBack) {
            Text("Back")
        }
    }
}
