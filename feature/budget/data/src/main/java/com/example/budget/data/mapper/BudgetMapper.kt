package com.example.budget.data.mapper

import com.example.budget.domain.model.Budget
import com.example.core.database.BudgetEntity

fun Budget.toBudgetEntity(): BudgetEntity {
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