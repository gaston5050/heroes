package com.example.heroes.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.heroes.R

data class Heroe(
    @StringRes var nombre: Int,
    @StringRes var descripcion: Int,
    @DrawableRes var imagen: Int)

