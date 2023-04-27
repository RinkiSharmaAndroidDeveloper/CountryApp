package com.image.reachmobitsports.di.api

import com.country.flexjet.core.Constants
import com.country.flexjet.data.response.CountryDetailResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path


interface Api {

    @GET(Constants.GET_COUNTRY_DETAILS)
    suspend fun getCountry(@Path("country") country: String): Response<CountryDetailResponse>

}