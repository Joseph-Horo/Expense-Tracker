package com.example.transactions.data.mapper

import com.example.core.database.ExpenseEntity
import com.example.transactions.domain.model.Expense

fun Expense.toExpenseEntity(): ExpenseEntity {
    return ExpenseEntity(
        title = title,
        date = date,
        category = category,
        amount = amount,
        id = id
    )
}
fun ExpenseEntity.toExpense(): Expense{
    return Expense(
        title = title,
        date = date,
        category = category,
        amount = amount,
        id = id
    )
}