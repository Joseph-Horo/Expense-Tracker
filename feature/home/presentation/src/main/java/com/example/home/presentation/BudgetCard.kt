package com.example.home.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.ProgressIndicatorDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@Composable
fun BudgetCard(
    budget: Double,
    totalExpense: Double
) {
    val progress = if(budget > 0.0){
        (totalExpense/budget).coerceIn(0.0, 1.0)
    }else{
        0.0
    }

    val currentMonth = remember {
        SimpleDateFormat("MMMM", Locale.getDefault()).format(Date())
    }
    Card(modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFF1F5F9)),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {

        Column(modifier = Modifier.padding(16.dp)) {

            Text("Budget Progress",
                fontWeight = FontWeight.Bold)

            Text(currentMonth)

            Text(text = "- KES ${"%,.2f".format(totalExpense)}/ - KES ${"%,.2f".format(budget)}")

            LinearProgressIndicator(
                progress = {progress.toFloat()},
                modifier = Modifier.fillMaxWidth()
                    .height(12.dp),
                color = Color(0xFFEC6FAE)
            )
        }
    }

}