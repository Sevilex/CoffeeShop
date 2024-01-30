package com.example.coffeeshop

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(showBackground = true)
@Composable
fun DescriptionPage() {
    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {

        Column(Modifier.fillMaxSize()) {
            Card(
                Modifier
                    .background(colorResource(id = R.color.Brown))
                    .weight(0.5F)
            ) {

                Column {
                    Card(
                        Modifier
                            .background(colorResource(id = R.color.Brown))
                    ) {
                        Row(
                            Modifier
                                .fillMaxWidth()
                                .height(0.dp)
                        ) {}
                        Box(contentAlignment = Alignment.TopCenter) {
                            Image(
                                painter = painterResource(id = R.drawable.macchiato_2),
                                contentDescription = null,
                                contentScale = ContentScale.FillWidth,
                                modifier = Modifier.fillMaxWidth()
                            )
                        }
                    }

                    Column(
                        Modifier
                            .weight(0.5F)
                            .fillMaxWidth()
                            .padding(start = 15.dp, end = 15.dp, top = 20.dp, bottom = 5.dp)
                            .background(Color.White)
                    ) {

                        Column(
                            Modifier.weight(1F)
                                ) {
                            Text(
                                modifier = Modifier.padding(6.dp),
                                text = "ماکیاتو",
                                style = MaterialTheme.typography.headlineMedium,
                                fontWeight = FontWeight.Bold,
                                color = Color.Black
                            )

                            Spacer(modifier = Modifier.height(5.dp))

                            Row(
                                Modifier
                                    .fillMaxWidth().padding(6.dp)) {
                                for (i in 1..5) {
                                    Icon(
                                        imageVector = Icons.Filled.Star,
                                        contentDescription = "",
                                        modifier = Modifier.size(25.dp),
                                        tint = Color(0xFFFFB42D)
                                    )
                                }
                            }



                            Spacer(modifier = Modifier.height(5.dp))

                            Text(
                                modifier = Modifier.padding(6.dp),
                                text = "توضیحات",
                                style = MaterialTheme.typography.titleLarge,
                                fontWeight = FontWeight.Bold,
                                color = Color.Black
                            )

                            Spacer(modifier = Modifier.height(3.dp))

                            Text(
                                modifier = Modifier.padding(8.dp),
                                text = "ماکیاتو یکی دیگه از نوشیدنی های گرم بر پایه اسپرسو هستش که دو مدل داره: اسپرسو ما کیاتو و لاته ما کیاتو . این نوشیدنی گرم از ترکیب قهوه اسپرسو، شیر فوم گرفته شده و فوم شیر تشکیل می شود",
                                textAlign = TextAlign.Justify,
                                style = MaterialTheme.typography.titleMedium,
                                color = Color.Black
                            )
                        }

                        Row(
                            Modifier
                                .height(75.dp)
                                .fillMaxWidth()
                        ) {
                            Column(
                                Modifier
                                    .fillMaxHeight()
                                    .weight(0.5F),
                                verticalArrangement = Arrangement.Center
                            ) {
                                Text(
                                    modifier = Modifier.padding(start = 6.dp,end = 6.dp),
                                    text = "قیمت",
                                    style = MaterialTheme.typography.titleLarge,
                                    color = Color.LightGray
                                )
                                Text(
                                    modifier = Modifier.padding(start = 6.dp, end = 6.dp),
                                    text = "600,000 ریال",
                                    color = Color.Black,
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            }

                            Box(
                                modifier = Modifier.fillMaxHeight().padding(6.dp),
                                contentAlignment = Alignment.Center
                            ) {
                                Button(
                                    onClick = {},
                                    colors = ButtonDefaults.buttonColors(
                                        //backgroundColor = Color(0xFFD4A078),
                                        contentColor = Color.White,
                                    ),
                                    modifier = Modifier
                                        .width(200.dp)
                                        .height(50.dp),
                                    enabled = true
                                ) {
                                    Text(
                                        text = "سفارش",
                                        fontSize = 28.sp,
                                        fontWeight = FontWeight.Bold
                                    )
                                }
                            }
                        }
                    }
                }

                Row(
                    Modifier
                        .fillMaxWidth()
                        .height(50.dp)
                        .padding(20.dp, 25.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.End
                ) {
                    var color = Color.LightGray

                    Box(
                        modifier = Modifier
                            .shadow(
                                elevation = 10.dp,
                                shape = CircleShape
                            )
                    ) {
                        IconButton(
                            onClick = {
                                color = if (color == Color.LightGray) Color.Red else Color.LightGray
                            },
                            modifier = Modifier
                                .size(50.dp)
                                .clip(CircleShape)
                                .background(Color.White)
                        ) {
                            Icon(
                                imageVector = Icons.Outlined.Favorite,
                                contentDescription = "",
                                modifier = Modifier.size(35.dp),
                                tint = color
                            )
                        }
                    }
                }
            }
        }
    }
}