package com.example.transactions.domain.model

data class Expense(
    val id: Int,
    val title: String,
    val category: String,
    val amount: Double,
    val date: Long
)
