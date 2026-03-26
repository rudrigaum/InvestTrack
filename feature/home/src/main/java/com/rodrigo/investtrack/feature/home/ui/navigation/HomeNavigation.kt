package com.rodrigo.investtrack.feature.home.ui.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.rodrigo.investtrack.feature.home.ui.HomeScreen

const val HOME_ROUTE = "home"

fun NavController.navigateToHome(navOptions: NavOptions? = null) {
    navigate(HOME_ROUTE, navOptions)
}

fun NavGraphBuilder.homeScreen(onNavigateToDetail: (String) -> Unit) {
    composable(route = HOME_ROUTE) {
        HomeScreen(onNavigateToDetail = onNavigateToDetail)
    }
}
