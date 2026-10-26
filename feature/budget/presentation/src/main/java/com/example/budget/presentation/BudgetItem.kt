package com.example.budget.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.budget.domain.model.Budget
import com.example.core.ui.icons.Delete

@Composable
fun BudgetItem(
    budget: Budget,
    onDelete: () -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth()
            .padding(vertical = 10.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFF1F5F9)),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row(modifier = Modifier.padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            ) {
            Column(modifier = Modifier.weight(1f)) {

                Text(text = budget.category,
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp)
                Text(text = "- KES ${"%,.2f".format(budget.amount)}")
            }
            IconButton(
                onClick = onDelete
            ) {
                Icon(imageVector = Delete, contentDescription = "Delete", tint = Color.Red)
            }
        }
    }

}