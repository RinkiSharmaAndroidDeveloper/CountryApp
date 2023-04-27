package com.country.flexjet.domain.repository

import com.country.flexjet.core.Resource
import ro.alexmamo.roomjetpackcompose.domain.model.CountryDetail


interface CountryDetailRepsitoryApi {

    suspend fun getCountryDetail(countryName: String): Resource<CountryDetail>
}