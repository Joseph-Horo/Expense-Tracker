package com.example.core.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface IncomeDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertIncome(income: IncomeEntity)
    @Query("SELECT * FROM incomeentity ORDER BY date DESC")
    suspend fun getIncome(): List<IncomeEntity>
    @Query("SELECT SUM(amount) FROM incomeentity")
    suspend fun getTotalIncome(): Double?
    @Delete
    suspend fun deleteIncome(income: IncomeEntity)
}