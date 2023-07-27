package com.example.ejercicio1m6room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class TareaC (val nombreTarea :String)
@PrimaryKey (autoGenerate = true)var id = 0L
