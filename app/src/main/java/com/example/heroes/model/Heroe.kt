package com.example.heroes.model

import androidx.annotation.StringRes

data class Heroe(
    @StringRes var nombre: String,
    @StringRes var descripcion: String,
    @StringRes var imagen: String)
