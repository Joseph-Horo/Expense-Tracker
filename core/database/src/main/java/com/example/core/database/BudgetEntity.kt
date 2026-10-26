package com.example.core.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class BudgetEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val category: String,
    val amount: Double
)
