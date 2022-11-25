package com.tomboy.lucas_vg.Interfaz

import androidx.room.*
import com.tomboy.lucas_vg.Modelo.Proveedor

@Dao
interface DaoProveedor {

    @Query("SELECT * FROM Proveedor")
    suspend fun ListarProveedor():List<Proveedor>

    @Query("Select * from Proveedor where razonSocial LIKE '%' || :cadena || '%'")
    fun buscarrazonsocial(cadena:String):List<Proveedor>

    @Query("Select * from Proveedor where nroRuc = :ruc")
    fun buscarnroruc(ruc:Long):Proveedor

    @Insert
    suspend fun AgregarProveedor(proveedores:List<Proveedor>):List<Long>

    @Delete
    suspend fun EliminarProveedor(proveedor:Proveedor):Int

    @Update
    suspend fun ActualizarProveedor(proveedor:Proveedor):Int
}