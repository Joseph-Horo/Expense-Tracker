package com.example.expensetracker.navigation

import androidx.compose.ui.graphics.vector.ImageVector

data class BottomNavigationItem(
    val name: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val route: String
)
