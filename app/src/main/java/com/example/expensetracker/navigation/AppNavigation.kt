package com.example.expensetracker.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.example.core.ui.icons.AccountBalanceFill
import com.example.core.ui.icons.AccountBalanceOut
import com.example.core.ui.icons.HomeFill
import com.example.core.ui.icons.HomeOut
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.auth.login.LoginScreen
import com.example.auth.signup.SignUpScreen
import com.example.budget.presentation.BudgetScreen
import com.example.budget.presentation.AddBudgetScreen
import com.example.budget.presentation.AddBudgetTopBar
import com.example.budget.presentation.BudgetTopBar
import com.example.core.ui.icons.BarChart
import com.example.core.ui.icons.PersonFill
import com.example.core.ui.icons.PersonOut
import com.example.core.ui.icons.Swap
import com.example.home.presentation.HomeScreen
import com.example.home.presentation.HomeTopBar
import com.example.income.presentation.AddIncomeScreen
import com.example.income.presentation.AddIncomeTopBar
import com.example.income.presentation.IncomeScreen
import com.example.income.presentation.IncomeTopBar
import com.example.profile.presentation.ProfileScreen
import com.example.transactions.presentation.AddExpenseScreen
import com.example.transactions.presentation.AddExpenseTopBar
import com.example.transactions.presentation.TransactionScreen
import com.google.firebase.auth.FirebaseAuth


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppNavigation() {
    val navController = rememberNavController()


  val navBackStackEntry by navController.currentBackStackEntryAsState()

   val currentRoute = navBackStackEntry?.destination?.route

   val showBottomBar = currentRoute in listOf(
       "home",
       "transactions",
       "budget",
       "profile",
       "income"
   )
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()

    val items = listOf(
        BottomNavigationItem(
            name = "Home",
            selectedIcon = HomeFill,
            unselectedIcon = HomeOut,
            route = "home"
        ),
        BottomNavigationItem(
            name = "Transactions",
            selectedIcon = Swap,
            unselectedIcon = Swap,
            route = "transactions"
        ),
        BottomNavigationItem(
            name = "Budget",
            selectedIcon = BarChart,
            unselectedIcon = BarChart,
            route = "budget"
        ),
        BottomNavigationItem(
            name = "Profile",
            selectedIcon = PersonFill,
            unselectedIcon = PersonOut,
            route = "profile"
        ),
        BottomNavigationItem(
            name = "Income",
            selectedIcon = AccountBalanceFill,
            unselectedIcon = AccountBalanceOut,
            route = "income"
        ),
    )

    Scaffold(
        modifier = Modifier.fillMaxSize()
            .nestedScroll(scrollBehavior.nestedScrollConnection),


        topBar = {
         when(currentRoute){
            "home" -> HomeTopBar(scrollBehavior)
             "budget" -> BudgetTopBar(scrollBehavior)
             "addBudget" -> AddBudgetTopBar(scrollBehavior)
             "addExpense" -> AddExpenseTopBar(scrollBehavior)
             "income" -> IncomeTopBar(scrollBehavior)
             "addIncome" -> AddIncomeTopBar(scrollBehavior)
             else -> Unit

         }
        },

    ) {innerPadding->
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            NavHost(
                navController = navController,
                startDestination = if (FirebaseAuth.getInstance().currentUser != null) {
                    "home"
                } else {
                    "login"
                },
                modifier = Modifier.padding(innerPadding)
            ) {
                composable("signup") {
                    SignUpScreen(navController = navController)
                }
                composable("home") {
                    HomeScreen(navController = navController)
                }
                composable("transactions") {
                    TransactionScreen(navController = navController)
                }
                composable("budget") {
                    BudgetScreen(navController = navController)
                }
                composable("login") {
                    LoginScreen(navController = navController)
                }
                composable("income") {
                    IncomeScreen(navController = navController)
                }
                composable("profile") {
                    ProfileScreen(navController = navController)
                }
                composable("addIncome") {
                    AddIncomeScreen(
                        onAddIncome = {
                            navController.popBackStack()
                        }
                    )
                }
                composable("addBudget") {
                    AddBudgetScreen(
                        onAddBudget = {
                            navController.popBackStack()
                        }
                    )
                }
                composable("addExpense") {
                    AddExpenseScreen(
                        onAddExpense = {
                            navController.popBackStack()
                        }
                    )

                }


            }
            if (showBottomBar) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.BottomCenter)
                        .padding(bottom = 50.dp),
                    contentAlignment = Alignment.Center
                ) {

                    FloatingBottomBar(navController = navController)

                }
            }
        }
    }
}