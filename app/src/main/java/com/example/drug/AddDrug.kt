package com.example.drug

import android.content.Context
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.drug.ui.theme.Green100
import com.google.accompanist.pager.ExperimentalPagerApi

@ExperimentalPagerApi
@Composable
fun AddDrug(context: Context) {
    Column {


        TopName()
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(4.dp),
        ) {
            item {
                Spacer(modifier = Modifier.height(15.dp))
                CardTop(context = context)
                Spacer(modifier = Modifier.height(15.dp))
                CardFoodPill()
                Spacer(modifier = Modifier.height(15.dp))
                CardDown()
                Spacer(modifier = Modifier.height(10.dp))
            }
        }


    }
}