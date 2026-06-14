package com.example.zadanie2

import android.R.attr.text
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.zadanie2.ui.theme.Zadanie2Theme
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Zadanie2Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Kalkulator(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Kalkulator(modifier: Modifier = Modifier) {

    var wynik by rememberSaveable{ mutableStateOf("0") }
    var wartosc1 by rememberSaveable { mutableStateOf("") }
    var wartosc2 by rememberSaveable { mutableStateOf("") }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ){
        TextField(
            value = wartosc1,
            onValueChange = {wartosc1 = it},
            label = {Text("Wprowadź pierwszą liczbę")},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)

        )

        Spacer(modifier = Modifier.height(8.dp))

        TextField(
            value = wartosc2,
            onValueChange = {wartosc2 = it},
            label = {Text("Wprowadź drugą liczbę")},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        Spacer(modifier = Modifier.height(8.dp))

        val w1 = wartosc1.toDoubleOrNull() ?: 0.0
        val w2 = wartosc2.toDoubleOrNull() ?: 0.0

        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ){
            Button(
                shape = RectangleShape,
                onClick = { wynik = (w1 + w2).toString() }
            ){
                Text(text = "+")
            }

            Button(
                shape = RectangleShape,
                onClick = { wynik = (w1 - w2).toString() }
            ){
                Text(text = "-")
            }

            Button(
                shape = RectangleShape,
                onClick = { wynik = (w1 * w2).toString()  }
            ){
                Text(text = "x")
            }

            Button(
                shape = RectangleShape,
                onClick = {
                    if(w2 == 0.0) {
                        wynik = "nie można dzielić przez 0"
                    }else{
                        wynik = (w1/w2).toString()
                    }
                }
            ){
                Text(text = "/")
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = wynik,
            fontSize = 40.sp,
            textAlign = TextAlign.Center,
        )
    }
}