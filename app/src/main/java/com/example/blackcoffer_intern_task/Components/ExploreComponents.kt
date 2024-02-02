package com.example.blackcoffer_intern_task.Components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DockedSearchBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.toRect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.blackcoffer_intern_task.R
import com.example.blackcoffer_intern_task.utils.customColors


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun customSearch() {
    var input by remember { mutableStateOf("") }
    var active by rememberSaveable { mutableStateOf(false) }

    Spacer(modifier = Modifier.size(10.dp))
    DockedSearchBar(
        colors = SearchBarDefaults.colors(containerColor = Color.White, dividerColor = Color.Black),
        modifier = Modifier
            .size(width = 300.dp, height = 50.dp)
            .border(
                1.dp,
                color = Color.Black,
                shape = SearchBarDefaults.dockedShape
            ),
        query = input,
        onQueryChange = { input = it },
        onSearch = { active = false },
        active = active,
        onActiveChange = {
            active = it
        },
        placeholder = {
            Text(
                text = "Search"
            )
        },
        leadingIcon = {
            Icon(
                imageVector = Icons.Filled.Search,
                contentDescription = null,
                tint = Color.Gray
            )
        },
        trailingIcon = {
            Icon(
                imageVector = Icons.Filled.MoreVert,
                contentDescription = null,
                tint = Color.Gray
            )
        }
    ) {

    }
}


@Composable
fun CustomCard() {
    OutlinedCard(
        colors = CardDefaults.cardColors(containerColor = Color.White),
        border = BorderStroke(0.1.dp, color = customColors.lightGray),
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
            .height(intrinsicSize = IntrinsicSize.Max)
            .shadow(5.dp, shape = CardDefaults.outlinedShape)
    ) {
        Row(
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.padding(5.dp)
        ) {

            Image(
                modifier = Modifier
                    .size(40.dp)
                    .offset(y = 10.dp)
                    .clip(shape = RoundedCornerShape(10.dp)),
                painter = painterResource(id = R.drawable.image),
                contentDescription = null
            )
            Spacer(modifier = Modifier.size(10.dp))
            Column(verticalArrangement = Arrangement.SpaceBetween) {
                Spacer(modifier = Modifier.size(10.dp))
                Text(
                    text = "Kshitiz Agarwal",
                    color = customColors.darknetclanBlue,
                    fontWeight = FontWeight.ExtraBold,
                    fontFamily = FontFamily.Monospace
                )
                Text(
                    text = "Ghaziabad | Student",
                    fontWeight = FontWeight.Light,
                    color = customColors.darknetclanBlue,
                    fontSize = 10.sp
                )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Within 2 KM",
                        fontWeight = FontWeight.Medium,
                        color = customColors.darknetclanBlue
                    )
                    FilledIconButton(
                        colors = IconButtonDefaults.iconButtonColors(
                            containerColor = customColors.netclanBlue,
                            contentColor = Color.White
                        ),
                        modifier = Modifier
                            .width(80.dp)
                            .height(30.dp),
                        onClick = { /*TODO*/ }) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                modifier = Modifier.size(17.dp),
                                imageVector = Icons.Default.Person,
                                contentDescription = null
                            )
                            Text(text = "invite")
                        }
                    }

                }
                Spacer(modifier = Modifier.size(10.dp))
                LinearProgressIndicator(
                    progress = { 0.4f },
                    modifier = Modifier
                        .width(50.dp)
                        .height(10.dp),
                    color = Color.Gray,
                    trackColor = customColors.lightGray,
                    strokeCap = StrokeCap.Round,
                )
                Spacer(modifier = Modifier.size(10.dp))
                Text(
                    text = "Coffee | Business | Academics",
                    fontWeight = FontWeight.Medium,
                    color = customColors.darknetclanBlue
                )
                Text(
                    text = "Hii community ! am open to new \nconnections " +
                            "\uD83D\uDE0A",
                    fontWeight = FontWeight.Light,
                    fontSize = 12.sp,
                    lineHeight = 14.sp,
                    color = customColors.darknetclanBlue
                )

            }
        }
    }
}


