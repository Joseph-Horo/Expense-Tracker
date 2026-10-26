package com.example.income.data.di

import com.example.income.data.repository.IncomeRepositoryImpl
import com.example.income.domain.repository.IncomeRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class IncomeRepositoryModule {

    @Binds
    @Singleton
    abstract fun bindIncomeRepository(
        incomeRepositoryImpl: IncomeRepositoryImpl
    ): IncomeRepository
}