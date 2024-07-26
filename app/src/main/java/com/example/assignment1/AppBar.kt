package com.example.assignment1

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun TopBarView(
    onBackNavClicked: () -> Unit = {}
) {
    val navigationIcon: (@Composable () -> Unit)? = {
        IconButton(onClick = {
            onBackNavClicked()
        }) {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.List,
                tint = Color.White,
                contentDescription = null
            )
        }
    }
    TopAppBar(
        title = {
            Image(
                painter = painterResource(id = R.drawable.amanbanklogo),
                contentDescription = "Logo",
                modifier = Modifier
                    .heightIn(max = 30.dp)
            )
        },
        elevation = 3.dp,
        backgroundColor = colorResource(id = R.color.main),
        navigationIcon = navigationIcon
    )

}