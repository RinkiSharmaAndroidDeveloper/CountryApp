package com.country.flexjet.data.repository

import com.country.flexjet.core.Resource
import com.country.flexjet.data.response.toCountryDetail
import com.country.flexjet.domain.repository.CountryDetailRepsitoryApi
import com.image.reachmobitsports.di.api.Api
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import ro.alexmamo.roomjetpackcompose.domain.model.CountryDetail
import javax.inject.Inject

class NetworkRepository @Inject constructor(private val api: Api) : CountryDetailRepsitoryApi {

    override suspend fun getCountryDetail(countryName:String): Resource<CountryDetail> {
        return try {
            withContext(Dispatchers.IO) {
                Resource.Loading(
                    loadingStatus = true,
                    data = null
                )
                Resource.Success(
                    data = api.getCountry(countryName).body()?.map{
                        it.toCountryDetail()
                    } ?.firstOrNull()
                )
            }
        } catch (e: Exception) {
            e.printStackTrace()
            withContext(Dispatchers.IO) {
                Resource.Failure(
                    e.localizedMessage ?: "An unknown error occurred"
                )
            }
        }
    }

}