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

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CSCI412Assignment2AdamBitzTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.White
                ){
                    Greeting(
                        context = LocalContext.current
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(modifier: Modifier = Modifier, context: Context) {
    val explicitIntent = Intent(context, SecondActivity::class.java)
    val implicitIntent = Intent(Intent.ACTION_MAIN)
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        Button(
            onClick = { context.startActivity(explicitIntent) }
        ) {
            Text(
                text = "Start Activity Explicitly"
            )
        }
        Button(
            onClick = { context.startActivity(implicitIntent) }
        ) {
            Text(
                text = "Start Activity Implicitly"
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CSCI412Assignment2AdamBitzTheme {
        Greeting(
            context = LocalContext.current
        )
    }
}