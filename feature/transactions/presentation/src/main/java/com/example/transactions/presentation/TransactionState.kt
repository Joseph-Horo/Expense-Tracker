package com.example.transactions.presentation

import com.example.transactions.domain.model.Expense

data class TransactionState(
    val expense: List<Expense> = emptyList(),
    val searchQuery: String = "",
    val isLoading: Boolean = false
)
