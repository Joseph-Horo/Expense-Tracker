package com.example.core.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ExpenseDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertExpense(expense: ExpenseEntity)
    @Query("SELECT * FROM expenseentity ORDER BY date DESC")
    suspend fun getExpense(): List<ExpenseEntity>
    @Query("SELECT * FROM expenseentity WHERE title LIKE '%' || :query || '%' ORDER BY date DESC")
    suspend fun searchExpense(query: String): List<ExpenseEntity>
    @Query("SELECT SUM(amount) FROM expenseentity")
    suspend fun getTotalExpense(): Double?
    @Delete
    suspend fun deleteExpense(expense: ExpenseEntity)

}