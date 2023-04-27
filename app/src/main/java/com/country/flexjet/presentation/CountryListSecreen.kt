package com.country.flexjet.presentation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.Text
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.country.flexjet.R
import com.country.flexjet.presentation.components.SearchView
import com.country.flexjet.presentation.viewmodels.CountryListViewModel
import java.util.Locale


@Composable
fun CountryListScreen(
    viewModel: CountryListViewModel = hiltViewModel(),
    navigateToDetailScreen: (countryName: String) -> Unit
) {

    var countries = stringArrayResource(R.array.countries_array)
    var filteredCountries: List<String>
    Column {
        val textState = remember { mutableStateOf(TextFieldValue("")) }
        SearchView(textState)

        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            //performing the search functionality here
            val searchedText = textState.value.text
            filteredCountries = if (searchedText.isEmpty()) {
                countries.toList()
            } else {
                val resultList = ArrayList<String>()
                for (country in countries) {
                    if (country.lowercase(Locale.getDefault())
                            .contains(searchedText.lowercase(Locale.getDefault()))
                    ) {
                        resultList.add(country)
                    }
                }
                resultList
            }
            // Moving to the detail screen
            items(filteredCountries) { country ->
                CountryListItem(country) { navigateToDetailScreen(country) }
            }
        }
    }
}

@Composable
fun CountryListItem(country: String, onItemClick: () -> Unit) {
    Card(
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 8.dp)
            .fillMaxWidth()
            .clickable(onClick = onItemClick),
        shape = RoundedCornerShape(corner = CornerSize(8.dp))
    ) {
        Row {

            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
                    .align(Alignment.CenterVertically)
            ) {
                Text(text = country, style = typography.caption)
            }
        }
    }
}

