package com.example.income.presentation

import com.example.income.domain.model.Income

data class IncomeState(
    val income: List<Income> = emptyList(),
    val totalIncome: Double = 0.0,
    val isLoading: Boolean = false
)
