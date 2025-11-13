package com.example.heroes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.heroes.model.Heroe
import com.example.heroes.ui.theme.HeroesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HeroesTheme {

                    Display()

            }
        }
    }
}

@Composable
fun Display() {

}

@Composable
fun Registro(heroe: Heroe, modifier: Modifier = Modifier){
    Card(
        colors = CardDefaults.cardColors(

            containerColor = MaterialTheme.colorScheme.inverseOnSurface
        )
    ){
        Row(modifier = Modifier
            .height(72.dp)
            .fillMaxWidth()
            .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ){

           Informacion(nombre = heroe.nombre, descripcion = heroe.descripcion)
            Foto(heroe.imagen)
        }


    }

}

//Composable que contiene la informacion del superheroe
@Composable
fun Informacion(
    @StringRes nombre: Int,
    @StringRes descripcion: Int,
    modifier: Modifier = Modifier
){
    Column() {
        Text(
            text = nombre.toString(),
            style = MaterialTheme.typography.displayMedium)
        Text(
            text = descripcion.toString(),
            style = MaterialTheme.typography.bodyLarge
        )


    }

}
@Composable
fun Foto(@StringRes foto: Int){
    Image(
        painter = painterResource(id = foto),
        contentDescription = null,
    )
}

@Preview(showBackground = true)
@Composable
fun DisplayPreview() {
    HeroesTheme {
        Registro(heroe = Heroe(R.string.hero1, R.string.description1, R.drawable.android_superhero1))
    }
}
