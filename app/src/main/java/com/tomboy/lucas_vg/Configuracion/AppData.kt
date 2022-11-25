package com.tomboy.lucas_vg.Configuracion

import android.app.Application
import androidx.room.Room

class AppData:Application() {
    companion object{
        lateinit var db:Data
    }

    override fun onCreate() {
        super.onCreate()
        db = Room.databaseBuilder(
            this,
            Data::class.java,
            "TomboyDB"
        ).build()
    }
}