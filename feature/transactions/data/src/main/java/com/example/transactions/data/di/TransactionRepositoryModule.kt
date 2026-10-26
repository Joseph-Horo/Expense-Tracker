package com.example.transactions.data.di

import com.example.transactions.data.repository.TransactionRepositoryImpl
import com.example.transactions.domain.repository.TransactionRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class TransactionRepositoryModule {

    @Binds
    @Singleton

    abstract fun bindTransactionRepository(
        transactionRepositoryImpl: TransactionRepositoryImpl
    ): TransactionRepository
}