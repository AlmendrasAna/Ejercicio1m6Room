package com.example.ejercicio1m6room

import androidx.lifecycle.LiveData

class RepositorioTarea(private val daoTarea :DaoTarea) {
    suspend fun insertarTarea(tareac: TareaC){
        daoTarea.insertarTarea(tareac)
    }

    fun listarTarea ():LiveData<List<TareaC>>{
        return daoTarea.listarTarea()
    }

}