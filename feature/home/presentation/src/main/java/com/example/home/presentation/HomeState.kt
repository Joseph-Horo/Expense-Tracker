package com.example.home.presentation

import com.example.home.domain.model.Budget
import com.example.home.domain.model.Expense

data class HomeState(
    val expense: List<Expense> = emptyList(),
    val budgets: List<Budget> = emptyList(),
    val totalExpense: Double = 0.0,
    val totalIncome: Double = 0.0,
    val isLoading: Boolean = false

)
