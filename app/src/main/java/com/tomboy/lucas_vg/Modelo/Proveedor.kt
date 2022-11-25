package com.tomboy.lucas_vg.Modelo

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Proveedor(
    @PrimaryKey(autoGenerate = true)
    var nroRuc: Long,
    var razonSocial: String,
    var descRubro: String,
    var direccion: String,
    var telefono: String
)
