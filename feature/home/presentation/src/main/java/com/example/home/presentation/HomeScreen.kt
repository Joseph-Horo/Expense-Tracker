package com.example.home.presentation
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel(),
    navController: NavController) {

     val state = viewModel.state

    LazyColumn(
        modifier = Modifier.fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        item {
            TotalBalanceCard(
                totalBalance = state.totalIncome - state.totalExpense
            )
        }
        item {
            Row(
                modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                IncomeExpenseCard(
                    title = "Income",
                    amount = state.totalIncome
                )
                IncomeExpenseCard(
                    title = "Expense",
                    amount = state.totalExpense
                )
            }
        }
        item {
            Card(
                modifier = Modifier.fillMaxWidth(),
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
                colors = CardDefaults.cardColors(containerColor = Color(0xFFF1F5F9))
            ) {
                Column(
                    modifier = Modifier.padding(16.dp)
                ){


                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Text(
                            "Recent Transactions",
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp
                        )
                        TextButton(
                            onClick = {
                                navController.navigate("transactions")
                            }
                        ) {
                            Text(
                                "See all >",
                                color = Color.Blue,
                                fontSize = 16.sp
                            )
                        }


                    }
                }

                state.expense.forEach { expense ->
                    TransactionItem(
                        expense = expense
                    )

                }
            }
        }
        item {
            BudgetCard(
                budget = state.budgets.sumOf { it.amount },
                totalExpense = state.totalExpense
            )
        }

    }
}