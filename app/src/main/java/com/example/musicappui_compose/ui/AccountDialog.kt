package com.example.musicappui_compose.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.AlertDialog
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.DialogProperties

@Composable
fun AccountDialog(showDialog: MutableState<Boolean>) {

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    /*var passwordToggle by remember { mutableStateOf(false) }

    var passwordTransformation = if (passwordToggle) {
        VisualTransformation.None
    }
    else {
        VisualTransformation.Password
    }*/

    if (showDialog.value) {
        AlertDialog(
            onDismissRequest = {
                showDialog.value = false
                email = ""
                password = ""
            },
            confirmButton = {
                TextButton(onClick = { showDialog.value = false }) {
                    Text(text = "Confirm")
                }
            },
            dismissButton = {
                TextButton(onClick = { showDialog.value = false }) {
                    Text(text = "Dismiss")
                }
            },
            title = { Text(text = "Add Account") },
            text = {
                Column(
                    modifier = Modifier
                        .wrapContentHeight()
                        .padding(2.dp)
                        .fillMaxWidth(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    TextField(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color.Transparent),//.padding(16.dp)
                        colors =  TextFieldDefaults.textFieldColors(backgroundColor = Color.Transparent) ,
                        value = email,
                        onValueChange = { email = it },
                        placeholder = { Text(text = "xyz@xyz.com") },
                        keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Email)
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    TextField(
                        modifier = Modifier.fillMaxWidth(),//.padding(8.dp)
                        value = password,
                        onValueChange = { password = it },
                        placeholder = { Text(text = "Xyz@1234") },
                        colors = TextFieldDefaults.textFieldColors(backgroundColor = Color.Transparent),
                        keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Password),
                    )
                }
            },
            properties = DialogProperties(
                dismissOnBackPress = true,
                dismissOnClickOutside = true
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            shape = RoundedCornerShape(8.dp)
        )
    }
}
