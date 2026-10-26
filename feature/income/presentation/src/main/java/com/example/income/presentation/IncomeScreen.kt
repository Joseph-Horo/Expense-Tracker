package com.example.income.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.compose.LifecycleEventEffect
import androidx.navigation.NavController

@Composable
fun IncomeScreen(
    viewModel: IncomeViewModel = hiltViewModel(),
    navController: NavController
) {
    val state = viewModel.state
    LifecycleEventEffect(Lifecycle.Event.ON_RESUME) {
        viewModel.refreshIncome()
    }

    Box(modifier = Modifier.fillMaxSize()) {

        LazyColumn(modifier = Modifier.fillMaxSize()
            .padding(16.dp)) {
item {
    Text("Total Income",
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp)

}
            item {
                Text(text = " - KES ${"%.2f".format(state.totalIncome)}",
                    fontSize = 16.sp)
            }
            item {
                Spacer(modifier = Modifier.height(12.dp))
            }
            items(state.income){income->
                IncomeCard(
                    income = income,
                    onDelete = {
                        viewModel.deleteIncome(income)
                    }
                )
            }

        }
        FloatingActionButton(
            onClick = {
                navController.navigate("addIncome")
            },
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(bottom = 80.dp, end = 20.dp),
            containerColor = Color(0xFFF1F5F9)

        ) {
            Icon(imageVector = Icons.Default.Add, contentDescription = "AddIncome")
        }
    }

}