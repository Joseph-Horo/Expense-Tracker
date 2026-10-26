package com.example.home.data.mapper

import com.example.core.database.BudgetEntity
import com.example.core.database.ExpenseEntity
import com.example.core.database.IncomeEntity
import com.example.home.domain.model.Budget
import com.example.home.domain.model.Expense
import com.example.home.domain.model.Income

fun Budget.toBudgetEntity(): BudgetEntity{
    return BudgetEntity(
        category = category,
        amount = amount,
        id = id

    )
}
fun BudgetEntity.toBudget(): Budget{
    return Budget(

        category = category,
        amount = amount,
        id = id
    )
}
fun Income.toIncomeEntity(): IncomeEntity{
    return IncomeEntity(
        amount = amount,
        date = date,
        id = id

    )
}
fun IncomeEntity.toIncome(): Income{
    return Income(
        amount = amount,
        date = date,
        id = id

    )
}
fun Expense.toExpenseEntity(): ExpenseEntity{
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
