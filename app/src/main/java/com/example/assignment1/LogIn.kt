package com.example.assignment1

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun LogIn(navController: NavController) {
    val pagerState = rememberPagerState(pageCount = { 2 })
    bodyStr(navController, pagerState)
}
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun bodyStr(
    navController: NavController,
    pagerState: PagerState
){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.main)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(colorResource(id = R.color.main)),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.amanbanklogo),
                contentDescription = "Logo",
                modifier = Modifier.size(120.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.img1),
                contentDescription = "Logo",
                modifier = Modifier.size(220.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Box(modifier = Modifier.fillMaxWidth()) {
                HorizontalPager(
                    state = pagerState,
                    modifier = Modifier.fillMaxWidth()
                ) { page ->
                    Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                        texts(page = page)
                    }
                }
            }
            Spacer(modifier = Modifier.height(40.dp))
            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row{
                    repeat(2) { page ->
                        CustomIndicators(selected = pagerState.currentPage == page)
                    }
                }
            }
            Spacer(modifier = Modifier.height(20.dp))
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    colorResource(id = R.color.secd),
                    shape = RoundedCornerShape(topStart = 40.dp, topEnd = 40.dp)
                ),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Button(
                onClick = { },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 80.dp, start = 60.dp, end = 60.dp, bottom = 20.dp)
                    .height(55.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF0F80B8),
                    contentColor = Color.White
                ),
                shape = RoundedCornerShape(14.dp)
            ) {
                Text(text = "Log In")
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Divider(
                    color = Color.Gray,
                    thickness = 1.dp,
                    modifier = Modifier
                        .weight(1f)
                        .padding(start = 60.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "Or",
                    modifier = Modifier.padding(vertical = 8.dp),
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.width(8.dp))
                Divider(
                    color = Color.Gray,
                    thickness = 1.dp,
                    modifier = Modifier
                        .weight(1f)
                        .padding(end = 60.dp)
                )
            }
            TextButton(
                onClick = {
                    navController.navigate("homescreen") {
                        popUpTo("login") { inclusive = true }
                    }
                }
            ) {
                Text(
                    text = "Go to Home Page", color = colorResource(id = R.color.main),
                    style = TextStyle(
                        fontFamily = FontFamily.SansSerif,
                    )
                )
            }
        }
    }
}
@Composable
fun CustomIndicators(
    selected: Boolean
) {
    Box(
        modifier = Modifier
            .padding(4.dp)
            .background(
                color = if (selected) colorResource(id = R.color.third) else colorResource(id = R.color.quad),
                shape = RoundedCornerShape(3.5.dp)
            )
            .size(width = 25.dp, height = 4.dp)
    )
}
@Composable
fun texts(page: Int){
    val titles = listOf("Welcome to Amanbanks", "Manage your Finance")
    val subtitles = listOf("Your best selection for financial transaction.", "Your finances at your fingertips.")
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(colorResource(id = R.color.main)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = titles[page],
            fontSize = 25.sp,
            color = colorResource(id = R.color.secd)
        )
        Spacer(modifier = Modifier.height(5.dp))
        Text(
            text = subtitles[page],
            fontSize = 15.sp,
            color = colorResource(id = R.color.secd)
        )
    }
    
}
