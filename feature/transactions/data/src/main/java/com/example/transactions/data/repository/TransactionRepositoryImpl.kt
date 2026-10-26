package com.example.transactions.data.repository

import com.example.core.database.ExpenseTrackerDatabase
import com.example.transactions.data.mapper.toExpense
import com.example.transactions.data.mapper.toExpenseEntity
import com.example.transactions.domain.model.Expense
import com.example.transactions.domain.repository.TransactionRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TransactionRepositoryImpl @Inject constructor(
    private val db: ExpenseTrackerDatabase
): TransactionRepository {
    private val expenseDao = db.expenseDao
    override suspend fun searchExpense(query: String): List<Expense> {
        return expenseDao.searchExpense(query).map { it.toExpense() }
    }

    override suspend fun addExpense(expense: Expense) {
        expenseDao.insertExpense(expense.toExpenseEntity())
    }

    override suspend fun deleteExpense(expense: Expense) {
        expenseDao.deleteExpense(expense.toExpenseEntity())
    }
}