package com.example.uilayer.compose

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember

import com.example.uilayer.viewmodel.AccountPageViewModel

@Composable
fun AccountScreen(viewModel: AccountPageViewModel ) {
    val accountState = viewModel.accountState.collectAsState(initial = null)


    // Fetch account when this composable first enters composition
    LaunchedEffect(Unit) {
        viewModel.getAccount("1")
        Log.i("TAG",accountState.value?.statusCode.toString())
    }


    var text = remember {   accountState.value?.statusCode.toString() }
    Column() {


        TextField(
            value = text,
            onValueChange = {}
        )

        Button(onClick = {
            Log.i("TAG",accountState.value?.statusCode.toString())

        }) {
            Text("Click Me")
        }
    }


}