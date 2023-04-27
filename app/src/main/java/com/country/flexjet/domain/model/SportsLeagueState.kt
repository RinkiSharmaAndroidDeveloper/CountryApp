package com.country.flexjet.domain.model

import ro.alexmamo.roomjetpackcompose.domain.model.CountryDetail

data class CountryDetailState(
    val countryDetail: CountryDetail? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)