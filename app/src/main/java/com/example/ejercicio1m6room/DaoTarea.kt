package com.example.ejercicio1m6room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface DaoTarea {
@Insert
suspend fun insertarTarea(tareaC: TareaC)

@Query("select * from tarea_db order by id ASC ")
fun getTasks() : List<TareaC>

}