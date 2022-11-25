package com.tomboy.lucas_vg

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.recyclerview.widget.LinearLayoutManager
import com.tomboy.lucas_vg.Adaptador.AdaptadorListado
import com.tomboy.lucas_vg.ModeloVista.VistaProveedor
import com.tomboy.lucas_vg.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var  vistaProveedor: VistaProveedor
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        vistaProveedor=ViewModelProvider(this).get()
        vistaProveedor.iniciar()
        binding.listado.apply {
            layoutManager=LinearLayoutManager(applicationContext)
        }

        vistaProveedor.lista.observe(this, Observer{
            binding.listado.adapter=AdaptadorListado(it)
        })

        binding.btnagregar.setOnClickListener {
            val v = Intent(this, FrmProveedor::class.java)
            v.putExtra("op", 1)
            startActivity(v)
        }

        binding.txtdato.addTextChangedListener(object : TextWatcher{

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if(p0.toString().isEmpty()){
                    vistaProveedor.buscarrazonsocial(p0.toString())
                }
            }

            override fun afterTextChanged(p0: Editable?) {
                if(p0.toString().isNotEmpty()){
                    vistaProveedor.buscarrazonsocial(p0.toString())
                }
            }
        })
    }
}