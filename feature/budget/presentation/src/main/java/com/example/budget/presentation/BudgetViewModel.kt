package com.example.budget.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.budget.domain.model.Budget
import com.example.budget.domain.repository.BudgetRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BudgetViewModel @Inject constructor(
    private val repository: BudgetRepository
): ViewModel(){
    var state by mutableStateOf(BudgetState())

    init {
        viewModelScope.launch {
            getBudgets()
        }

    }

    private suspend fun getBudgets(showLoading: Boolean = true){
        if (showLoading){
            state = state.copy(
                isLoading = true
            )
        }

        val budgets = repository.getBudgets()
        state = state.copy(
            budgets = budgets,
            isLoading = false
        )
    }
    fun addBudget(
        budget: Budget,
        onAddBudget: () -> Unit

    ){
        viewModelScope.launch {
            repository.addBudget(budget)
            getBudgets(showLoading = false)
            onAddBudget()
        }
    }
    fun deleteBudget(budget: Budget){
        viewModelScope.launch {
            repository.deleteBudget(budget)
            getBudgets(showLoading = false)
        }
    }
    fun refreshBudget(){
        viewModelScope.launch {
            getBudgets()
        }
    }


}