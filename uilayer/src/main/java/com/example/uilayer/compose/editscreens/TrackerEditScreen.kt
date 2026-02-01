package com.example.uilayer.compose.editscreens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.domain.module.module.TransactionType
import com.example.uilayer.viewmodel.ExpenseTrackerViewModel

@Composable
fun TrackerEditScreen(
    navController: NavController,
    trackerViewModel: ExpenseTrackerViewModel = hiltViewModel()
) {
    Column() {
        paymentTypeSwitcher({})
    }
}

@Composable
fun paymentTypeSwitcher(onClick: (TransactionType) -> Unit) {
    var currentTransactionType = mutableStateOf(TransactionType.DEBIT)

    Row(modifier = Modifier.fillMaxWidth()) {
        Button(
            onClick = {
                currentTransactionType.value = TransactionType.CREDIT
            },
            modifier = Modifier.weight(1f),
            border = BorderStroke(1.dp   , Color.Red),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.DarkGray,
                contentColor = Color.Black,
                disabledContainerColor = Color.Gray,
                disabledContentColor = Color.DarkGray
            )
        ) {
            Text("Income")
        }
        Button(
            onClick = {
                currentTransactionType.value = TransactionType.DEBIT
            },
            modifier = Modifier.weight(1f)
        ) {
            Text("Expense")
        }
        Button(
            onClick = {
                currentTransactionType.value = TransactionType.TRANSFER
            },
            modifier = Modifier.weight(1f)
        ) {
            Text("Transfer")
        }
    }
}