import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.material.MaterialTheme
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import kotlin.random.Random

fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        MaterialTheme {
            val rememberMeState = remember { mutableStateOf(false) }
            val usernameState = remember { mutableStateOf("") }
            val passwordState = remember { mutableStateOf("") }
            var isButtonClicked by remember { mutableStateOf(false) }
            var buttonColor by remember { mutableStateOf(Color(0xFF4CAF50)) }

            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                OutlinedTextField(
                    value = usernameState.value,
                    onValueChange = { usernameState.value = it },
                    label = { Text("Username") },
                    keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Email),
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(16.dp))
                OutlinedTextField(
                    value = passwordState.value,
                    onValueChange = { passwordState.value = it },
                    label = { Text("Password") },
                    keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Password),
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(16.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Checkbox(
                        checked = rememberMeState.value,
                        onCheckedChange = { rememberMeState.value = it }
                    )
                    Text("Remember me")
                }
                Spacer(modifier = Modifier.height(16.dp))
                Button(
                    onClick = {
                        println("Logged in")
                        isButtonClicked = true
                        buttonColor = Color(Random.nextFloat(), Random.nextFloat(), Random.nextFloat())
                    },
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = if (isButtonClicked) buttonColor else Color(0xFF4CAF50),
                        contentColor = Color.White
                    )
                ) {
                    Text("Login")
                }
            }
        }
    }
}
