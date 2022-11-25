package com.tomboy.lucas_vg.Configuracion

import androidx.room.Database
import androidx.room.RoomDatabase
import com.tomboy.lucas_vg.Interfaz.DaoProveedor
import com.tomboy.lucas_vg.Modelo.Proveedor

@Database(
    entities = [Proveedor::class],
    version = 1
)

abstract class Data:RoomDatabase() {
    abstract fun daoproveedor():DaoProveedor
}