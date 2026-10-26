package com.example.transactions.presentation

sealed class TransactionEvent {

    data class OnSearchQueryChange(val query: String): TransactionEvent()
}