package com.example.income.data.mapper

import com.example.core.database.IncomeEntity
import com.example.income.domain.model.Income

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