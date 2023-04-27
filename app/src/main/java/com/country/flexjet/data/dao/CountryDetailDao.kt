package ro.alexmamo.roomjetpackcompose.data.dao


import androidx.room.*
import com.country.flexjet.core.Constants.Companion.COUNTRY_DETAILS_TABLE
import ro.alexmamo.roomjetpackcompose.domain.model.CountryDetail

@Dao
interface CountryDetailDao {
    @Query("SELECT * FROM $COUNTRY_DETAILS_TABLE WHERE countryName = :countryName")
    suspend fun getCountryDetail(countryName: String): CountryDetail

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addCountryDetail(book: CountryDetail)

}