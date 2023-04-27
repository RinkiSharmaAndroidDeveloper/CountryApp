package com.country.flexjet.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

// Content of the screen here
@Composable
fun TextViewDetails(heading: String, countryDetail: String) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = heading, fontWeight = FontWeight.Bold, modifier = Modifier.padding(start = 16.dp, end = 16.dp))
        Text(
            text = countryDetail,
            modifier = Modifier.padding(start = 16.dp, end = 16.dp)
        )

        }
    }

