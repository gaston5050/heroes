package com.example.heroes.model

import androidx.annotation.StringRes
import com.example.heroes.R

data class Heroe(
    @StringRes var nombre: Int,
    @StringRes var descripcion: Int,
    @StringRes var imagen: Int)

