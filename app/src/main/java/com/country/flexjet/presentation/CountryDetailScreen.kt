package com.country.flexjet.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.country.flexjet.core.Constants
import com.country.flexjet.presentation.components.CountryDetailTopBar
import com.country.flexjet.presentation.components.TextViewDetails
import com.country.flexjet.presentation.viewmodels.CountryDetailViewModel

@Composable
fun CountryDetailScreen(
    viewModel: CountryDetailViewModel = hiltViewModel(),
    countryName: String,
    navigateBack: () -> Unit
) {
    viewModel.getCountryDetail(countryName)
    val myLiveData = viewModel.countryDetailLive.observeAsState()
    
    Scaffold(
        topBar = {
            CountryDetailTopBar(
                navigateBack = navigateBack
            )
        }
    ) { it

        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = countryName,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                fontSize = 20.sp,
                modifier = Modifier.padding(16.dp)
            )
            myLiveData.value?.countryDetail?.capital?.let { capital ->
                TextViewDetails(Constants.CAPITAL,
                    capital
                )
            }
            myLiveData.value?.countryDetail?.population?.let { population ->
                TextViewDetails(Constants.POPULATION,
                    population.toString()
                )
            }
            myLiveData.value?.countryDetail?.area?.let { area ->
                TextViewDetails(Constants.AREA,
                    area.toString()
                )
            }
            myLiveData.value?.countryDetail?.region?.let { region ->
                TextViewDetails(Constants.REGION,
                    region
                )
            }
            myLiveData.value?.countryDetail?.subRegion?.let { subRegion ->
                TextViewDetails(Constants.SUBREGION,
                    subRegion
                )
            }
        }
    }

}
