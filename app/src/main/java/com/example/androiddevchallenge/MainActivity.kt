/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androiddevchallenge.ui.theme.MyTheme

class MainActivity : AppCompatActivity() {

    var wheatheModellist: ArrayList<WheatheModel> = arrayListOf()
    var wheatheModelDayWiselist: ArrayList<WheatheModel> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val model1 = WheatheModel(
                "21°",
                "08:00 Am",
                painterResource(id = R.drawable.ic_rainy_day)
            )
            val model2 = WheatheModel(
                "22°",
                "09:00 Am",
                painterResource(id = R.drawable.ic_rainy_day)
            )
            val model3 =
                WheatheModel("24°", "10:00 Am", painterResource(id = R.drawable.ic_sun))
            val model4 =
                WheatheModel("25°", "11:00 Am", painterResource(id = R.drawable.ic_sun))
            val model5 = WheatheModel(
                "25°",
                "12:00 Am",
                painterResource(id = R.drawable.ic_rainy_cloud)
            )
            val model6 =
                WheatheModel("28°", "01:00 Pm", painterResource(id = R.drawable.ic_sun))

            wheatheModellist.add(model1)
            wheatheModellist.add(model2)
            wheatheModellist.add(model3)
            wheatheModellist.add(model4)
            wheatheModellist.add(model5)
            wheatheModellist.add(model6)

            val wheatheModel1 = WheatheModel(
                "14°/21°",
                "Mon March 01",
                painterResource(id = R.drawable.ic_sun)
            )
            val wheatheModel2 = WheatheModel(
                "14°/23°",
                "Tue March 02",
                painterResource(id = R.drawable.ic_rainy_day)
            )
            val wheatheModel3 = WheatheModel(
                "12°/22°",
                "Wed March 03",
                painterResource(id = R.drawable.ic_sun)
            )
            val wheatheModel4 = WheatheModel(
                "13°/24°",
                "Thu March 04",
                painterResource(id = R.drawable.ic_rainy_cloud)
            )
            val wheatheModel5 = WheatheModel(
                "15°/25°",
                "Fri March 05",
                painterResource(id = R.drawable.ic_sun)
            )
            val wheatheModel6 = WheatheModel(
                "14°/22°",
                "Sat March 06",
                painterResource(id = R.drawable.ic_sun)
            )
            val wheatheModel7 = WheatheModel(
                "14°/21°",
                "Sun March 07",
                painterResource(id = R.drawable.ic_rainy_day)
            )

            wheatheModelDayWiselist.add(wheatheModel1)
            wheatheModelDayWiselist.add(wheatheModel2)
            wheatheModelDayWiselist.add(wheatheModel3)
            wheatheModelDayWiselist.add(wheatheModel4)
            wheatheModelDayWiselist.add(wheatheModel5)
            wheatheModelDayWiselist.add(wheatheModel6)
            wheatheModelDayWiselist.add(wheatheModel7)

            MyTheme {
                MyApp(wheatheModellist, wheatheModelDayWiselist)
            }
        }
    }
}

class WheatheModel(var temp: String, var time: String, var drawble: Painter)

// Start building your app here!
@Composable
fun MyApp(
    wheatheModellist: ArrayList<WheatheModel>,
    wheatheModelDayWiselist: ArrayList<WheatheModel>
) {

    Surface(color = MaterialTheme.colors.background) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color = MaterialTheme.colors.primary)
        ) {
            if (isSystemInDarkTheme()) {
                Image(
                    painter = painterResource(id = R.drawable.ic_dark_welcome_bg),
                    alignment = Alignment.Center,
                    contentDescription = "",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxSize()

                )
            } else {
                Image(
                    painter = painterResource(id = R.drawable.ic_light_welcome_bg),
                    alignment = Alignment.Center,
                    contentDescription = "",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxSize()

                )
            }

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .fillMaxWidth(),
            ) {

                Text(
                    text = "Today",
                    style = (MaterialTheme.typography).body1
                        .merge(TextStyle(fontSize = 20.sp)),
                    modifier = Modifier
                        .padding(3.dp)
                        .padding(start = 10.dp)
                        .fillMaxWidth(),
                    color = MaterialTheme.colors.secondary,
                    fontWeight = FontWeight(600),
                    fontFamily = FontFamily(Font(R.font.nunito_bold))
                )

                Text(
                    text = "India",
                    style = (MaterialTheme.typography).body1
                        .merge(TextStyle(fontSize = 23.sp)),
                    modifier = Modifier
                        .padding(3.dp)
                        .padding(start = 10.dp)
                        .fillMaxWidth(),
                    color = MaterialTheme.colors.secondary,
                    fontWeight = FontWeight(900),
                    fontFamily = FontFamily(Font(R.font.nunito_bold))
                )

                Text(
                    text = "Sun Feb 28",
                    style = (MaterialTheme.typography).body1
                        .merge(TextStyle(fontSize = 14.sp)),
                    modifier = Modifier
                        .padding(3.dp)
                        .padding(start = 10.dp)
                        .fillMaxWidth(),
                    color = MaterialTheme.colors.primaryVariant,
                    fontWeight = FontWeight(900),
                    fontFamily = FontFamily(Font(R.font.nunito_bold))
                )

                val img = painterResource(R.drawable.ic_sun)
                Toptemprature(img, "25°")

                Text(
                    text = "Sunny Day",
                    style = (MaterialTheme.typography).body1
                        .merge(TextStyle(fontSize = 30.sp, textAlign = TextAlign.Center)),
                    modifier = Modifier
                        .padding(1.dp)
                        .fillMaxWidth(),
                    color = MaterialTheme.colors.secondary,
                    fontWeight = FontWeight(600),
                    fontFamily = FontFamily(Font(R.font.nunito_bold))
                )

                Text(
                    text = "Today",
                    style = (MaterialTheme.typography).body1
                        .merge(TextStyle(fontSize = 20.sp)),
                    modifier = Modifier
                        .padding(3.dp)
                        .padding(start = 10.dp)
                        .fillMaxWidth(),
                    color = MaterialTheme.colors.secondary,
                    fontWeight = FontWeight(600),
                    fontFamily = FontFamily(Font(R.font.nunito_bold))
                )

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .horizontalScroll(rememberScrollState())
                ) {

                    for (items in wheatheModellist) {
                        WheatherRow(items)
                    }
                }

                Text(
                    text = "Next Days",
                    style = (MaterialTheme.typography).body1
                        .merge(TextStyle(fontSize = 20.sp)),
                    modifier = Modifier
                        .padding(3.dp)
                        .fillMaxWidth(),
                    color = MaterialTheme.colors.secondary,
                    fontWeight = FontWeight(600),
                    fontFamily = FontFamily(Font(R.font.nunito_bold))
                )

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 10.dp, end = 10.dp)
                        .verticalScroll(rememberScrollState())
                ) {

                    for (items in wheatheModelDayWiselist) {
                        WheatherDayWiseRow(items)
                    }
                }
            }
        }
    }
}

@Composable
fun WheatherDayWiseRow(wheatherModelItem: WheatheModel) {
    Card(
        shape = RoundedCornerShape(
            bottomEnd = 5.dp,
            bottomStart = 20.dp,
            topEnd = 20.dp,
            topStart = 5.dp
        ),
        backgroundColor = MaterialTheme.colors.secondary,
        elevation = 10.dp,
        modifier = Modifier
            .padding(7.dp)
            .clickable(
                onClick = {
                }
            )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = wheatherModelItem.time,
                style = (MaterialTheme.typography).body1
                    .merge(
                        TextStyle(
                            fontSize = 18.sp,
                            textAlign = TextAlign.Start
                        )
                    ),
                modifier = Modifier
                    .padding(3.dp)
                    .fillMaxHeight()
                    .weight(3f),
                color = MaterialTheme.colors.primary,
                fontWeight = FontWeight(600),
                fontFamily = FontFamily(Font(R.font.nunito_light))
            )
            Image(
                painter = wheatherModelItem.drawble,
                alignment = Alignment.Center,
                colorFilter = ColorFilter.tint(color = MaterialTheme.colors.primary),
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(24.dp, 24.dp)

            )
            Text(
                text = wheatherModelItem.temp,
                style = (MaterialTheme.typography).body1
                    .merge(
                        TextStyle(
                            fontSize = 18.sp,
                            textAlign = TextAlign.End
                        )
                    ),
                modifier = Modifier
                    .padding(3.dp)
                    .fillMaxHeight()
                    .weight(2f),
                color = MaterialTheme.colors.primary,
                fontWeight = FontWeight(500),
                fontFamily = FontFamily(Font(R.font.nunito_bold))
            )
        }
    }
}

@Composable
fun WheatherRow(wheatherModelItem: WheatheModel) {
    Card(
        shape = RoundedCornerShape(
            bottomEnd = 5.dp,
            bottomStart = 25.dp,
            topEnd = 25.dp,
            topStart = 5.dp
        ),
        backgroundColor = MaterialTheme.colors.secondary,
        elevation = 8.dp,
        modifier = Modifier.padding(7.dp)
    ) {
        Column(
            modifier = Modifier
                .size(65.dp, 100.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = wheatherModelItem.time,
                style = (MaterialTheme.typography).body1
                    .merge(
                        TextStyle(
                            fontSize = 10.sp,
                            textAlign = TextAlign.Center
                        )
                    ),
                modifier = Modifier
                    .padding(3.dp)
                    .fillMaxWidth(),
                color = MaterialTheme.colors.primary,
                fontWeight = FontWeight(600),
                fontFamily = FontFamily(Font(R.font.nunito_light))
            )

            Image(
                painter = wheatherModelItem.drawble,
                alignment = Alignment.Center,
                colorFilter = ColorFilter.tint(color = MaterialTheme.colors.primary),
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(37.dp, 37.dp)
                    .fillMaxWidth()
            )
            Text(
                text = wheatherModelItem.temp,
                style = (MaterialTheme.typography).body1
                    .merge(
                        TextStyle(
                            fontSize = 16.sp,
                            textAlign = TextAlign.Center
                        )
                    ),
                modifier = Modifier
                    .padding(3.dp)
                    .fillMaxWidth(),
                color = MaterialTheme.colors.primary,
                fontWeight = FontWeight(500),
                fontFamily = FontFamily(Font(R.font.nunito_bold))
            )
        }
    }
}

@Composable
fun Toptemprature(img: Painter, temp: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        horizontalArrangement = Arrangement.Center,
    ) {
        Image(
            painter = img,
            alignment = Alignment.Center,
            colorFilter = ColorFilter.tint(color = MaterialTheme.colors.secondary),
            contentDescription = "",
            modifier = Modifier
                .size(80.dp, 80.dp)
                .padding(end = 10.dp)
                .fillMaxHeight()

        )
        Divider(
            color = MaterialTheme.colors.secondary,
            modifier = Modifier
                .height(80.dp)
                .width(3.dp),
        )
        Text(
            text = temp,
            style = (MaterialTheme.typography).body1
                .merge(TextStyle(fontSize = 60.sp, textAlign = TextAlign.Center)),
            modifier = Modifier
                .padding(3.dp)
                .padding(start = 10.dp),
            color = MaterialTheme.colors.secondary,
            fontWeight = FontWeight(600),
            fontFamily = FontFamily(Font(R.font.nunito_bold))
        )
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {

    lateinit var wheatheModellist: ArrayList<WheatheModel>
    lateinit var wheatheModelDayWiselist: ArrayList<WheatheModel>

    wheatheModellist = arrayListOf()
    wheatheModelDayWiselist = arrayListOf()

    val model1 = WheatheModel(
        "21°",
        "08:00 Am",
        painterResource(id = R.drawable.ic_rainy_day)
    )
    val model2 = WheatheModel(
        "22°",
        "09:00 Am",
        painterResource(id = R.drawable.ic_rainy_day)
    )
    val model3 =
        WheatheModel("24°", "10:00 Am", painterResource(id = R.drawable.ic_sun))
    val model4 =
        WheatheModel("25°", "11:00 Am", painterResource(id = R.drawable.ic_sun))
    val model5 = WheatheModel(
        "25°",
        "12:00 Am",
        painterResource(id = R.drawable.ic_rainy_cloud)
    )
    val model6 =
        WheatheModel("28°", "01:00 Pm", painterResource(id = R.drawable.ic_sun))

    wheatheModellist.add(model1)
    wheatheModellist.add(model2)
    wheatheModellist.add(model3)
    wheatheModellist.add(model4)
    wheatheModellist.add(model5)
    wheatheModellist.add(model6)

    val wheatheModel1 = WheatheModel(
        "14°/21°",
        "Mon March 01",
        painterResource(id = R.drawable.ic_sun)
    )
    val wheatheModel2 = WheatheModel(
        "14°/23°",
        "Tue March 02",
        painterResource(id = R.drawable.ic_rainy_day)
    )
    val wheatheModel3 = WheatheModel(
        "12°/22°",
        "Wed March 03",
        painterResource(id = R.drawable.ic_sun)
    )
    val wheatheModel4 = WheatheModel(
        "13°/24°",
        "Thu March 04",
        painterResource(id = R.drawable.ic_rainy_cloud)
    )
    val wheatheModel5 = WheatheModel(
        "15°/25°",
        "Fri March 05",
        painterResource(id = R.drawable.ic_sun)
    )
    val wheatheModel6 = WheatheModel(
        "14°/22°",
        "Sat March 06",
        painterResource(id = R.drawable.ic_sun)
    )
    val wheatheModel7 = WheatheModel(
        "14°/21°",
        "Sun March 07",
        painterResource(id = R.drawable.ic_rainy_day)
    )

    wheatheModelDayWiselist.add(wheatheModel1)
    wheatheModelDayWiselist.add(wheatheModel2)
    wheatheModelDayWiselist.add(wheatheModel3)
    wheatheModelDayWiselist.add(wheatheModel4)
    wheatheModelDayWiselist.add(wheatheModel5)
    wheatheModelDayWiselist.add(wheatheModel6)
    wheatheModelDayWiselist.add(wheatheModel7)

    MyTheme {
        MyApp(wheatheModellist, wheatheModelDayWiselist)
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {

    lateinit var wheatheModellist: ArrayList<WheatheModel>
    lateinit var wheatheModelDayWiselist: ArrayList<WheatheModel>

    wheatheModellist = arrayListOf()
    wheatheModelDayWiselist = arrayListOf()

    val model1 = WheatheModel(
        "21°",
        "08:00 Am",
        painterResource(id = R.drawable.ic_rainy_day)
    )
    val model2 = WheatheModel(
        "22°",
        "09:00 Am",
        painterResource(id = R.drawable.ic_rainy_day)
    )
    val model3 =
        WheatheModel("24°", "10:00 Am", painterResource(id = R.drawable.ic_sun))
    val model4 =
        WheatheModel("25°", "11:00 Am", painterResource(id = R.drawable.ic_sun))
    val model5 = WheatheModel(
        "25°",
        "12:00 Am",
        painterResource(id = R.drawable.ic_rainy_cloud)
    )
    val model6 =
        WheatheModel("28°", "01:00 Pm", painterResource(id = R.drawable.ic_sun))

    wheatheModellist.add(model1)
    wheatheModellist.add(model2)
    wheatheModellist.add(model3)
    wheatheModellist.add(model4)
    wheatheModellist.add(model5)
    wheatheModellist.add(model6)

    val wheatheModel1 = WheatheModel(
        "14°/21°",
        "Mon March 01",
        painterResource(id = R.drawable.ic_sun)
    )
    val wheatheModel2 = WheatheModel(
        "14°/23°",
        "Tue March 02",
        painterResource(id = R.drawable.ic_rainy_day)
    )
    val wheatheModel3 = WheatheModel(
        "12°/22°",
        "Wed March 03",
        painterResource(id = R.drawable.ic_sun)
    )
    val wheatheModel4 = WheatheModel(
        "13°/24°",
        "Thu March 04",
        painterResource(id = R.drawable.ic_rainy_cloud)
    )
    val wheatheModel5 = WheatheModel(
        "15°/25°",
        "Fri March 05",
        painterResource(id = R.drawable.ic_sun)
    )
    val wheatheModel6 = WheatheModel(
        "14°/22°",
        "Sat March 06",
        painterResource(id = R.drawable.ic_sun)
    )
    val wheatheModel7 = WheatheModel(
        "14°/21°",
        "Sun March 07",
        painterResource(id = R.drawable.ic_rainy_day)
    )

    wheatheModelDayWiselist.add(wheatheModel1)
    wheatheModelDayWiselist.add(wheatheModel2)
    wheatheModelDayWiselist.add(wheatheModel3)
    wheatheModelDayWiselist.add(wheatheModel4)
    wheatheModelDayWiselist.add(wheatheModel5)
    wheatheModelDayWiselist.add(wheatheModel6)
    wheatheModelDayWiselist.add(wheatheModel7)

    MyTheme(darkTheme = true) {
        MyApp(wheatheModellist, wheatheModelDayWiselist)
    }
}
