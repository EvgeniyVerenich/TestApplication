package com.project.testapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TextFieldDefaults.UnfocusedBorderThickness
import androidx.compose.material3.TextFieldDefaults.shape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.fragment.app.FragmentActivity


class MainActivity : FragmentActivity(){
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen()
        }
    }
}

val oswald = FontFamily(
    Font(R.font.oswald, FontWeight.Medium)
)
val ubuntu = FontFamily(
    Font(R.font.ubuntu_medium, FontWeight.Medium)
)
const val REQUEST_PICK = 1

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
@Preview(showBackground = true)
fun MainScreen(){

    Scaffold(
        bottomBar = {
            BottomToolBar()
        }
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),

            ) {
            TitleImage()
            ChapterName()
            LocationName()
            // push all screens here
        }
    }
}

@Composable
fun TitleImage(){
    Box (
        modifier = Modifier
            .fillMaxWidth()
            .height(140.dp),
        contentAlignment = Alignment.Center
    ){
        Image(painter = painterResource(id = R.drawable.stripes),
            contentDescription = "TitleTheme",
            modifier = Modifier
                .width(264.dp)
                .height(84.dp)
                .padding(top = 12.dp))
        Text(text = "ЛОКАЦИИ", style = TextStyle(fontSize = 30.sp, fontFamily = oswald, fontWeight = FontWeight(300)))
    }
}

@Composable
fun ChapterName(){

    var titleText by remember {
        mutableStateOf("Улицы")
    }

    Card(
        modifier = Modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(10.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 20.dp
        )
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
        ) {
            OutlinedTextField(value = titleText, onValueChange = {titleText = it},
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(15.dp)
                    .background(Color(237, 243, 244)),
                shape = RoundedCornerShape(10.dp),
                textStyle = TextStyle(textAlign = TextAlign.Center,
                    fontFamily = ubuntu,
                    fontWeight = FontWeight(400),
                    fontSize = 24.sp)
            )
        }
    }
}

@Composable
fun LocationName(){

    var location by remember {
        mutableStateOf("")
    }

    Card (
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 20.dp
        )
    ){
       Box (
           modifier = Modifier
               .fillMaxWidth()
               .background(Color.White)
       ){
           Card(
               modifier = Modifier
                   .background(Color.White)
                   .padding(15.dp),
               shape = RoundedCornerShape(16.dp),
           ){
                   Row (
                       modifier = Modifier
                           .fillMaxWidth()
                           .background(Color(237, 243, 244)),
                       verticalAlignment = Alignment.CenterVertically,
                       horizontalArrangement = Arrangement.SpaceBetween
                   ) {
                       OutlinedTextField(
                           value = location,
                           onValueChange = {location = it},
                           label = { Text(text ="Название локации", style = TextStyle(fontSize = 20.sp))},
                           textStyle = TextStyle(fontFamily = ubuntu, fontWeight = FontWeight(400), fontSize = 20.sp,
                               textDecoration = TextDecoration.None),
                       )
                       IconButton(onClick = {
                           BlankFragment.Companion
                       }) {
                           Image(painter = painterResource(id = R.drawable.add), contentDescription = "add")
                       }
                   }
                   Row {
                       Column {
                           // insert images
                       }
                   }
           }
       }
    }
}

@Composable
fun BottomToolBar(){
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Bottom
    ) {
        Box(modifier = Modifier,
            contentAlignment = Alignment.BottomCenter){
            Card(
                modifier = Modifier
                    .background(Color.White)
                    .fillMaxWidth()
                    .height(69.dp),
                shape = RectangleShape,
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 12.dp
                ),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                )
            ){
                Row (
                    modifier = Modifier.fillMaxSize(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Row (
                        modifier = Modifier.fillMaxWidth(0.37f),
                        horizontalArrangement = Arrangement.Start
                    ){
                        Row (
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceAround
                        ){
                            IconButton(onClick = {
                            }) {
                                Icon(painter = painterResource(id = R.drawable.settings), contentDescription = "settings")
                            }
                            IconButton(onClick = {
                            }) {
                                Icon(painter = painterResource(id = R.drawable.money), contentDescription = "money")
                            }
                        }
                    }
                    Row (
                        modifier = Modifier.fillMaxWidth(0.59f)
                    ) {
                        Row (
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceAround
                        ){
                            IconButton(onClick = {
                            }) {
                                Icon(painter = painterResource(id = R.drawable.apps), contentDescription = "apps")
                            }
                            IconButton(onClick = {
                            }) {
                                Icon(painter = painterResource(id = R.drawable.location), contentDescription = "location")
                            }
                        }
                    }
                }
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(18.5.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                IconButton(onClick = { /*TODO*/ },
                    modifier = Modifier.size(103.dp, 100.dp)) {
                    Image(painter = painterResource(id = R.drawable.clock),
                        contentDescription = "clock")
                }
            }
        }
    }
}