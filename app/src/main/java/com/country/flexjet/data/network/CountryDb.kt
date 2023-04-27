package ro.alexmamo.roomjetpackcompose.data.network

import androidx.room.Database
import androidx.room.RoomDatabase
import ro.alexmamo.roomjetpackcompose.data.dao.CountryDetailDao
import ro.alexmamo.roomjetpackcompose.domain.model.CountryDetail


@Database(
    entities = [CountryDetail::class],
    version = 1,
    exportSchema = false
)

abstract class CountryDb : RoomDatabase() {
    abstract val countryDetailDao: CountryDetailDao
}