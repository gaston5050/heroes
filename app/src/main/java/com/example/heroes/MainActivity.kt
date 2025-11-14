package com.example.heroes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.heroes.model.HeroesRepositorio

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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Display() {
    Scaffold(
        topBar = {


            CenterAlignedTopAppBar(
            title = {
                Text (stringResource(R.string.app_name),
                    style = MaterialTheme.typography.headlineLarge

                    )
              }
            )
        }
    ){ innerPadding ->
        ListadoraHeroes(heroe = HeroesRepositorio.HeroesAll,
        modifier = Modifier.padding(innerPadding)
        )


    }
}

@Composable
fun Registro(heroe: Heroe, modifier: Modifier = Modifier){
    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        colors = CardDefaults.cardColors(

            containerColor = MaterialTheme.colorScheme.tertiary
        ),
        modifier = Modifier.padding(3.dp)
    ){
        Row(modifier = Modifier
            .height(110.dp)
            .fillMaxWidth()
            .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ){

           Informacion(nombre = heroe.nombre, descripcion = heroe.descripcion,
               modifier = Modifier.weight(1f))
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
    Column(modifier = modifier) {
        Text(
            text = stringResource(id =nombre),
            style = MaterialTheme.typography.displaySmall)
        Text(
            text = stringResource(id = descripcion),
            style = MaterialTheme.typography.bodyLarge
        )


    }

}
@Composable
fun Foto(@DrawableRes foto: Int){
    Box (modifier = Modifier
        .height(72.dp)
        .width(72.dp)
        ){
    Image(
        modifier = Modifier.clip(MaterialTheme.shapes.small),
        contentScale = ContentScale.Crop,
        painter = painterResource(id = foto),

        contentDescription = null,


    )
}
}
@Composable
fun ListadoraHeroes(heroe: List<Heroe>, modifier: Modifier = Modifier){
    LazyColumn(modifier = modifier){
        items(heroe){
            Registro(heroe = it)
        }
    }
}




@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DisplayPreview() {
    HeroesTheme {
        Display()
       //ListadoraHeroes(heroe = HeroesRepositorio.HeroesAll)
       // Registro(heroe = Heroe(R.string.hero1, R.string.description1, R.drawable.android_superhero1))
    }
}
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DisplayDarkPreview() {
    HeroesTheme(darkTheme = true) {
        Display()
        //ListadoraHeroes(heroe = HeroesRepositorio.HeroesAll)
        // Registro(heroe = Heroe(R.string.hero1, R.string.description1, R.drawable.android_superhero1))
    }
}
