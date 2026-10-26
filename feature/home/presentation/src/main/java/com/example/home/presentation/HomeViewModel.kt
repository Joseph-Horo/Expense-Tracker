package com.example.home.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.home.domain.repository.HomeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: HomeRepository
): ViewModel() {

var state by mutableStateOf(HomeState())

    init {
        viewModelScope.launch {
            state = state.copy(
                isLoading = true
            )

            val expense = repository.getExpenses()
            val totalExpense = repository.getTotalExpense()
            val totalIncome = repository.getTotalIncome()
            val budgets = repository.getBudgets()

            state = state.copy(
                expense = expense
                    .take(5),
                totalExpense = totalExpense,
                totalIncome = totalIncome,
                budgets = budgets,
                isLoading = false
            )
        }

    }


}