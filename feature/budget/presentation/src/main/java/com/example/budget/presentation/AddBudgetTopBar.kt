package com.example.budget.presentation

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddBudgetTopBar(scrollBehavior: TopAppBarScrollBehavior) {
    TopAppBar(
        title = {
            Text("Add Budget")
        },
        scrollBehavior = scrollBehavior
    )

}