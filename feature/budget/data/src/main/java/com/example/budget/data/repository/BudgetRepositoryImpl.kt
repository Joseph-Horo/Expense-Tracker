package com.example.budget.data.repository

import com.example.budget.data.mapper.toBudget
import com.example.budget.data.mapper.toBudgetEntity
import com.example.budget.domain.model.Budget
import com.example.budget.domain.repository.BudgetRepository
import com.example.core.database.ExpenseTrackerDatabase
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class BudgetRepositoryImpl @Inject constructor(
    private val db: ExpenseTrackerDatabase
): BudgetRepository{

    private val budgetDao = db.budgetDao
    override suspend fun getBudgets(): List<Budget> {
       return budgetDao.getBudgets().map { it.toBudget() }
    }

    override suspend fun addBudget(budget: Budget) {
       budgetDao.insertBudget(budget.toBudgetEntity())
    }

    override suspend fun deleteBudget(budget: Budget) {
        budgetDao.deleteBudget(budget.toBudgetEntity())
    }
}