package com.example.income.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.core.ui.icons.Delete
import com.example.income.domain.model.Income
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@Composable
fun IncomeCard(
    income: Income,
    onDelete: ()-> Unit
) {
    val formattedDate = remember(income.date) {
        SimpleDateFormat("MMM dd, yyyy", Locale.getDefault()).format(Date(income.date))
    }
    Card(
        modifier = Modifier.fillMaxWidth()
            .padding(vertical = 10.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFF1F5F9)),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween) {
            Column(modifier = Modifier.weight(1f)) {
                Text(text = "KES ${"%,.2f".format(income.amount)}")
                Text(text = formattedDate)
            }
            IconButton(
                onClick = onDelete
            ) {
                Icon(imageVector = Delete, contentDescription = "Delete", tint = Color.Red)
            }
        }
    }

}