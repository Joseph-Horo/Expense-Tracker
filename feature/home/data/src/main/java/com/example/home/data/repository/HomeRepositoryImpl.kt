package com.example.home.data.repository

import com.example.core.database.ExpenseTrackerDatabase
import com.example.home.data.mapper.toBudget
import com.example.home.data.mapper.toExpense
import com.example.home.domain.model.Budget
import com.example.home.domain.model.Expense
import com.example.home.domain.repository.HomeRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class HomeRepositoryImpl @Inject constructor(
    private val db: ExpenseTrackerDatabase
): HomeRepository {
    private val expenseDao = db.expenseDao
    private val budgetDao = db.budgetDao
    private val incomeDao = db.incomeDao
    override suspend fun getExpenses(): List<Expense> {
        return expenseDao.getExpense().map { it.toExpense() }
    }

    override suspend fun getTotalExpense(): Double {
        return expenseDao.getTotalExpense() ?: 0.0
    }

    override suspend fun getTotalIncome(): Double {
       return incomeDao.getTotalIncome() ?: 0.0
    }

    override suspend fun getBudgets(): List<Budget> {
        return budgetDao.getBudgets().map { it.toBudget() }
    }
}