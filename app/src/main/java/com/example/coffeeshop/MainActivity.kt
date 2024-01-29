package com.example.coffeeshop

import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.geometry.center
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RadialGradientShader
import androidx.compose.ui.graphics.Shader
import androidx.compose.ui.graphics.ShaderBrush
import androidx.compose.ui.graphics.colorspace.ColorSpaces
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.coffeeshop.ui.theme.CoffeeShopTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CoffeeShopTheme {
                CoffeeShop()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun CoffeeShop() {

    val largeRadialGradient = object : ShaderBrush() {
        override fun createShader(size: Size): Shader {
            val biggerDimension = maxOf(size.height, size.width)
            return RadialGradientShader(
                colors = listOf(Color(0xFFE48F45), Color(0xFF21170D)),
                center = size.center,
                radius = biggerDimension / 3f,
                colorStops = listOf(0f, 0.95f)
            )
        }
    }

    Column(
        Modifier
            .fillMaxSize()
            .background(largeRadialGradient)
    ) {
        TopImageMenu()
        TopTextBox()




        Column(
            Modifier
                .padding(horizontal = 20.dp)
                .background(Color.White)
        ) {
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(vertical = 10.dp), Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Hot Coffee",
                    style = MaterialTheme.typography.titleMedium,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = "Cold Coffee",
                    style = MaterialTheme.typography.titleLarge,
                    color = Color.LightGray
                )

                Text(
                    text = "Others",
                    style = MaterialTheme.typography.titleLarge,
                    color = Color.LightGray
                )
            }
            Box(Modifier.fillMaxWidth()) {
                var txt by remember { mutableStateOf("") }

                TextField(
                    value = txt,
                    onValueChange = { txt = it },
                    label = {
                        Text(
                            text = "Search your coffee",
                            color = Color.LightGray
                        )
                    },
                    shape = CircleShape,
                    colors = TextFieldDefaults.textFieldColors(
                        unfocusedIndicatorColor = Color.Transparent,
                        focusedIndicatorColor = Color.Transparent,
                        //backgroundColor = Color(0xFFFFFFFF)
                    ),
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Filled.Search,
                            contentDescription = "",
                            tint = Color.LightGray
                        )
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .border(1.dp, Color.LightGray, shape = CircleShape)
                )
            }
            Row(Modifier.weight(1F)) {
                Column(
                    Modifier
                        .fillMaxSize()
                        .padding(top = 20.dp),
                    verticalArrangement = Arrangement.Top,
                ) {

                    val coffeeList = listOf(
                        "Americano",
                        "Cappuccino",
                        "Macchiato",
                        "Americano",
                        "Cappuccino",
                        "Macchiato"
                    )
                    val descriptionList = listOf(
                        "Espresso with hot water.",
                        "Espresso with cream.",
                        "Espresso with milk.",
                        "Espresso with hot water.",
                        "Espresso with cream.",
                        "Espresso with milk."
                    )
                    val costList = listOf(
                        "Rp 15.000",
                        "Rp 25.000",
                        "Rp 25.000",
                        "Rp 15.000",
                        "Rp 25.000",
                        "Rp 25.000"
                    )
                    val painterList = listOf(
                        R.drawable.americano_1,
                        R.drawable.cappuccino_1,
                        R.drawable.macchiato_1,
                        R.drawable.americano_2,
                        R.drawable.cappuccino_2,
                        R.drawable.macchiato_2
                    )

                    LazyColumn() {
                        items(6) { index ->
                            Row(
                                Modifier
                                    .height(120.dp)
                                    .fillMaxWidth(),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Box {
                                    Image(
                                        painter = painterResource(id = painterList[index]),
                                        contentDescription = "",
                                        contentScale = ContentScale.Crop,
                                        modifier = Modifier
                                            .size(110.dp)
                                            .shadow(
                                                elevation = 8.dp,
                                                shape = RoundedCornerShape(10.dp),
                                                clip = true
                                            )
                                    )
                                }

                                Column(
                                    modifier = Modifier
                                        .weight(1F)
                                        .padding(horizontal = 20.dp),
                                    horizontalAlignment = Alignment.Start
                                ) {
                                    Spacer(modifier = Modifier.height(10.dp))
                                    Text(
                                        text = coffeeList[index],
                                        color = Color.Black,
                                        fontSize = 16.sp,
                                        fontWeight = FontWeight.Bold
                                    )
                                    Text(
                                        text = descriptionList[index],
                                        color = Color.LightGray,
                                        fontSize = 12.sp
                                    )
                                    Spacer(modifier = Modifier.height(30.dp))
                                    Text(
                                        text = costList[index],
                                        color = Color.Black,
                                        fontSize = 16.sp,
                                        fontWeight = FontWeight.Bold
                                    )
                                }

                                IconButton(onClick = {}) {
                                    Icon(
                                        imageVector = Icons.Filled.AddCircle,
                                        contentDescription = "",
                                        tint = Color(0xFFD4A078),
                                        modifier = Modifier
                                            .size(48.dp)
                                            .background(Color.White)
                                    )
                                }
                            }
                            Spacer(modifier = Modifier.height(10.dp))
                        }
                    }

                }
            }
        }

    }

}

@Composable
private fun TopTextBox() {
    Column(
        Modifier
            .fillMaxWidth()
            .padding(10.dp)
    ) {
        Text(
            text = "شروع زندگی خوب با یه قهوه",
            style = MaterialTheme.typography.headlineLarge,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier.padding(
                start = 165.dp,
                top = 100.dp,
                bottom = 10.dp
            ),
            textAlign = TextAlign.Center
        )

        Row(Modifier.padding(start = 185.dp)) {
            Text(
                text = "It's Great",
                style = MaterialTheme.typography.titleLarge,
                color = Color(0xFFAAAAAA),
                textAlign = TextAlign.Center
            )

            Text(
                text = " Day For Coffee.",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                textAlign = TextAlign.Start
            )
        }
    }
}

@Composable
private fun TopImageMenu() {
    Card(Modifier.background(colorResource(id = R.color.Brown))) {
        Row(
            Modifier
                .fillMaxWidth()
                .background(color = colorResource(id = R.color.Brown))
                .height(50.dp)
                .padding(start = 10.dp, top = 10.dp),
        ) {
            IconButton(onClick = {}) {
                Icon(
                    imageVector = Icons.Outlined.Menu,
                    contentDescription = "",
                    modifier = Modifier.size(35.dp),
                    tint = Color.White
                )
            }
        }
        Image(
            painter = painterResource(id = R.drawable.background),
            contentDescription = null,
            contentScale = ContentScale.FillWidth,
            modifier = Modifier.fillMaxWidth()
        )
    }
}


@Composable
fun DescriptionPage() {
    Column(Modifier.fillMaxSize()) {
        Card(
            Modifier
                .background(Color.Black)
                .weight(0.5F)
        ) {

            Column {
                Card(
                    Modifier
                        .background(Color.Black)
                        .weight(0.5F),
                ) {
                    Box(contentAlignment = Alignment.TopCenter) {
                        Image(
                            painter = painterResource(id = R.drawable.macchiato_2),
                            contentDescription = null,
                            contentScale = ContentScale.FillWidth,
                            modifier = Modifier.fillMaxWidth()
                        )
                    }

                    Row(
                        Modifier
                            .fillMaxWidth()
                            .height(50.dp)
                            .padding(start = 10.dp, top = 10.dp)
                    ) {
                        IconButton(onClick = {}) {
                            Icon(
                                imageVector = Icons.Outlined.ArrowBack,
                                contentDescription = "",
                                modifier = Modifier.size(35.dp),
                                tint = Color.White
                            )
                        }
                    }
                }

                Column(
                    Modifier
                        .weight(0.5F)
                        .fillMaxWidth()
                        .padding(start = 20.dp, end = 20.dp, top = 25.dp, bottom = 10.dp)
                        .background(Color.White)
                ) {

                    Column(Modifier.weight(1F)) {
                        Text(
                            text = "Macchiato",
                            style = MaterialTheme.typography.headlineMedium,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black
                        )

                        Spacer(modifier = Modifier.height(15.dp))

                        Row(Modifier.fillMaxWidth()) {
                            for (i in 1..5) {
                                Icon(
                                    imageVector = Icons.Filled.Star,
                                    contentDescription = "",
                                    modifier = Modifier.size(25.dp),
                                    tint = Color(0xFFFFB42D)
                                )
                            }
                        }



                        Spacer(modifier = Modifier.height(25.dp))

                        Text(
                            text = "Description",
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black
                        )

                        Spacer(modifier = Modifier.height(10.dp))

                        Text(
                            text = "Caffè macchiato, sometimes called espresso macchiato, is an espresso coffee " +
                                    "drink with a small amount of milk, usually foamed. In Italian, macchiato means " +
                                    "\"stained\" or \"spotted\" so the literal translation of caffè macchiato is " +
                                    "\"stained” or “marked coffee.” \n" +
                                    "Caffè macchiato, sometimes called espresso macchiato, is an espresso coffee " +
                                    "drink with a small amount of milk, usually foamed. In Italian, macchiato means " +
                                    "\"stained\" or \"spotted\" so the literal translation of caffè macchiato is " +
                                    "\"stained” or “marked coffee.”",
                            textAlign = TextAlign.Justify,
                            style = MaterialTheme.typography.titleLarge,
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
                                text = "Price",
                                style = MaterialTheme.typography.titleLarge,
                                color = Color.LightGray
                            )
                            Text(
                                text = "Rp 25.000",
                                color = Color.Black,
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }

                        Box(
                            modifier = Modifier.fillMaxHeight(),
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
                                    text = "Add To Cart",
                                    fontSize = 16.sp,
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