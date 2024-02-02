package com.example.blackcoffer_intern_task.screens

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalMapOf
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.widget.AutoSizeableTextView
import com.example.blackcoffer_intern_task.Components.AutoSizableTextField
import com.example.blackcoffer_intern_task.Components.SliderWithLabel
import com.example.blackcoffer_intern_task.Components.customSearch
import com.example.blackcoffer_intern_task.utils.customColors

@OptIn(
    ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class,
    ExperimentalLayoutApi::class
)
@Composable
@Preview
fun RefineScreen() {
    var isInSelectionMode by remember {
        mutableStateOf(false)
    }
    val sliderpos = remember {
        mutableStateOf(20f)
    }
    val context = LocalContext.current
    val selectedItems = listOf(
        "Coffee",
        "Business",
        "Hobbies",
        "Friendship",
        "Movies",
        "Dining",
        "Dating",
        "Matrimony"
    )
    var text by remember { mutableStateOf("") }
    var mExpanded by remember { mutableStateOf(false) }
    val mItems = listOf(
        "Available | Hey Let Us Connect",
        "Away | Stay Discrete And Watch",
        "Busy | DND | Will Catch Up Later",
        "SOS | Emergency! Need Assistance!",
    )
    var mSelectedText by remember { mutableStateOf("Available | Hey Let Us Connect") }

    Scaffold(
        topBar = {
            TopAppBar(
                modifier = Modifier.height(50.dp),
                title = {
                    Text(modifier = Modifier.offset(x = 20.dp, y = 10.dp), text = "Refine")
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = customColors.netclanBlue,
                    titleContentColor = Color.White
                ),
                navigationIcon = {
                    Icon(
                        modifier = Modifier
                            .offset(y = 5.dp)
                            .size(40.dp),
                        imageVector = Icons.Default.KeyboardArrowLeft,
                        contentDescription = null,
                        tint = Color.White
                    )
                }
            )
        },
        modifier = Modifier
            .fillMaxSize(),
        containerColor = Color.White
    ) {
        Column(modifier = Modifier.padding(it)) {
            Column(modifier = Modifier.padding(20.dp)) {
                Spacer(modifier = Modifier.size(10.dp))

                Text(
                    fontSize = 13.sp,
                    color = customColors.darknetclanBlue,
                    text = "Select Your availability",
                    fontWeight = FontWeight.Medium
                )

                ExposedDropdownMenuBox(
                    expanded = mExpanded,
                    onExpandedChange = {
                        mExpanded = !mExpanded
                    },
                    modifier = Modifier
                        .clip(shape = RoundedCornerShape(10.dp))
                        .border(1.dp, Color.Black, shape = RoundedCornerShape(10.dp))
                ) {
                    TextField(
                        value = mSelectedText,
                        onValueChange = {},
                        readOnly = true,
                        trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = mExpanded) },
                        modifier = Modifier.menuAnchor(),
                        colors = TextFieldDefaults.colors(
                            focusedContainerColor = Color.White,
                            unfocusedContainerColor = Color.White,
                            unfocusedTextColor = customColors.netclanBlue,
                            focusedTextColor = customColors.netclanBlue,
                            cursorColor = customColors.netclanBlue,
                            focusedLabelColor = Color.Red,
                            unfocusedLabelColor = Color.Red,
                            focusedLeadingIconColor = customColors.darknetclanBlue,
                            unfocusedLeadingIconColor = customColors.darknetclanBlue,
                            unfocusedIndicatorColor = customColors.netclanBlue,
                            focusedIndicatorColor = customColors.netclanBlue,
                            focusedTrailingIconColor = customColors.netclanBlue,
                            unfocusedTrailingIconColor = customColors.netclanBlue
                        ),

                        shape = RoundedCornerShape(20.dp)
                    )
                    ExposedDropdownMenu(
                        expanded = mExpanded,
                        onDismissRequest = { mExpanded = false }
                    ) {
                        mItems.forEach { item ->
                            DropdownMenuItem(
                                text = { Text(text = item) },
                                onClick = {
                                    mSelectedText = item
                                    mExpanded = false
                                    Toast.makeText(context, item, Toast.LENGTH_SHORT).show()
                                }
                            )
                        }
                    }
                }
                Spacer(modifier = Modifier.size(20.dp))
                Text(
                    fontSize = 13.sp,
                    text = "Add Your Status",
                    color = customColors.darknetclanBlue,
                    fontWeight = FontWeight.Medium
                )
                AutoSizableTextField(
                    value = text,
                    onValueChange = { text = it },
                    minFontSize = 10.sp,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(100.dp)
                )
                Spacer(modifier = Modifier.size(20.dp))
                Text(
                    fontSize = 13.sp,
                    text = "Select Hyper local Distance",
                    color = customColors.darknetclanBlue,
                    fontWeight = FontWeight.Medium
                )
                Spacer(modifier = Modifier.size(20.dp))
                SliderWithLabel(
                    value = sliderpos.value,
                    finiteEnd = true,
                    valueRange = 1f..100f
                )
                Spacer(modifier = Modifier.size(20.dp))
                Text(
                    fontSize = 13.sp,
                    text = "Select Purpose",
                    color = customColors.darknetclanBlue,
                    fontWeight = FontWeight.Medium
                )
                FlowRow(
                    horizontalArrangement = Arrangement.spacedBy(20.dp),
                    maxItemsInEachRow = 3
                ) {
                    selectedItems.forEach { selectedItem ->
                        AssistChip(
                            onClick = { /*TODO*/ },
                            colors = AssistChipDefaults.assistChipColors(
                                containerColor = Color.White,
                                labelColor = customColors.netclanBlue,
                            ),
                            label = { Text(text = selectedItem) })
                    }
                }
                Spacer(modifier = Modifier.size(20.dp))
                Row(
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Button(
                        onClick = { /*TODO*/ },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = customColors.netclanBlue,
                            contentColor = Color.White
                        )
                    ) {
                        Text(text = "Save & Explore")
                    }
                }
            }
        }
    }
}