package com.example.assignment1

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HomeScreen() {
    val context = LocalContext.current
    Scaffold(
        modifier = Modifier.statusBarsPadding(),
        topBar = {
            TopBarView(
                { Toast.makeText(context, "Menu", Toast.LENGTH_LONG).show() }
            )
        },
        floatingActionButton = {
            FloatingActionButton(modifier = Modifier.padding(bottom = 130.dp),
//                contentColor = Color.White,
                backgroundColor = colorResource(id = R.color.secd),
                onClick = {
                    Toast.makeText(context, "How may I assist you!", Toast.LENGTH_LONG).show()
                    //Need to work on
                }) {
                Image(painter = painterResource(id = R.drawable.chatbot), contentDescription = null, modifier = Modifier.size(25.dp))
            }
        }
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(bottom = 100.dp), // Ensure space for the bottom Column
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.homeui),
                        contentDescription = "Logo",
                        modifier = Modifier.size(220.dp)
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "Welcome to Aman Bank",
                        fontSize = 25.sp,
                        color = colorResource(id = R.color.main)
                    )
                    LazyVerticalGrid(
                        columns = GridCells.Fixed(3),
                        contentPadding = PaddingValues(15.dp),
                        horizontalArrangement = Arrangement.spacedBy(16.dp),
                        verticalArrangement = Arrangement.spacedBy(16.dp),
                        modifier = Modifier
                            .weight(1f)
                            .padding(top = 20.dp)
                    ) {
                        items(6) { index ->
                            when (index) {
                                0 -> FeatureButton(
                                    "Account Details",
                                    R.drawable.sec1
                                ) { /* Handle click */ }

                                1 -> FeatureButton(
                                    "Recent Transactions",
                                    R.drawable.sec2
                                ) { /* Handle click */ }

                                2 -> FeatureButton(
                                    "Card Details",
                                    R.drawable.sec3
                                ) { /* Handle click */ }

                                3 -> FeatureButton("Locate ATM", R.drawable.sec4) { /* Handle click */ }
                                4 -> FeatureButton(
                                    "Locate Branch",
                                    R.drawable.sec5
                                ) { /* Handle click */ }

                                5 -> FeatureButton(
                                    "Open Account",
                                    R.drawable.sec6
                                ) { /* Handle click */ }
                            }
                        }
                    }
                }
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter)
                    .background(
                        colorResource(id = R.color.main),
                        shape = RoundedCornerShape(topStart = 40.dp, topEnd = 40.dp)
                    )
                    .padding(16.dp)
                    .height(150.dp), // Add padding to the content if needed
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                // Content for the bottom column
                Button(
                    onClick = {  },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 60.dp, start = 60.dp, end = 60.dp, bottom = 20.dp)
                        .height(55.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = colorResource(id = R.color.secd),
                        contentColor = colorResource(id = R.color.main)
                    ),
                    shape = RoundedCornerShape(14.dp)
                ) {
                    Text(text = "Log In")
                }
            }
        }
    }
}
@Composable
fun FeatureButton(text: String, icon: Int, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .width(100.dp)
            .height(120.dp)
            .clickable(onClick = onClick),
        shape = RoundedCornerShape(8.dp),
        elevation = 4.dp
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = icon),
                contentDescription = text,
                modifier = Modifier.size(25.dp)
            )
            Spacer(modifier = Modifier.height(25.dp))
            Text(text = text, fontSize = 10.sp, color = Color.Black)
        }
    }
}

