package com.example.budget.presentation

import com.example.budget.domain.model.Budget

data class BudgetState(
    val budgets: List<Budget> = emptyList(),
    val isLoading: Boolean = false
)