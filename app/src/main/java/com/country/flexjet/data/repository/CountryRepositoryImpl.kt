package ro.alexmamo.roomjetpackcompose.data.repository


import ro.alexmamo.roomjetpackcompose.data.dao.CountryDetailDao
import ro.alexmamo.roomjetpackcompose.domain.model.CountryDetail
import ro.alexmamo.roomjetpackcompose.domain.repository.CountryDetailRepository

class CountryRepositoryImpl(
    private val countryDetailDao: CountryDetailDao
) : CountryDetailRepository {

    override suspend fun getCountryDetailFromRoom(countryName: String) = countryDetailDao.getCountryDetail(countryName)

    override suspend fun addCountryDetailToRoom(countryDetail: CountryDetail) = countryDetailDao.addCountryDetail(countryDetail)

}