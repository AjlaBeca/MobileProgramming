package com.example.a22052024.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.a22052024.ui.screen.CreditCard
import com.example.a22052024.ui.screen.CreditCardDestination
import com.example.a22052024.ui.screen.CreditCardScreenWithTopBar
import com.example.a22052024.ui.screen.HomeDestination
import com.example.a22052024.ui.screen.HomeScreen
import com.example.a22052024.ui.screen.HomeScreenWithTopBar

@Composable
fun StudentNavHost(
    navController: NavHostController
) {
    NavHost(navController = navController, startDestination = HomeDestination.route) {
        composable(route = HomeDestination.route) {
            HomeScreenWithTopBar(navigateToCreditCardPage = { navController.navigate("${CreditCardDestination.route}/${it}") })
        }

        /* TODO CREATE A ROUTE WITH CreditCardDestination ROUTE*/
        composable(
            route = CreditCardDestination.routeWithArgs,
            arguments = listOf(navArgument(CreditCardDestination.cardIdArg) {
                type = NavType.IntType
            })
        ) {
            CreditCardScreenWithTopBar(navigateBack = { navController.navigateUp() })
        }
    }
}
