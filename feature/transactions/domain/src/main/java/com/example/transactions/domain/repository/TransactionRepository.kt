package com.example.transactions.domain.repository

import com.example.transactions.domain.model.Expense

interface TransactionRepository {

    suspend fun searchExpense(query: String): List<Expense>

    suspend fun addExpense(expense: Expense)

    suspend fun deleteExpense(expense: Expense)

}