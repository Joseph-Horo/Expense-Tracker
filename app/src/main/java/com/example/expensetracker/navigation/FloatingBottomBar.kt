package com.example.expensetracker.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.core.ui.icons.AccountBalanceFill
import com.example.core.ui.icons.AccountBalanceOut
import com.example.core.ui.icons.BarChart
import com.example.core.ui.icons.HomeFill
import com.example.core.ui.icons.HomeOut
import com.example.core.ui.icons.PersonFill
import com.example.core.ui.icons.PersonOut
import com.example.core.ui.icons.Swap

@Composable
fun FloatingBottomBar(navController: NavController) {


    val navBackStackEntry by navController.currentBackStackEntryAsState()

    val currentRoute = navBackStackEntry?.destination?.route
    Row(
        modifier = Modifier.fillMaxWidth()
            .padding(horizontal = 24.dp)
            .padding(bottom = 16.dp, top = 8.dp)
            .height(56.dp)
            .clip(RoundedCornerShape(60.dp))
            .height(56.dp)
            .background(Color(0xFFE9E3FF)),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly

    ) {
        IconButton(
            onClick = {
                navController.navigate("home")
            }
        ) {
            Icon(
                imageVector = if (currentRoute == "home") {
                    HomeFill
                } else {
                    HomeOut
                }, contentDescription = "home"
            )

        }
        IconButton(
            onClick = {
                navController.navigate("transactions")
            }
        ) {
            Icon(
                imageVector = Swap, contentDescription = "transactions"
            )

        }
        IconButton(
            onClick = {
                navController.navigate("budget")
            }
        ) {
            Icon(
                imageVector = BarChart, contentDescription = "home"
            )

        }
        IconButton(
            onClick = {
                navController.navigate("income")
            }
        ) {
            Icon(
                imageVector = if (currentRoute == "income") {
                    AccountBalanceFill
                } else {
                    AccountBalanceOut
                }, contentDescription = "Income"
            )

        }
        IconButton(
            onClick = {
                navController.navigate("profile")
            }
        ) {
            Icon(
                imageVector = if (currentRoute == "profile") {
                    PersonFill
                } else {
                    PersonOut
                }, contentDescription = "Profile"
            )

        }


    }
}