package com.example.drug

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.SnackbarDefaults.backgroundColor
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.outlined.KeyboardArrowDown
import androidx.compose.material.icons.rounded.KeyboardArrowDown
import androidx.compose.material.icons.rounded.KeyboardArrowRight
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.drug.ui.theme.Green100
import com.example.drug.ui.theme.Purple500
import kotlinx.coroutines.NonCancellable.start

@Composable
fun CardDown() {
    Column {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 25.dp, end = 25.dp),
            shape = RoundedCornerShape(20.dp), elevation = 10.dp
        ) {
            Column {


                Spacer(modifier = Modifier.height(9.dp))
                Start()
                Spacer(modifier = Modifier.height(9.dp))
                Days()
                Spacer(modifier = Modifier.height(9.dp))
                Duration()
                Spacer(modifier = Modifier.height(9.dp))
                Alarm()
                Spacer(modifier = Modifier.height(9.dp))
                Snooze()
                Spacer(modifier = Modifier.height(9.dp))

            }

        }
        Spacer(modifier = Modifier.height(15.dp))
        Box(Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .width(250.dp)
                    .height(50.dp),
                shape = RoundedCornerShape(20.dp),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Green100,
                    contentColor = Color.Black
                ),
            ) {
                Box(contentAlignment = Alignment.Center) {
                    Text(
                        text = "Add Schedule",
                        fontSize = 20.sp,
                        style = MaterialTheme.typography.body2
                    )
                }

            }

        }

        Spacer(modifier = Modifier.height(9.dp))

    }
}

@Composable
fun Snooze() {
    val snooze = mutableListOf<String>("1 Min", "2 Min", "3 Min", "4 Min", "5 Min")
    var snoozeName: String by remember { mutableStateOf(snooze[0]) }
    var expanded by remember { mutableStateOf(false) }
    val rotateAsState = animateFloatAsState(targetValue = if (expanded) 90f else 0f)



    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(40.dp)
            .clickable { expanded = !expanded },
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Box(
            Modifier

                .padding(start = 25.dp), contentAlignment = Alignment.CenterStart
        ) {
            Text(text = "Snooze", fontSize = 20.sp, style = MaterialTheme.typography.body2)
        }

        Box(
            Modifier

                .padding(end = 25.dp), contentAlignment = Alignment.CenterEnd
        ) {

            Row(verticalAlignment = Alignment.CenterVertically) {

                Text(
                    text = snoozeName,
                    fontSize = 15.sp,
                    modifier = Modifier.padding(start = 25.dp, end = 5.dp),
                    color = Green100
                )
                Icon(
                    imageVector = Icons.Outlined.KeyboardArrowDown,
                    tint = Color.Gray,
                    contentDescription = "",
                    modifier = Modifier
                        .rotate(rotateAsState.value)
                        .size(30.dp)
                )
                DropdownMenu(expanded = expanded, onDismissRequest = {
                    expanded = false
                }) {
                    snooze.forEach { day ->
                        DropdownMenuItem(onClick = {
                            expanded = false
                            snoozeName = day
                        }) {
                            Text(text = day, color = Color.Black)
                        }
                    }
                }
            }

        }


    }

}


@Composable
fun Duration() {

    val Duration = mutableListOf<String>("1 Month", "2 Month", "2 Weeks", "1 Weeks")
    var DurationName: String by remember { mutableStateOf(Duration[0]) }
    var expanded by remember { mutableStateOf(false) }
    val rotateAsState = animateFloatAsState(targetValue = if (expanded) 90f else 0f)



    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(40.dp)
            .clickable { expanded = !expanded },
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Box(
            Modifier

                .padding(start = 25.dp), contentAlignment = Alignment.CenterStart
        ) {
            Text(text = "Duration", fontSize = 20.sp, style = MaterialTheme.typography.body2)
        }

        Box(
            Modifier

                .padding(end = 25.dp), contentAlignment = Alignment.CenterEnd
        ) {

            Row(verticalAlignment = Alignment.CenterVertically) {

                Text(
                    text = DurationName,
                    fontSize = 15.sp,
                    modifier = Modifier.padding(start = 25.dp, end = 5.dp),
                    color = Green100
                )
                Icon(
                    imageVector = Icons.Outlined.KeyboardArrowDown,
                    tint = Color.Gray,
                    contentDescription = "",
                    modifier = Modifier
                        .rotate(rotateAsState.value)
                        .size(30.dp)
                )
                DropdownMenu(expanded = expanded, onDismissRequest = {
                    expanded = false
                }) {
                    Duration.forEach { day ->
                        DropdownMenuItem(onClick = {
                            expanded = false
                            DurationName = day
                        }) {
                            Text(text = day, color = Color.Black)
                        }
                    }
                }
            }

        }


    }
}

@Composable
fun Days() {

    val days = mutableListOf<String>("Every Day", "Even Days", "Odd Days")
    var dayName: String by remember { mutableStateOf(days[0]) }
    var expanded by remember { mutableStateOf(false) }
    val rotateAsState = animateFloatAsState(targetValue = if (expanded) 90f else 0f)



    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(40.dp)
            .clickable { expanded = !expanded },
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Box(
            Modifier

                .padding(start = 25.dp), contentAlignment = Alignment.CenterStart
        ) {
            Text(text = "Days", fontSize = 20.sp, style = MaterialTheme.typography.body2)
        }

        Box(
            Modifier

                .padding(end = 25.dp), contentAlignment = Alignment.CenterEnd
        ) {

            Row(verticalAlignment = Alignment.CenterVertically) {

                Text(
                    text = dayName,
                    fontSize = 15.sp,
                    modifier = Modifier.padding(start = 25.dp, end = 5.dp),
                    color = Green100
                )
                Icon(
                    imageVector = Icons.Outlined.KeyboardArrowDown,
                    tint = Color.Gray,
                    contentDescription = "",
                    modifier = Modifier
                        .rotate(rotateAsState.value)
                        .size(30.dp)
                )
                DropdownMenu(expanded = expanded, onDismissRequest = {
                    expanded = false
                }) {
                    days.forEach { day ->
                        DropdownMenuItem(onClick = {
                            expanded = false
                            dayName = day
                        }) {
                            Text(text = day, color = Color.Black)
                        }
                    }
                }
            }

        }


    }

}


@Composable
fun Start() {
    val Start = mutableListOf<String>("Today", "Tomarom", "10 day go", "20 day go")
    var startName: String by remember { mutableStateOf(Start[0]) }
    var expanded by remember { mutableStateOf(false) }
    val rotateAsState = animateFloatAsState(targetValue = if (expanded) 90f else 0f)



    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(40.dp)
            .clickable { expanded = !expanded },
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Box(
            Modifier

                .padding(start = 25.dp), contentAlignment = Alignment.CenterStart
        ) {
            Text(text = "Start", fontSize = 20.sp, style = MaterialTheme.typography.body2)
        }

        Box(
            Modifier

                .padding(end = 25.dp), contentAlignment = Alignment.CenterEnd
        ) {

            Row(verticalAlignment = Alignment.CenterVertically) {

                Text(
                    text = startName,
                    fontSize = 15.sp,
                    modifier = Modifier.padding(start = 25.dp, end = 5.dp),
                    color = Green100
                )
                Icon(
                    imageVector = Icons.Outlined.KeyboardArrowDown,
                    tint = Color.Gray,
                    contentDescription = "",
                    modifier = Modifier
                        .rotate(rotateAsState.value)
                        .size(30.dp)
                )
                DropdownMenu(expanded = expanded, onDismissRequest = {
                    expanded = false
                }) {
                    Start.forEach { day ->
                        DropdownMenuItem(onClick = {
                            expanded = false
                            startName = day
                        }) {
                            Text(text = day, color = Color.Black)
                        }
                    }
                }
            }

        }


    }
}


@Composable
fun Alarm() {
    var expanded by remember { mutableStateOf(false) }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(40.dp)
            .clickable { expanded = !expanded },
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Box(
            Modifier

                .padding(start = 25.dp), contentAlignment = Alignment.CenterStart
        ) {
            Text(text = "Alarm", fontSize = 20.sp, style = MaterialTheme.typography.body2)
        }

        Box(
            Modifier

                .padding(end = 25.dp), contentAlignment = Alignment.CenterEnd
        ) {


            val checkedState = remember { mutableStateOf(true) }
            Switch(
                modifier = Modifier
                    .height(40.dp)
                    .width(40.dp),
                checked = checkedState.value,
                onCheckedChange = { checkedState.value = it },
                colors = SwitchDefaults.colors(
                    checkedThumbColor = Green100,
                    uncheckedThumbColor = Color.Gray,
                    checkedTrackColor = Color.Gray,
                    uncheckedTrackColor = Green100
                )
            )
        }
    }
}



