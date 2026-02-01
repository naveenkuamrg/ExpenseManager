package com.example.uilayer.compose.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.domain.module.module.TransactionType



@Composable
@Preview
fun PreviewEditScreen() {
    TransactionEditScreen()
}

@Composable
fun TransactionEditScreen() {
    var currentTransactionType by remember {
        mutableStateOf(TransactionType.CREDIT)
    }
    TransactionTypeSelector(
        currentTransactionType
    ) { transactionType ->
        currentTransactionType = transactionType
    }
}

@Composable
fun TransactionTypeSelector(
    selected: TransactionType,
    modifier: Modifier = Modifier,
    onSelected: (TransactionType) -> Unit
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        TransactionType.entries.forEach { type ->
            SegmentedButton(
                name = type.name.lowercase().replaceFirstChar { it.uppercase() },
                selected = selected == type,
                onClick = { onSelected(type) },
                modifier = Modifier.weight(1f)
            )
        }
    }
}