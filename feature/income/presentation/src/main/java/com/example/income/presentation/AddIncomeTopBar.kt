package com.example.income.presentation

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddIncomeTopBar(scrollBehavior: TopAppBarScrollBehavior) {
    TopAppBar(
        title = {
            Text("Add Income")
        },
        scrollBehavior = scrollBehavior
    )

}