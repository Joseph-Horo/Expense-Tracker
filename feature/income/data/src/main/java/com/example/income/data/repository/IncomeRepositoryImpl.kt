package com.example.income.data.repository

import com.example.core.database.ExpenseTrackerDatabase
import com.example.income.data.mapper.toIncome
import com.example.income.data.mapper.toIncomeEntity
import com.example.income.domain.model.Income
import com.example.income.domain.repository.IncomeRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class IncomeRepositoryImpl @Inject constructor(
    private val db: ExpenseTrackerDatabase
): IncomeRepository{
    private val incomeDao = db.incomeDao
    override suspend fun getIncome(): List<Income> {
       return incomeDao.getIncome().map { it.toIncome() }
    }

    override suspend fun getTotalIncome(): Double {
       return incomeDao.getTotalIncome() ?: 0.0
    }

    override suspend fun addIncome(income: Income) {
        incomeDao.insertIncome(income.toIncomeEntity())
    }

    override suspend fun deleteIncome(income: Income) {
       incomeDao.deleteIncome(income.toIncomeEntity())
    }
}