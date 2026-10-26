package com.example.budget.domain.repository

import com.example.budget.domain.model.Budget

interface BudgetRepository {
    suspend fun getBudgets(): List<Budget>
    suspend fun addBudget(budget: Budget)
    suspend fun deleteBudget(budget: Budget)
}