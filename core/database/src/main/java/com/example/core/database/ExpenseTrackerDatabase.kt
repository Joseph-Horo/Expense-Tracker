package com.example.core.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [
        BudgetEntity::class,
        IncomeEntity::class,
        ExpenseEntity::class
    ],
    version = 1
)
abstract class ExpenseTrackerDatabase: RoomDatabase() {
    abstract val budgetDao: BudgetDao
    abstract val incomeDao: IncomeDao
    abstract val expenseDao: ExpenseDao
}