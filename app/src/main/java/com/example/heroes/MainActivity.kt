package com.example.heroes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.heroes.ui.theme.HeroesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HeroesTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Display()
                }
            }
        }
    }
}

@Composable
fun Display() {
    Registro()
}

@Composable
fun Registro(modifier: Modifier = Modifier){

    Card(modifier = modifier.padding(8.dp).fillMaxWidth()){
        Row{
            Column{
                Text(text = "Nombre")
                Text(text = "Descripcion")

            }
            Image(modifier = Modifier.height(72.dp),
                painter = painterResource(R.drawable.android_superhero1),
                contentDescription = null,
            )
        }
    }
}
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DisplayPreview() {
    HeroesTheme {
        Display()
    }
}
