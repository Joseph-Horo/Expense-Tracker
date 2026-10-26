package com.example.income.domain.repository

import com.example.income.domain.model.Income

interface IncomeRepository {
    suspend fun getIncome(): List<Income>
    suspend fun getTotalIncome(): Double
    suspend fun addIncome(income: Income)
    suspend fun deleteIncome(income: Income)
}