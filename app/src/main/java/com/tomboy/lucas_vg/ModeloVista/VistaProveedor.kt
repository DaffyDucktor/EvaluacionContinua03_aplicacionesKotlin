package com.tomboy.lucas_vg.ModeloVista

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tomboy.lucas_vg.Configuracion.AppData.Companion.db
import com.tomboy.lucas_vg.Modelo.Proveedor
import com.tomboy.lucas_vg.databinding.ActivityFrmProveedorBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class VistaProveedor:ViewModel() {
    val lista=MutableLiveData<List<Proveedor>?>()
    fun iniciar(){
        viewModelScope.launch {
            lista.value= withContext(Dispatchers.IO) {
                db.daoproveedor().ListarProveedor()
            }
        }
    }

    fun registrar(p:Proveedor){
        viewModelScope.launch {
            lista.value= withContext(Dispatchers.IO){
                db.daoproveedor().AgregarProveedor(arrayListOf<Proveedor>(
                    p
                ))
                db.daoproveedor().ListarProveedor()
            }
        }

    }

    fun buscarrazonsocial(cadena:String){
        viewModelScope.launch {
            lista.value= withContext(Dispatchers.IO){
                db.daoproveedor().buscarrazonsocial(cadena)
            }
        }
    }

    fun buscarnroruc(cod:Long, b: ActivityFrmProveedorBinding){
        viewModelScope.launch {
            val proveedor:Proveedor = withContext(Dispatchers.IO){
                db.daoproveedor().buscarnroruc(cod)
            }
            b.txtRaso.setText(proveedor.razonSocial.toString())
            b.txtDeru.setText(proveedor.descRubro.toString())
            b.txtDir.setText(proveedor.direccion.toString())
            b.txtTel.setText(proveedor.telefono.toString())
        }
    }}