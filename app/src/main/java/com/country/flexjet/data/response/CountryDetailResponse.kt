package com.country.flexjet.data.response

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import ro.alexmamo.roomjetpackcompose.domain.model.CountryDetail

class CountryDetailResponse : ArrayList<CountryDetailResponseItem>()

@Parcelize
data class CountryDetailResponseItem(
    val name: Name,
    val area: Double,
    val population: Int,
    val region: String,
    val capital: List<String>? = null,
    val subregion: String? = null,
) : Parcelable

@Parcelize
data class Name(
    val common: String
) : Parcelable

fun CountryDetailResponseItem.toCountryDetail() = CountryDetail(
    countryName = name.common,
    area = area,
    population = population,
    region = region,
    capital = capital?.get(0) ?: "",
    subRegion = subregion ?: "",
)