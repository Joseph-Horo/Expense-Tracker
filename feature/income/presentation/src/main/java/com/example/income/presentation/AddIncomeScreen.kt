package com.example.income.presentation

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import com.example.income.domain.model.Income

@Composable
fun AddIncomeScreen(
    onAddIncome: () -> Unit,
    viewModel: IncomeViewModel = hiltViewModel()
) {
    var amount by remember { mutableStateOf("") }

    val context = LocalContext.current
    Column(
        modifier = Modifier.fillMaxSize()
            .padding(16.dp)
    ) {
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
        Spacer(modifier = Modifier.height(12.dp))
        Button(
            onClick = {
                if (amount.isBlank()){
                Toast.makeText(context, "Amount is required", Toast.LENGTH_SHORT).show()
                return@Button
                }
                viewModel.addIncome(
                    Income(
                        id = 0,
                        amount = amount.toDoubleOrNull() ?: 0.0,
                        date = System.currentTimeMillis()
                    ),
                    onAddIncome = onAddIncome
                )
            },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFC4B5FD))
        ) {
            Text("Add Income",
                color = Color.White
            )
        }
    }

}