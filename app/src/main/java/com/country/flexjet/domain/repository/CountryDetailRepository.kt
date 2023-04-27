package ro.alexmamo.roomjetpackcompose.domain.repository

import ro.alexmamo.roomjetpackcompose.domain.model.CountryDetail


interface CountryDetailRepository {

    suspend fun getCountryDetailFromRoom(countryName: String): CountryDetail

    suspend fun addCountryDetailToRoom(countryDetail: CountryDetail)

}