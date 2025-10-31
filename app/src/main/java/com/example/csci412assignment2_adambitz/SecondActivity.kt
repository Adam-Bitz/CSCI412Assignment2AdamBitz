package com.example.csci412assignment2_adambitz

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.example.csci412assignment2_adambitz.ui.theme.CSCI412Assignment2AdamBitzTheme

class SecondActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CSCI412Assignment2AdamBitzTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.White
                ){
                    Greeting2(
                        context = LocalContext.current
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting2(modifier: Modifier = Modifier, context: Context) {
    val returnIntent = Intent(context, MainActivity::class.java)
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        Text("5 challenges of mobile development are:\n" +
                "1. There are a large number of device configurations and specifications in circulation. \n" +
                "2. The Operating system is rapidly updating and changing. \n" +
                "3. There are many different versions of the mobile Operating Systems in use. \n" +
                "4. Emulators and Simulators provide a suboptimal testing environment. \n" +
                "5. The market for apps is very competitive with a fickle userbase. \n")
        Button(
            onClick = { context.startActivity(returnIntent) }
        ) {
            Text(
                text = "Main Activity"
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Greeting2Preview() {
    CSCI412Assignment2AdamBitzTheme {
        Greeting2(
            context = LocalContext.current
        )
    }
}