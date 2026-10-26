package com.example.core.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface BudgetDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBudget(budget: BudgetEntity)
    @Query("SELECT * FROM budgetentity")
    suspend fun getBudgets(): List<BudgetEntity>
    @Delete
    suspend fun deleteBudget(budget: BudgetEntity)
}