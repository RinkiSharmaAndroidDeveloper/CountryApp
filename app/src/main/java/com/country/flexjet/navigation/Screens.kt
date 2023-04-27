package com.country.flexjet.navigation

import com.country.flexjet.core.Constants.Companion.COUNTRY_DETAILS_SCREEN
import com.country.flexjet.core.Constants.Companion.COUNTRY_LIST_SCREEN

sealed class Screens(val route: String) {
    object CountryListSecreen: Screens(COUNTRY_LIST_SCREEN)
    object CountryDetailScreen: Screens(COUNTRY_DETAILS_SCREEN)
}