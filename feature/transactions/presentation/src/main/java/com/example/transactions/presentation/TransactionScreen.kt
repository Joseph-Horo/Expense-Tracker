package com.example.transactions.presentation

import android.text.Layout
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.compose.LifecycleEventEffect
import androidx.navigation.NavController

@Composable
fun TransactionScreen(
    navController: NavController,
    viewModel: TransactionViewModel = hiltViewModel()
) {
    val state = viewModel.state
    LifecycleEventEffect(Lifecycle.Event.ON_RESUME) {
        viewModel.refreshExpenses()
    }

    Box(modifier = Modifier.fillMaxSize()){
        Column(modifier = Modifier.fillMaxSize()
            .padding(12.dp)) {

            BasicTextField(
                value = state.searchQuery,
                onValueChange = {
                    viewModel.onEvent(TransactionEvent.OnSearchQueryChange(it))
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .size(70.dp)
                    .padding(10.dp)
                    .clip(RoundedCornerShape(30.dp))
                    .background(Color(0xFFF1F5F9)),
                textStyle = TextStyle(fontSize = 24.sp),
                decorationBox = { innerTextField ->

                    Box(
                        modifier = Modifier.padding(horizontal = 16.dp),
                        contentAlignment = Alignment.CenterStart

                    ) {
                        if (state.searchQuery.isBlank()){
                           Text("Search ...")
                        }
                        innerTextField()
                    }


                }
            )
            Spacer(modifier = Modifier.height(12.dp))
            LazyColumn() {
                items(state.expense){expense->
                    TransactionItem(
                        expense = expense,
                        onDelete = {
                            viewModel.deleteExpense(expense)
                        }
                    )
                }
            }

            }

        FloatingActionButton(
            onClick = {
                navController.navigate("addExpense")
            },
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(bottom = 80.dp, end = 20.dp),
            containerColor = Color(0xFFF1F5F9)
        ) {
            Icon(imageVector = Icons.Default.Add, contentDescription = "onAddExpense")

        }


    }

}