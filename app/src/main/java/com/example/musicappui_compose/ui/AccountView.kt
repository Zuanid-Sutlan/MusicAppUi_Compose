package com.example.musicappui_compose.ui

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.musicappui_compose.R

@Composable
fun AccountView(pd: PaddingValues) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(pd)
    ) {


        var isDarkTheme by remember { mutableStateOf(false) }

        ThemeSwitch(
            isChecked = isDarkTheme,
            onCheckedChange = { isChecked ->
                isDarkTheme = isChecked
                // Apply your theme change logic here
            }
        )



        

//        Switch2()
        Row(modifier = Modifier.padding(20.dp)) {
            /*CustomSwitch(
                scale = 1f,
                width = 108.dp,
                height = 32.dp,
                strokeWidth = 1.dp,
                gapBetweenThumbAndTrackEdge = 1.dp
            )*/

            Spacer(modifier = Modifier.width(10.dp))

            /*CustomSwitchUpdated(
                scale = 1f,
                width = 108.dp,
                height = 32.dp,
                strokeWidth = 1.dp,
                gapBetweenThumbAndTrackEdge = 0.dp,
                checkedIcon = Icons.Filled.AccountCircle,
                uncheckedIcon = Icons.Filled.AddCircle
            ) {

            }*/
        }


        DoubleTextItem(title = "Sultan Developer", desc = "Test app with fill ui and little backend mainly focus in ui")
        Divider()
        SingleTextItem(title = "Favorite Musics")
        Divider()
    }
}

@Composable
fun DoubleTextItem(title: String, desc: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 2.dp, top = 2.dp),
        horizontalArrangement = Arrangement.Absolute.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(imageVector = Icons.Default.AccountCircle, contentDescription = null, tint = Color.Black)
        Row {

            Spacer(modifier = Modifier.width(4.dp))

            Column(modifier = Modifier.fillMaxWidth(0.9f)) {
                Text(text = title, color = Color.Black)
                Text(text = desc, color = Color.Black)
            }
        }
        Icon(imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight, contentDescription = null, tint = Color.Black)

    }
}

@Composable
fun SingleTextItem(title: String) {
    Row(
        modifier = Modifier
            .padding(bottom = 2.dp, top = 2.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(painter = painterResource(id = R.drawable.ic_music), contentDescription = null, tint = Color.Black)

        Spacer(modifier = Modifier.width(4.dp))

        Text(text = title, color = Color.Black)
    }

}

@Composable
fun ThemeSwitch(
    isChecked: Boolean,
    onCheckedChange: (Boolean) -> Unit
) {
    Row(
        modifier = Modifier
            .padding(8.dp)
            .clickable(onClick = { onCheckedChange(!isChecked) }),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = "Dark Theme", style = TextStyle(color = Color.Black))
        Box(modifier = Modifier
            .size(width = 100.dp, height = 45.dp)
        ){
            Switch(
                modifier = Modifier
                    .width(70.dp)
                    .height(45.dp)
                    .size(width = 80.dp, height = 45.dp),
                thumbContent = {
                    if (isChecked){
                        Icon(imageVector = Icons.Default.Done, contentDescription = null)
                    }else{
                        Icon(imageVector = Icons.Default.Close, contentDescription = null)
                    }
                },
                checked = isChecked,
                onCheckedChange = onCheckedChange,
                colors = SwitchDefaults.colors(
                    checkedThumbColor = Color.Blue,
                    checkedTrackColor = Color.LightGray,
                    uncheckedThumbColor = Color.Gray,
                    uncheckedTrackColor = Color.LightGray
                )
            )
        }

        Text(text = "Light Theme", style = TextStyle(color = Color.Black))
    }
}


@Composable
fun Switch2(
    scale: Float = 2f,
    width: Dp = 36.dp,
    height: Dp = 20.dp,
    strokeWidth: Dp = 2.dp,
    checkedTrackColor: Color = Color(0xFF35898F),
    uncheckedTrackColor: Color = Color(0xFFe0e0e0),
    gapBetweenThumbAndTrackEdge: Dp = 4.dp
) {

    val switchON = remember {
        mutableStateOf(true) // Initially the switch is ON
    }

    val thumbRadius = (height / 2) - gapBetweenThumbAndTrackEdge

    // To move thumb, we need to calculate the position (along x axis)
    val animatePosition = animateFloatAsState(
        targetValue = if (switchON.value)
            with(LocalDensity.current) { (width - thumbRadius - gapBetweenThumbAndTrackEdge).toPx() }
        else
            with(LocalDensity.current) { (thumbRadius + gapBetweenThumbAndTrackEdge).toPx() }
    )

    Canvas(
        modifier = Modifier
            .size(width = width, height = height)
            .scale(scale = scale)
            .pointerInput(Unit) {
                detectTapGestures(
                    onTap = {
                        // This is called when the user taps on the canvas
                        switchON.value = !switchON.value
                    }
                )
            }
    ) {
        // Track
        drawRoundRect(
            color = if (switchON.value) checkedTrackColor else uncheckedTrackColor,
            cornerRadius = CornerRadius(x = 10.dp.toPx(), y = 10.dp.toPx()),
            style = Stroke(width = strokeWidth.toPx())
        )

        // Thumb
        drawCircle(
            color = if (switchON.value) checkedTrackColor else uncheckedTrackColor,
            radius = thumbRadius.toPx(),
            center = Offset(
                x = animatePosition.value,
                y = size.height / 2
            )
        )
    }

    Spacer(modifier = Modifier.height(18.dp))

    Text(text = if (switchON.value) "ON" else "OFF")
}
