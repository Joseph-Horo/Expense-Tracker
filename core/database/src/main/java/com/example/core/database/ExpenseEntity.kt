package com.example.core.database

import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity
data class ExpenseEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val title: String,
    val category: String,
    val amount: Double,
    val date: Long
)

