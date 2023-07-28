package com.example.ejercicio1m6room
import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class ViewModel(aplicacion : Application) : AndroidViewModel(aplicacion){
    private val repositorio:RepositorioTarea
    init{
        repositorio = RepositorioTarea(BaseDatosTarea.getDatabase(aplicacion).getDaoTarea())
    }

    fun obtenerTarea(): LiveData<List<TareaC>>{
        return repositorio.listarTarea()
    }
    fun insertarTareas(tareaC: TareaC)=viewModelScope.launch{
        repositorio.insertarTarea(tareaC)

    }

}