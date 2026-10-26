package com.example.home.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TotalBalanceCard(
    totalBalance: Double
) {

    Card(
        modifier = Modifier.fillMaxWidth()
            .height(100.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFC4B5FD)),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)

    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text("Total Balance",
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
                color = Color.White)
            Spacer(modifier = Modifier.height(12.dp))
            Text(text = "KES ${"%,.2f".format(totalBalance)}",
                color = Color.White,
                fontSize = 20.sp,
            )
        }
    }

}