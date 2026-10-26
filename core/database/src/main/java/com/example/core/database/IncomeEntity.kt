package com.example.core.database

import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity
data class IncomeEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val amount: Double,
    val date: Long
)
