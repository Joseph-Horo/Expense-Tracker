package com.example.transactions.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.core.ui.icons.Delete
import com.example.transactions.domain.model.Expense
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@Composable
fun TransactionItem(
    expense: Expense,
    onDelete: () -> Unit
) {
    val formattedDate = remember(expense.date) {
        SimpleDateFormat("MMM dd, yyyy", Locale.getDefault()).format(Date(expense.date))
    }

    Row(
        modifier = Modifier.fillMaxWidth()
            .padding(16.dp)
    ) {
        Column(modifier = Modifier.weight(1f)) {

            Text(text = expense.title)
            Text(text = expense.category)
            Text(text = formattedDate)
        }
        IconButton(
            onClick = onDelete
        ) {
            Icon(imageVector = Delete, contentDescription = "Delete", tint = Color.Red)
        }

    }
    HorizontalDivider(color = Color(0xFFF1F5F9))

}