package com.abhishek.bussinesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Share
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.abhishek.bussinesscard.ui.theme.BussinessCardTheme
import com.abhishek.bussinesscard.ui.theme.DarkGreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BussinessCardTheme {

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    BusinessCard()
                }
            }
        }
    }
}
@Composable
fun BusinessCard(){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(DarkGreen)
    ){
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(R.drawable.kt_ic),
                contentDescription = " " ,
                contentScale = ContentScale.Crop
            )

            Text(
                text = stringResource(id = R.string.name),
                fontWeight = FontWeight.Normal,
                fontSize = 36.sp,
                color = Color.White
            )
            Spacer(modifier = Modifier.height(14.dp))
            Text(
                text = stringResource(id = R.string.about),
                fontWeight = FontWeight.Normal,
                fontSize = 21.sp,
                color = Color.Green
            )

            Spacer(modifier = Modifier.height(100.dp))

            Column(
                horizontalAlignment = Alignment.Start,
                modifier = Modifier
                    .padding(20.dp)
            ) {
                Info(
                    icon = Icons.Default.Phone,
                    description = "phone",
                    textId = R.string.phone
                )

                Info(
                    icon = Icons.Default.Email,
                    description = "mail",
                    textId = R.string.mail
                )

                Info(
                    icon = Icons.Default.Share,
                    description = "share",
                    textId = R.string.share
                )
            }
        }
        Row(
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(12.dp)
        ){
            Icon(
                imageVector = Icons.Default.Menu,
                contentDescription = "Menu",
                modifier = Modifier
//                    .padding(8.dp)
                    .size(35.dp),
                tint = Color.White
            )
            Spacer(modifier = Modifier.width(10.dp))
            Text(
                text = stringResource(id = R.string.profile),
                color = Color.White,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
        }

    }
}
@Composable
fun Info(
    icon : ImageVector,
    description : String,
    @StringRes textId : Int
){
    Divider(color = Color.White, thickness = 3.dp)
    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = Modifier.padding(start = 15.dp , top = 15.dp , bottom = 15.dp)
    ){
        Icon(imageVector = icon , contentDescription = description , tint = Color.Green)
        Spacer(modifier = Modifier.width(30.dp))
        Text(text = stringResource(id = textId) , color = Color.White , fontSize = 18.sp , fontWeight = FontWeight.Normal)
    }
}

@Preview
@Composable
fun DefaultCardPreview(){
    BussinessCardTheme {
        BusinessCard()
    }
}