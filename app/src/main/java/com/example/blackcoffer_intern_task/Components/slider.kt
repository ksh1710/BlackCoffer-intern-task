package com.example.blackcoffer_intern_task.Components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderColors
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.blackcoffer_intern_task.utils.customColors

@Composable
fun SliderWithLabel(
    value: Float,
    valueRange: ClosedFloatingPointRange<Float>,
    finiteEnd: Boolean,
    labelMinWidth: Dp = 24.dp
) {
    var sliderPosition by remember { mutableStateOf(value) }

    Column {
        BoxWithConstraints(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            val offset = getSliderOffset(
                value = sliderPosition,
                valueRange = valueRange,
                boxWidth = maxWidth,
                labelWidth = labelMinWidth + 8.dp
            )

            val endValueText = if (!finiteEnd && sliderPosition >= valueRange.endInclusive)
                "${sliderPosition.toInt()} +" else sliderPosition.toInt().toString()

//            SliderLabel(label = valueRange.start.toInt().toString(), minWidth = labelMinWidth)

            if (sliderPosition > valueRange.start) {
                SliderLabel(
                    label = endValueText,
                    minWidth = labelMinWidth,
                    modifier = Modifier
                        .padding(start = offset),

                )
            }
        }

        Slider(
            value = sliderPosition,
            onValueChange = {
                sliderPosition = it
            },
            valueRange = valueRange,
            modifier = Modifier.fillMaxWidth(),
            colors = SliderDefaults.colors(
                inactiveTrackColor = Color.Gray,
                activeTrackColor = customColors.netclanBlue,
                thumbColor = customColors.netclanBlue
            )
        )
    }
}

@Composable
fun SliderLabel(
    label: String,
    minWidth: Dp,
    modifier: Modifier = Modifier
) {
    Text(
        text = label,
        textAlign = TextAlign.Center,
        color = Color.White,
        modifier = modifier
            .background(
                color = customColors.netclanBlue,
                shape = RoundedCornerShape(4.dp)
            )
            .padding(4.dp)
            .defaultMinSize(minWidth = minWidth)
    )
}

private fun getSliderOffset(
    value: Float,
    valueRange: ClosedFloatingPointRange<Float>,
    boxWidth: Dp,
    labelWidth: Dp
): Dp {
    val coerced = value.coerceIn(valueRange.start, valueRange.endInclusive)
    val positionFraction = calcFraction(valueRange.start, valueRange.endInclusive, coerced)

    return (boxWidth - labelWidth) * positionFraction
}

private fun calcFraction(a: Float, b: Float, pos: Float) =
    (if (b - a == 0f) 0f else (pos - a) / (b - a)).coerceIn(0f, 1f)