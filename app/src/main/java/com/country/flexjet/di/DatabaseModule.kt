package com.country.flexjet.di

import android.content.Context
import androidx.room.Room
import com.country.flexjet.core.Constants.Companion.COUNTRY_DETAILS_TABLE
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import ro.alexmamo.roomjetpackcompose.data.dao.CountryDetailDao
import ro.alexmamo.roomjetpackcompose.data.network.CountryDb
import ro.alexmamo.roomjetpackcompose.data.repository.CountryRepositoryImpl
import ro.alexmamo.roomjetpackcompose.domain.repository.CountryDetailRepository


@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {
    @Provides
    fun provideCountryDb(
        @ApplicationContext
        context: Context
    ) = Room.databaseBuilder(
        context,
        CountryDb::class.java,
        COUNTRY_DETAILS_TABLE
    ).build()

    @Provides
    fun provideBookDao(
        countryDb: CountryDb
    ) = countryDb.countryDetailDao

    @Provides
    fun provideBookRepository(
        countryDetailDao: CountryDetailDao
    ): CountryDetailRepository = CountryRepositoryImpl(
        countryDetailDao = countryDetailDao
    )


}