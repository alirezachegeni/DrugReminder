package com.example.drug


import android.content.Context
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.outlined.KeyboardArrowDown
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.drug.ui.theme.Green100
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch
import java.util.*

@ExperimentalPagerApi
@Composable
fun CardTop(context: Context) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(230.dp)
            .padding(start = 25.dp, end = 25.dp),
        shape = RoundedCornerShape(20.dp), elevation = 10.dp
    ) {

        Column {
            Spacer(modifier = Modifier.height(10.dp))
            TopPager()
            Spacer(modifier = Modifier.height(10.dp))
            ReminderTimes()
            Spacer(modifier = Modifier.height(10.dp))
            Doz()
            Spacer(modifier = Modifier.height(5.dp))
            Time(context = context)
        }

    }


}


@ExperimentalPagerApi
@Composable
fun TopPager() {
    val tabData = listOf(
        "Tablet",
        "Capsual",
        "Drops",
        "Ceram",
        "syring",
        "suerup"
    )
    val pagerState = rememberPagerState(
        pageCount = tabData.size,
        infiniteLoop = true,
        initialPage = 0
    )
    var tabIndex = pagerState.currentPage
    val coroutineScope = rememberCoroutineScope()

    Spacer(modifier = Modifier.height(10.dp))
    Column(Modifier.height(50.dp)) {
        ScrollableTabRow(
            selectedTabIndex = tabIndex,
            backgroundColor = Color.White,
            divider = {
                TabRowDefaults.Divider(
                    thickness = 5.dp,
                    color = Color.Transparent
                )
            },
            indicator = { tabPositions ->
                TabRowDefaults.DividerThickness
            },
            edgePadding = 7.dp,
        ) {
            tabData.forEachIndexed { index, pair ->
                Tab(
                    selected = tabIndex == index,
                    onClick = {
                        coroutineScope.launch {
                            pagerState.animateScrollToPage(index)
                        }
                    },
                    text = {

                        Card(
                            backgroundColor = if (pagerState.currentPage == index) Green100 else Color.White,
                            modifier = Modifier
                                .width(100.dp)
                                .height(40.dp), shape = RoundedCornerShape(10.dp), elevation = 20.dp
                        ) {
                            Box(contentAlignment = Alignment.Center) {
                                Text(text = pair, style = MaterialTheme.typography.body1)
                            }

                        }


                    },
                    modifier = Modifier
                        .height(70.dp)
                        .wrapContentWidth()
                        .padding(start = 0.dp, end = 0.dp)
                        .clip(CircleShape),
                )
            }
        }
        HorizontalPager(state = pagerState, modifier = Modifier.weight(1f)) { index ->
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                when (index) {
                    0 -> {

                    }
                    1 -> {

                    }
                    2 -> {

                    }
                    3 -> {

                    }
                    4 -> {

                    }
                    5 -> {

                    }
                    6 -> {

                    }
                    7 -> {

                    }
                }
            }
        }
    }
}


@Composable
fun ReminderTimes() {

    val dayStart = mutableListOf<String>("Once", "Twe", "Three", "Four", "Five")
    var dayName: String by remember { mutableStateOf(dayStart[0]) }
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
            Text(text = "Reminder Times", fontSize = 20.sp, style = MaterialTheme.typography.body2)
        }

        Box(
            Modifier

                .padding(end = 25.dp), contentAlignment = Alignment.CenterEnd
        ) {

            Row(verticalAlignment = Alignment.CenterVertically) {

                Text(
                    text = dayName,
                    fontSize = 15.sp,
                    modifier = Modifier.padding(start = 25.dp, end = 10.dp),
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
                    dayStart.forEach { day ->
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
fun Doz() {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(40.dp)
           ,
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Box(
            Modifier.padding(start = 25.dp), contentAlignment = Alignment.CenterStart
        ) {
            Text(text = "Dosage", fontSize = 20.sp, style = MaterialTheme.typography.body2)
        }

        Box(
            Modifier

                .padding(end = 0.dp), contentAlignment = Alignment.CenterEnd
        ) {
            var number by remember {
                mutableStateOf(0)
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(40.dp)
                    .padding(end = 30.dp),
                contentAlignment = Alignment.CenterEnd
            ) {
                Card(
                    modifier = Modifier
                        .width(80.dp)
                        .height(25.dp),
                    elevation = 15.dp,
                    shape = RoundedCornerShape(20.dp)
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {

                        Spacer(modifier = Modifier.width(4.dp))
                        Card(
                            modifier = Modifier
                                .size(20.dp)

                                .clickable {
                                    if (number > 0) {
                                        number--
                                    }
                                }, shape = RoundedCornerShape(10.dp), backgroundColor = Green100
                        ) {
                            Icon(
                                modifier = Modifier.size(20.dp),
                                painter = painterResource(id = R.drawable.ic_rule),
                                contentDescription = "rule",
                                tint = Color.White
                            )
                        }

                        Text(
                            modifier = Modifier.padding(start = 6.dp),
                            text = " $number ",
                            style = MaterialTheme.typography.body2,
                            fontSize = 15.sp,
                            color = Green100
                        )
                        Box(
                            Modifier
                                .fillMaxWidth()
                                .padding(end = 4.dp), contentAlignment = Alignment.CenterEnd
                        ) {
                            Card(
                                modifier = Modifier
                                    .size(20.dp)
                                    .clickable {
                                        if (number < 10) {
                                            number++
                                        }
                                    }, shape = RoundedCornerShape(10.dp), backgroundColor = Green100
                            ) {
                                Icon(
                                    modifier = Modifier.size(15.dp),
                                    painter = painterResource(id = R.drawable.ic_add),
                                    contentDescription = "Add",
                                    tint = Color.White,
                                )
                            }
                        }


                    }


                }
            }


        }


    }

}


@Composable
fun Time(context :Context) {

    val calendar = Calendar.getInstance()
    val hour = calendar[Calendar.HOUR_OF_DAY]
    val minutes = calendar[Calendar.MINUTE]

    val time = remember {
        mutableStateOf("")
    }
    val timePickerDialog = android.app.TimePickerDialog(
        context ,
        { _ , hour : Int , minute : Int ->
            if (hour in 0 .. 11)
            {
                time.value = "$hour:$minute AM"
                if (minute in 0..9){
                    time.value = "$hour:0$minute AM"
                }
            }
            else
            {
                time.value = "$hour:$minute PM"
                if (hour == 12)
                {
                    time.value = "00:$minute PM"
                }
            }
        } , hour , minutes , false
    )


    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(40.dp)

            .clickable { timePickerDialog.show() },
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Box(

            Modifier
                .padding(start = 25.dp)
                .fillMaxWidth(),
                 contentAlignment = Alignment.CenterStart
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {



                    Icon(
                        modifier = Modifier.size(25.dp),
                        painter = painterResource(id = R.drawable.ic_time),
                        contentDescription = "rule",
                        tint = Color.Black
                    )

                Text(
                    modifier = Modifier.padding(start = 10.dp,top = 5.dp),
                    text = time.value.ifBlank { "Pick Your Time" },
                    style = MaterialTheme.typography.body2,
                    fontSize = 20.sp,
                    color = Green100
                )


            }
        }

        Box(
            Modifier

                .padding(end = 25.dp), contentAlignment = Alignment.CenterEnd
        ) {


        }


    }

}
