//package com.example.musicappui_compose.ui.components
//
//import androidx.compose.animation.core.animateFloatAsState
//import androidx.compose.foundation.Canvas
//import androidx.compose.foundation.background
//import androidx.compose.foundation.border
//import androidx.compose.foundation.clickable
//import androidx.compose.foundation.gestures.detectTapGestures
//import androidx.compose.foundation.layout.Box
//import androidx.compose.foundation.layout.Spacer
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.height
//import androidx.compose.foundation.layout.offset
//import androidx.compose.foundation.layout.size
//import androidx.compose.foundation.layout.width
//import androidx.compose.foundation.layout.wrapContentSize
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.remember
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.draw.scale
//import androidx.compose.ui.geometry.CornerRadius
//import androidx.compose.ui.geometry.Offset
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.graphics.StrokeCap
//import androidx.compose.ui.graphics.drawscope.Stroke
//import androidx.compose.ui.input.pointer.pointerInput
//import androidx.compose.ui.platform.LocalDensity
//import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.unit.Dp
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import com.example.musicappui_compose.R
//
//@Composable
//fun CustomSwitch(
//    scale: Float,
//    width: Dp,
//    height: Dp,
//    strokeWidth: Dp,
//    checkedTrackColor: Color = Color(0xFF35898F),
//    uncheckedTrackColor: Color = Color(0xFFe0e0e0),
//    gapBetweenThumbAndTrackEdge: Dp
//) {
//
//    val switchON = remember {
//        mutableStateOf(true) // Initially the switch is ON
//    }
//
//    val thumbRadius = (height / 2) - gapBetweenThumbAndTrackEdge
//
//    // To move thumb, we need to calculate the position (along x axis)
//    val animatePosition = animateFloatAsState(
//        targetValue = if (switchON.value)
//            with(LocalDensity.current) { (width - thumbRadius - gapBetweenThumbAndTrackEdge).toPx() }
//        else
//            with(LocalDensity.current) { (thumbRadius + gapBetweenThumbAndTrackEdge).toPx() }
//    )
//
//    Canvas(
//        modifier = Modifier
//            .size(width = width, height = height)
//            .scale(scale = scale)
//            .pointerInput(Unit) {
//                detectTapGestures(
//                    onTap = {
//                        // This is called when the user taps on the canvas
//                        switchON.value = !switchON.value
//                    }
//                )
//            }
//    ) {
//        // Track
//        drawRoundRect(
//            color = if (switchON.value) checkedTrackColor else uncheckedTrackColor,
//            cornerRadius = CornerRadius( 20.dp.toPx()), //todo corner radius
//            style = Stroke(width = strokeWidth.toPx())/*x = 10.dp.toPx(), y = 10.dp.toPx()*/
//        )
//
//        // Thumb
//        drawCircle(
//            color = if (switchON.value) checkedTrackColor else uncheckedTrackColor,
//            radius = thumbRadius.toPx(),
//            center = Offset(
//                x = animatePosition.value,
//                y = size.height / 2
//            )
//        //painterResource(id = R.drawable.ic_account)
//        )
//
//
//    }
//
//    @Composable
//    fun DrawThumb() {
//        Canvas(
//            modifier = Modifier
//                .size(thumbRadius * 2)
//                .clip(CircleShape)
//        ) {
//            drawIntoCanvas { canvas ->
//                // Load the image based on the state of the switch
//                val imageResource = if (switchON.value) icon1 else icon2
//                val imagePainter = painterResource(imageResource)
//
//                // Calculate the size of the image (same as the diameter of the thumb)
//                val imageSize = thumbRadius * 2
//
//                // Draw the image onto the canvas with rounded corners
//                canvas.drawRoundRect(
//                    color = Color.Transparent,
//                    size = Size(imageSize.toPx(), imageSize.toPx()),
//                    cornerRadius = CornerRadius(imageSize.toPx() / 2)
//                )
//
//                // Clip the canvas to the rounded rectangle shape
//                canvas.clipRect(0f, 0f, imageSize.toPx(), imageSize.toPx())
//
//                // Draw the image onto the canvas with rounded corners
//                canvas.drawImage(
//                    painter = imagePainter,
//                    dstOffset = Offset.Zero,
//                    dstSize = Size(imageSize.toPx(), imageSize.toPx())
//                )
//            }
//        }
//    }
//
//    /*Spacer(modifier = Modifier.height(18.dp))
//
//    Text(text = if (switchON.value) "ON" else "OFF")*/
//}
