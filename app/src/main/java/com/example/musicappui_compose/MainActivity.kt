package com.example.musicappui_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.musicappui_compose.ui.MainView
import com.example.musicappui_compose.ui.theme.MusicAppUi_ComposeTheme
import com.example.musicappui_compose.ui.theme.Purple40
import com.example.musicappui_compose.ui.theme.Purple80
import com.example.musicappui_compose.ui.theme.PurpleGrey40
import com.example.musicappui_compose.ui.theme.PurpleGrey80

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MusicAppUi_ComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainView()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    // Load your image (replace with actual image resource or URL)
    val imagePainter = painterResource(R.drawable.ic_account)
    MusicAppUi_ComposeTheme {
        var isDarkTheme by remember { mutableStateOf(false) }



        Canvas(modifier = Modifier.fillMaxSize()) {
            val canvasWidth = size.width
            val canvasHeight = size.height

            // Draw a red circle
            drawCircle(
                color = Color.Red,
                center = Offset(x = canvasWidth / 2, y = canvasHeight / 2),
                radius = size.minDimension / 4
            )



            // Calculate the position and size for the circular image
            val imageSize = size.minDimension / 2
            val imageOffset = Offset(x = canvasWidth / 2 - imageSize / 2, y = canvasHeight / 2 - imageSize / 2)

            // Clip the image to the circular shape
            /*drawImage(
                painter = imagePainter,
                contentDescription = "avatar",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(imageSize)
                    .offset(imageOffset)
                    .clip(CircleShape)
            )*/


        }




    }
}