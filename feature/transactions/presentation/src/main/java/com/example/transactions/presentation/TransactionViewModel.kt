package com.example.transactions.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.transactions.domain.model.Expense
import com.example.transactions.domain.repository.TransactionRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.time.Duration.Companion.milliseconds

@HiltViewModel
class TransactionViewModel @Inject constructor(
    private val repository: TransactionRepository
): ViewModel(){
    var state by mutableStateOf(TransactionState())
        private set

    private var searchJob: Job? = null
    init {
        viewModelScope.launch {
            getExpense()
        }

    }
    fun onEvent(event: TransactionEvent){
        when(event){
            is TransactionEvent.OnSearchQueryChange -> {
                state = state.copy(
                    searchQuery = event.query
                )

                searchJob?.cancel()
                searchJob = viewModelScope.launch {
                    delay(500.milliseconds)
                    getExpense()
                }

            }
        }

    }
    private suspend fun getExpense(
        query: String = state.searchQuery,
        showLoading: Boolean = true
    ){
        if (showLoading){
            state = state.copy(
                isLoading = true
            )
        }
        val expense = repository.searchExpense(query)
        state = state.copy(
            expense = expense,
            isLoading = false
        )

    }

    fun addExpense(
        expense: Expense,
        onAddExpense: () -> Unit
        ){
        viewModelScope.launch {
            repository.addExpense(expense)
            getExpense(showLoading = false)
            onAddExpense()
        }

    }
    fun deleteExpense(
        expense: Expense
    ){
        viewModelScope.launch {
            repository.deleteExpense(expense)
            getExpense(showLoading = false)
        }

    }
    fun refreshExpenses(){
        viewModelScope.launch {
            getExpense()
        }
    }
}