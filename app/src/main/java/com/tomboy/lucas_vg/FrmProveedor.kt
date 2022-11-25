package com.tomboy.lucas_vg

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.view.View
import androidx.lifecycle.get
import com.tomboy.lucas_vg.Modelo.Proveedor
import com.tomboy.lucas_vg.ModeloVista.VistaProveedor
import com.tomboy.lucas_vg.databinding.ActivityFrmProveedorBinding

class FrmProveedor : AppCompatActivity() {
    lateinit var b:ActivityFrmProveedorBinding
    lateinit var  vistaProveedor: VistaProveedor
    var nroRuc:Long=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        b= ActivityFrmProveedorBinding.inflate(layoutInflater)

        setContentView(b.root)
        var datos=intent.extras
        var op=datos.getInt("op").toInt()
        b.btnGuardar.visibility= View.VISIBLE
        if(op==1){
            b.btnGuardar.visibility=View.VISIBLE
        }
        if(op==2){
            nroRuc=datos.getLong("nroRuc").toLong()
            vistaProveedor=ViewModelProvider(this).get()
            vistaProveedor.buscarnroruc(nroRuc,b)
        }

        b.btnGuardar.setOnClickListener {
            var p= Proveedor(0, b.txtRaso.text.toString(),
                b.txtDeru.text.toString(), b.txtDir.text.toString(),
                b.txtTel.text.toString())

            vistaProveedor=ViewModelProvider(this).get()
            vistaProveedor.registrar(p)

            val v= Intent(this, MainActivity::class.java)
            v.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(v)

        }    }
}