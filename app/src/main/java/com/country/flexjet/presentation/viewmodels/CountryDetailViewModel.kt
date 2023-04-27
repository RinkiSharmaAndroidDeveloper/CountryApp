package com.country.flexjet.presentation.viewmodels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.country.flexjet.core.Resource
import com.country.flexjet.domain.model.CountryDetailState
import com.country.flexjet.domain.repository.CountryDetailRepsitoryApi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import ro.alexmamo.roomjetpackcompose.domain.repository.CountryDetailRepository
import javax.inject.Inject

@HiltViewModel
class CountryDetailViewModel @Inject constructor(
    private val countryDetailRepsitoryApi: CountryDetailRepsitoryApi,
    private val countryDetailRepository: CountryDetailRepository
) : ViewModel() {
    private var _countryDetailMutable: MutableLiveData<CountryDetailState> = MutableLiveData()
    val countryDetailLive: MutableLiveData<CountryDetailState> get() = _countryDetailMutable

    fun getCountryDetail(countryName: String) {
        viewModelScope.launch(Dispatchers.IO) {

            // Check if country detail is present in local database
            var countryDetail = countryDetailRepository.getCountryDetailFromRoom(countryName)
            if (countryDetail != null) {
                // Country detail is present in local database, return it
                _countryDetailMutable.postValue(CountryDetailState(
                    countryDetail = countryDetail,
                    isLoading = false,
                    error = null
                ))
            } else {
                // Country detail is not present in local database, make network call
                when (val result = countryDetailRepsitoryApi.getCountryDetail(countryName)) {
                    is Resource.Loading -> {
                        _countryDetailMutable.postValue(CountryDetailState(
                            countryDetail = null,
                            isLoading = result.loadingStatus,
                            error = result.message
                        ))
                    }

                    is Resource.Success -> {
                        result.data?.let {
                            // Save country detail to local database
                            countryDetailRepository.addCountryDetailToRoom(it)

                            // Return country detail
                            _countryDetailMutable.postValue(CountryDetailState(
                                countryDetail = it,
                                isLoading = result.loadingStatus,
                                error = result.message
                            ))
                        }
                    }

                    is Resource.Failure -> {
                        _countryDetailMutable.postValue(CountryDetailState(
                            countryDetail = null,
                            isLoading = result.loadingStatus,
                            error = result.message
                        ))
                        Log.e("Error", result.message ?: "Unknown error")
                    }
                }
            }
        }
    }

}