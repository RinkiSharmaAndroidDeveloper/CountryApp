package com.country.flexjet.navigation

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.country.flexjet.core.Constants.Companion.COUNTRY_NAME
import com.country.flexjet.navigation.Screens.CountryDetailScreen
import com.country.flexjet.navigation.Screens.CountryListSecreen
import com.country.flexjet.presentation.CountryDetailScreen
import com.country.flexjet.presentation.CountryListScreen

@Composable
@ExperimentalMaterialApi
fun NavGraph (
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = CountryListSecreen.route
    ) {
        composable(
            route = CountryListSecreen.route
        ) {
            CountryListScreen(
                navigateToDetailScreen = { countryName ->
                    navController.navigate(
                        route = "${CountryDetailScreen.route}/${countryName}"
                    )
                }
            )
        }
        composable(
            route = "${CountryDetailScreen.route}/{$COUNTRY_NAME}",
            arguments = listOf(
                navArgument(COUNTRY_NAME) {
                    type = NavType.StringType
                }
            )
        ) { backStackEntry ->
            val countryName = backStackEntry.arguments?.getString(COUNTRY_NAME) ?: null
            if (countryName != null) {
                CountryDetailScreen(
                    countryName = countryName,
                    navigateBack = {
                        navController.popBackStack()
                    }
                )
            }
        }
    }
}