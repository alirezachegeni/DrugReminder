package com.example.drug

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.drug.ui.theme.Green100
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch


@ExperimentalPagerApi
@Composable
fun CardFoodPill() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 25.dp, end = 25.dp),
        shape = RoundedCornerShape(20.dp), elevation = 10.dp
    ) {
        Column {
            Spacer(modifier = Modifier.height(15.dp))

            Text(
                text = "Food & Pill:",
                fontSize = 20.sp,
                style = MaterialTheme.typography.body2,
                modifier = Modifier.padding(start = 25.dp)
            )
            Spacer(modifier = Modifier.height(5.dp))
            Row(
                Modifier
                    .fillMaxWidth()
                    .height(70.dp)
                    .padding(start = 0.dp, end = 0.dp)
                    , horizontalArrangement = Arrangement.Center
            ) {

                var number by remember {
                    mutableStateOf(0)
                }
                Card(
                    backgroundColor = Color.White,
                    shape = RoundedCornerShape(
                        20.dp
                        //  topEnd = 20.dp,
                        //  bottomEnd = 20.dp,
                        // bottomStart = 20.dp

                    )
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.clickable { number++ }) {

                        Image(
                            modifier = Modifier.size(20.dp),
                            painter = painterResource(id = R.drawable.icons8pill60),
                            contentDescription = ""
                        )
                        Image(
                            modifier = Modifier
                                .height(50.dp)
                                .width(30.dp),
                            painter = painterResource(id = R.drawable.icons8spoon48),
                            contentDescription = ""
                        )
                        Image(
                            modifier = Modifier.size(40.dp),
                            painter = painterResource(id = R.drawable.icons8plate64),
                            contentDescription = ""
                        )
                    }

                }
                Spacer(modifier = Modifier.width(5.dp))
                Card(

                    shape = RoundedCornerShape(
                        20.dp
                        // bottomEnd = 20.dp,
                        // bottomStart = 20.dp
                    )
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.clickable {

                        }) {
                        Image(
                            modifier = Modifier
                                .height(50.dp)
                                .width(30.dp),
                            painter = painterResource(id = R.drawable.icons8spoon48),
                            contentDescription = ""
                        )
                        Image(
                            modifier = Modifier.size(20.dp),
                            painter = painterResource(id = R.drawable.icons8pill60),
                            contentDescription = ""
                        )
                        Spacer(modifier = Modifier.width(5.dp))
                        Image(
                            modifier = Modifier.size(40.dp),
                            painter = painterResource(id = R.drawable.icons8plate64),
                            contentDescription = ""
                        )
                    }
                }
                Spacer(modifier = Modifier.width(5.dp))
                Card(

                    shape = RoundedCornerShape(
                        20.dp
                        //  topStart = 20.dp,
                        //bottomEnd = 20.dp,
                        //bottomStart = 20.dp
                    )
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.clickable { }) {
                        Image(
                            modifier = Modifier
                                .height(50.dp)
                                .width(30.dp),
                            painter = painterResource(id = R.drawable.icons8spoon48),
                            contentDescription = ""
                        )
                        Image(
                            modifier = Modifier.size(40.dp),
                            painter = painterResource(id = R.drawable.icons8plate64),
                            contentDescription = ""
                        )
                        Spacer(modifier = Modifier.width(5.dp))
                        Image(
                            modifier = Modifier.size(20.dp),
                            painter = painterResource(id = R.drawable.icons8pill60),
                            contentDescription = ""
                        )
                    }

                }
            }
        }

    }
}

