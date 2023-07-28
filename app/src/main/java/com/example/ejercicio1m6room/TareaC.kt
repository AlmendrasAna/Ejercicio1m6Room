package com.example.ejercicio1m6room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "tarea_db")
data class TareaC (var nombreTarea :String){
    @PrimaryKey(autoGenerate = true) var id = 0L
}
