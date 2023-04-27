package com.country.flexjet.core

import com.country.flexjet.presentation.CountryDetailScreen

class Constants {
    companion object {
        //Room
        const val COUNTRY_DETAILS_TABLE = "country_detail_table"

        //Screens
        const val COUNTRY_LIST_SCREEN = "Country list"
        const val COUNTRY_DETAILS_SCREEN = "Country detail"
        const val GET_COUNTRY_DETAILS = "name/{country}"

        //Arguments
        const val COUNTRY_NAME = "countryName"

        //Title
        const val CAPITAL = "Capital"
        const val POPULATION = "Population"
        const val AREA = "Area"
        const val REGION = "Region"
        const val SUBREGION = "SubRegion"
    }
}