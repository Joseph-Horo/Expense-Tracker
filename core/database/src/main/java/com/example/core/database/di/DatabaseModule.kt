package com.example.core.database.di

import android.app.Application
import androidx.room.Room
import com.example.core.database.ExpenseTrackerDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
@Provides
@Singleton
fun provideExpenseTrackerDatabase(app: Application): ExpenseTrackerDatabase{
    return Room.databaseBuilder(app, ExpenseTrackerDatabase::class.java, "expense")
        .build()


}

}