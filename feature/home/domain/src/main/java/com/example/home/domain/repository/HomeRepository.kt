package com.example.home.domain.repository

import com.example.home.domain.model.Budget
import com.example.home.domain.model.Expense

interface HomeRepository {
    suspend fun getExpenses(): List<Expense>
    suspend fun getTotalExpense(): Double
    suspend fun getTotalIncome(): Double
    suspend fun getBudgets(): List<Budget>
}