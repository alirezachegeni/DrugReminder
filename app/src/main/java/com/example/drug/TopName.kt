package com.example.drug

import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.drug.ui.theme.Green100

@Composable
fun TopName(){
    Column {
        Spacer(modifier = Modifier.height(20.dp))
        Icon(
            imageVector = Icons.Default.ArrowBack,
            contentDescription = "",
            modifier = Modifier.padding(start = 25.dp)
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "Dimedrol",
            color = Green100,
            style = MaterialTheme.typography.body2,
            fontSize = 25.sp,
            modifier = Modifier.padding(start = 25.dp)
        )
        Box(Modifier.fillMaxWidth(),contentAlignment = Alignment.Center) {
            Divider(modifier = Modifier.height(2.dp).fillMaxWidth(.87f))
        }

    }
}