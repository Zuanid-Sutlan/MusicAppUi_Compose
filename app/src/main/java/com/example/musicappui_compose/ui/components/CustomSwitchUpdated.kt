package com.example.musicappui_compose.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun CustomSwitchUpdated(
    scale: Float,
    width: Dp,
    height: Dp,
    strokeWidth: Dp,
    checkedTrackColor: Color = Color(0xFF35898F),
    uncheckedTrackColor: Color = Color(0xFFe0e0e0),
    checkedTrackBorderColor: Color = Color(0xFF35898F),
    uncheckedTrackBorderColor: Color = Color(0xFFe0e0e0),
    thumbRadius: Dp = height / 2,
    gapBetweenThumbAndTrackEdge: Dp,
    checkedIcon: ImageVector,
    uncheckedIcon: ImageVector,
    onCheckedChange: (Boolean) -> Unit
) {
    val switchOn = remember { mutableStateOf(false) }

    Layout(
        content = {
            Box(
                modifier = Modifier
                    .wrapContentSize()
                    .size(width = width, height = height)
                    .background(
                        color = if (switchOn.value) checkedTrackColor else uncheckedTrackColor,
                        shape = RoundedCornerShape(height / 2)
                    )
                    .border(
                        width = strokeWidth,
                        color = if (switchOn.value) checkedTrackBorderColor else uncheckedTrackBorderColor,
                        shape = RoundedCornerShape(height / 2),
//                        cap = StrokeCap.Square
                    )
            ) {
                Box(
                    modifier = Modifier
                        .size(height)
                        .offset(
                            x = if (switchOn.value) (width - height) else 0.dp,
                            y = 0.dp
                        )
                        .background(
                            color = if (switchOn.value) checkedTrackColor else uncheckedTrackColor,
                            shape = RoundedCornerShape(height / 2)
                        )
                        .border(
                            width = strokeWidth,
                            color = if (switchOn.value) checkedTrackBorderColor else uncheckedTrackBorderColor,
                            shape = RoundedCornerShape(height / 2),
//                            cap = StrokeCap.Square
                        )
                        .clickable {
                            switchOn.value = !switchOn.value
                            onCheckedChange(switchOn.value)
                        }
                )
                Box(
                    modifier = Modifier
                        .size(height)
                        .offset(
                            x = if (switchOn.value) (width - height) else 0.dp,
                            y = 0.dp
                        )
                        .background(
                            color = Color.Transparent,
                            shape = RoundedCornerShape(height / 2)
                        )
                        .clickable {
                            switchOn.value = !switchOn.value
                            onCheckedChange(switchOn.value)
                        }
                )
                Box(
                    modifier = Modifier
                        .size(height - (strokeWidth * 2))
                        .offset(
                            x = if (switchOn.value) (width - height) else 0.dp,
                            y = strokeWidth
                        )
                        .background(
                            color = Color.White,
                            shape = RoundedCornerShape(height / 2)
                        )
                        .clickable {
                            switchOn.value = !switchOn.value
                            onCheckedChange(switchOn.value)
                        }
                )
                Box(
                    modifier = Modifier
                        .size(height - (strokeWidth * 2))
                        .offset(
                            x = if (switchOn.value) (width - (height * 2) + (strokeWidth * 2)) else 0.dp,
                            y = strokeWidth
                        )
                        .background(
                            color = Color.White,
                            shape = RoundedCornerShape(height / 2)
                        )
                        .clickable {
                            switchOn.value = !switchOn.value
                            onCheckedChange(switchOn.value)
                        }
                )
                Box(
                    modifier = Modifier
                        .size(height - (strokeWidth * 4))
                        .offset(
                            x = if (switchOn.value) (width - (height * 3) + (strokeWidth * 2)) else (strokeWidth * 2),
                            y = strokeWidth * 2
                        )
                        .background(
                            color = Color.Gray,
                            shape = RoundedCornerShape(height / 2)
                        )
                        .clickable {
                            switchOn.value = !switchOn.value
                            onCheckedChange(switchOn.value)
                        }
                )
                Box(
                    modifier = Modifier
                        .size(height - (strokeWidth * 6))
                        .offset(
                            x = if (switchOn.value) (width - (height * 3) + (strokeWidth * 2)) else (strokeWidth * 2),
                            y = strokeWidth * 3
                        )
                        .background(
                            color = if (switchOn.value) Color.Gray else Color.White,
                            shape = RoundedCornerShape(height / 2)
                        )
                        .clickable {
                            switchOn.value = !switchOn.value
                            onCheckedChange(switchOn.value)
                        }
                )
                Box(
                    modifier = Modifier
                        .size(height - (strokeWidth * 8))
                        .offset(
                            x = if (switchOn.value) (width - (height * 3) + (strokeWidth * 2)) else (strokeWidth * 2),
                            y = strokeWidth * 4
                        )
                        .background(
                            color = if (switchOn.value) Color.White else Color.Gray,
                            shape = RoundedCornerShape(height / 2)
                        )
                        .clickable {
                            switchOn.value = !switchOn.value
                            onCheckedChange(switchOn.value)
                        }
                )
                Box(
                    modifier = Modifier
                        .size(height - (strokeWidth * 10))
                        .offset(
                            x = if (switchOn.value) (width - (height * 3) + (strokeWidth * 2)) else (strokeWidth * 2),
                            y = strokeWidth * 5
                        )
                        .background(
                            color = if (switchOn.value) Color.White else Color.Gray,
                            shape = RoundedCornerShape(height / 2)
                        )
                        .clickable {
                            switchOn.value = !switchOn.value
                            onCheckedChange(switchOn.value)
                        }
                )
                Box(
                    modifier = Modifier
                        .size(height - (strokeWidth * 12))
                        .offset(
                            x = if (switchOn.value) (width - (height * 3) + (strokeWidth * 2)) else (strokeWidth * 2),
                            y = strokeWidth * 6
                        )
                        .background(
                            color = if (switchOn.value) Color.White else Color.Gray,
                            shape = RoundedCornerShape(height / 2)
                        )
                        .clickable {
                            switchOn.value = !switchOn.value
                            onCheckedChange(switchOn.value)
                        }
                )
                Box(
                    modifier = Modifier
                        .size(height - (strokeWidth * 14))
                        .offset(
                            x = if (switchOn.value) (width - (height * 3) + (strokeWidth * 2)) else (strokeWidth * 2),
                            y = strokeWidth * 7
                        )
                        .background(
                            color = if (switchOn.value) Color.White else Color.Gray,
                            shape = RoundedCornerShape(height / 2)
                        )
                        .clickable {
                            switchOn.value = !switchOn.value
                            onCheckedChange(switchOn.value)
                        }
                )
            }
        }
    ) { measurables, constraints ->
        layout(
            width = constraints.maxWidth,
            height = constraints.maxHeight
        ) {
            val placeables = measurables.map { measurable ->
                measurable.measure(constraints)
            }
            if (placeables.size >= 2) {
                val trackPlaceable = placeables[0]
                val thumbPlaceable = placeables[1]

                val thumbY = (trackPlaceable.height - thumbPlaceable.height) / 2

                trackPlaceable.place(0, 0)
                thumbPlaceable.place(
                    x = if (switchOn.value) (trackPlaceable.width - thumbPlaceable.width) else 0,
                    y = thumbY
                )
            }
            /*val placeables = measurables.map { measurable ->
                measurable.measure(constraints)
            }

            val trackPlaceable = placeables[0]
            val thumbPlaceable = placeables[1]

            val thumbY = (trackPlaceable.height - thumbPlaceable.height) / 2

            trackPlaceable.place(0, 0)
            thumbPlaceable.place(
                x = if (switchOn.value) (trackPlaceable.width - thumbPlaceable.width) else 0,
                y = thumbY
            )*/
        }
    }
}
