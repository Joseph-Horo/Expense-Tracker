package com.example.budget.presentation

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.budget.domain.model.Budget

@Composable
fun AddBudgetScreen(
    onAddBudget: () -> Unit,
    viewModel: BudgetViewModel = hiltViewModel()
) {

    var category by remember {
        mutableStateOf("")
    }
    var amount by remember {
        mutableStateOf("")
    }
val context = LocalContext.current
    Column(
        modifier = Modifier.fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        OutlinedTextField(
            value = category,
            onValueChange = {
                category = it
            },
            label = {
                Text("Category")
            },
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = amount,
            onValueChange = {
                amount = it
            },
            label = {
                Text("Amount")
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Decimal
            ),
            modifier = Modifier.fillMaxWidth()
        )

        Button(
            onClick = {
                if (amount.isBlank() || category.isBlank()){
                    Toast.makeText(context, "Please fill all fields", Toast.LENGTH_SHORT).show()
               return@Button
                }
                viewModel.addBudget(
                    Budget(
                        id = 0,
                        category = category,
                        amount = amount.toDoubleOrNull() ?: 0.0
                    ),
                    onAddBudget = onAddBudget
                )
            },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFC4B5FD))

        ) {

            Text("Add Budget",
                color = Color.White
            )
        }


    }

}