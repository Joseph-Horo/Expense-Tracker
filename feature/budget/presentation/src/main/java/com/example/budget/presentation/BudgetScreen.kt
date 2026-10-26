package com.example.budget.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.compose.LifecycleEventEffect
import androidx.navigation.NavController

@Composable
fun BudgetScreen(
    navController: NavController,
    viewModel: BudgetViewModel = hiltViewModel()
) {
    val state = viewModel.state
    LifecycleEventEffect(Lifecycle.Event.ON_RESUME) {
        viewModel.refreshBudget()
    }
    Box(modifier = Modifier.fillMaxSize()) {
        LazyColumn(
            modifier = Modifier.fillMaxSize()
                .padding(16.dp)
        ) {
            items(state.budgets){budget->
                BudgetItem(
                    budget = budget,
                    onDelete = {
                        viewModel.deleteBudget(budget)
                    }
                )
            }


        }
        FloatingActionButton(
            onClick = {
                navController.navigate("addBudget")
            },
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(bottom = 80.dp, end = 20.dp),
            containerColor = Color(0xFFF1F5F9)

        ) {
            Icon(imageVector = Icons.Default.Add, contentDescription = "onAddBudget")
        }
    }

}