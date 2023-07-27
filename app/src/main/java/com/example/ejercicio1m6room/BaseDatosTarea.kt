package com.example.ejercicio1m6room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database (entities =[TareaC::class], version =1)
abstract class BaseDatosTarea: RoomDatabase() {
    abstract fun getDaoTarea(): DaoTarea


    companion object {
        @Volatile
        private var INSTANCE: BaseDatosTarea? = null

        fun getDatabase(context: Context):BaseDatosTarea {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    BaseDatosTarea::class.java,
                    "TareaBD"
                ).build()

                INSTANCE = instance
                return instance
            }
        }
    }
}