package com.example.income.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.income.domain.model.Income
import com.example.income.domain.repository.IncomeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class IncomeViewModel @Inject constructor(
    private val repository: IncomeRepository
): ViewModel() {
    var state by mutableStateOf(IncomeState())

    init {
        viewModelScope.launch {
            getIncome()
            getTotalIncome()
        }
    }

    private suspend fun getIncome(showLoading: Boolean = true){

        if (showLoading){
            state = state.copy(
                isLoading = true
            )
        }
        val income = repository.getIncome()
        state = state.copy(
            income = income,
            isLoading = false
        )
    }
    private suspend fun getTotalIncome(){
        state = state.copy(
            isLoading = true
        )
        val totalIncome = repository.getTotalIncome()
        state = state.copy(
            totalIncome = totalIncome,
            isLoading = false
        )
    }

    fun addIncome(
        income: Income,
        onAddIncome: () -> Unit
    ){
        viewModelScope.launch {
            repository.addIncome(income)
            getIncome(showLoading = false)
            onAddIncome()
        }
    }
    fun deleteIncome(
        income: Income
    ){
        viewModelScope.launch {
            repository.deleteIncome(income)
            getIncome(showLoading = false)

        }
    }
    fun refreshIncome(){
        viewModelScope.launch {
            getIncome(showLoading = false)
        }
    }
}