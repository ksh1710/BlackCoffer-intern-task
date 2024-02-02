package com.example.blackcoffer_intern_task.screens

import android.annotation.SuppressLint
import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Place
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SegmentedButtonColors
import androidx.compose.material3.SegmentedButtonDefaults
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Shapes
import androidx.compose.material3.SingleChoiceSegmentedButtonRow
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.startActivity
import com.example.blackcoffer_intern_task.Components.CustomCard
import com.example.blackcoffer_intern_task.Components.customSearch
import com.example.blackcoffer_intern_task.Components.navItem
import com.example.blackcoffer_intern_task.RefineActivity
import com.example.blackcoffer_intern_task.utils.customColors

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
@Preview
fun EntryScreen() {
    val options = mutableStateListOf<String>("Personal", "Business", "Merchant")
    var selectedIndex by remember {
        mutableStateOf(0)
    }
    val navItems = listOf(
        navItem(title = "Explore", icon = Icons.Default.Build),
        navItem(title = "Network", icon = Icons.Default.Build),
        navItem(title = "Chat", icon = Icons.Default.Build),
        navItem(title = "Contacts", icon = Icons.Default.Build),
        navItem(title = "Groups", icon = Icons.Default.Build)
    )
    val context = LocalContext.current
    Scaffold(modifier = Modifier.fillMaxSize(), containerColor = Color.White,
        topBar = {
            TopAppBar(
                navigationIcon = {
                    Icon(
                        modifier = Modifier.padding(top = 10.dp).size(40.dp),
                        tint = Color.White,
                        imageVector = Icons.Default.Menu,
                        contentDescription = null
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = customColors.darknetclanBlue),
                title = {
                    Column( verticalArrangement = Arrangement.Top, horizontalAlignment = Alignment.Start) {
                        Text(
                            modifier = Modifier.padding(10.dp),
                            text = "Hey, Kshitiz Agarwal !!",
                            color = Color.White,
                            fontSize = 17.sp
                        )
                        Row(
                            modifier = Modifier.offset(y = (-15).dp, x = 10.dp),
                            verticalAlignment = Alignment.CenterVertically,

                        ) {
                            Icon(
                                imageVector = Icons.Default.Place,
                                modifier = Modifier.size(15.dp),
                                contentDescription = null
                            )
                            Text(
                                fontSize = 10.sp,
                                text = "Phase-1, Muradnagar",
                                color = Color.White
                            )
                        }
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(70.dp),
                actions = {
                    Icon(
                        tint = Color.White, modifier = Modifier
                            .padding(end = 20.dp, top = 20.dp)
                            .clickable {
                                val intent = Intent(context, RefineActivity::class.java)
                                startActivity(context, intent, null)
                            }, imageVector = Icons.Default.Add, contentDescription = null
                    )
                }
            )
        },
        bottomBar = {
            NavigationBar(
                modifier = Modifier
                    .height(50.dp),
                containerColor = customColors.bottomWhite,
                contentColor = customColors.netclanBlue,
                tonalElevation = 50.dp,
            ) {
                navItems.forEachIndexed { index, navItem ->
                    NavigationBarItem(
                        colors = NavigationBarItemDefaults.colors(
                            disabledIconColor = customColors.netclanBlue,
                            disabledTextColor = customColors.netclanBlue,
                            selectedIconColor = customColors.darknetclanBlue,
                            selectedTextColor = customColors.darknetclanBlue,
                            unselectedIconColor = customColors.netclanBlue,
                            unselectedTextColor = customColors.netclanBlue
                        ),
                        selected = false,
                        onClick = {},
                        label = { Text(text = navItem.title) },
                        icon = {
                            Icon(
                                modifier = Modifier.offset(y = 7.dp),
                                imageVector = navItem.icon,
                                contentDescription = null
                            )
                        })
                }
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(top = 50.dp)
                .background(Color.White),
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            SingleChoiceSegmentedButtonRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 15.dp)
            ) {
                options.forEachIndexed { index, s ->
                    SegmentedButton(
                        modifier = Modifier.height(60.dp),
                        selected = selectedIndex == index,
                        onClick = { selectedIndex = index },
                        shape = RectangleShape,
                        colors = SegmentedButtonDefaults.colors(
                            disabledInactiveContainerColor = customColors.netclanBlue,
                            inactiveContainerColor = customColors.netclanBlue,
                            activeContainerColor = customColors.netclanBlue,
                            activeBorderColor = customColors.darknetclanBlue,
                            inactiveBorderColor = customColors.darknetclanBlue
                        ),
                        icon = {}
                    ) {
                        Text(text = s, color = Color.White)
                    }
                }
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                customSearch()
                Icon(imageVector = Icons.Default.Person, contentDescription = null)
            }

            LazyColumn {
                for (i in 1..10) {
                    item {
                        CustomCard()
                    }
                }
            }
        }
    }
}
