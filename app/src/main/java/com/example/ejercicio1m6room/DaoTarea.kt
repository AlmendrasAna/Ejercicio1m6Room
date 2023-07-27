package com.example.ejercicio1m6room

import androidx.room.Dao
import androidx.room.Insert

@Dao
interface DaoTarea {
@Insert
suspend fun insertarTarea(tareaC: TareaC)
}