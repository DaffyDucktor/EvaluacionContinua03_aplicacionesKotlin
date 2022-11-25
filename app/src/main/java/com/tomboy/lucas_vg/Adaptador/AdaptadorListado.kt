package com.tomboy.lucas_vg.Adaptador

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tomboy.lucas_vg.FrmProveedor
import com.tomboy.lucas_vg.Modelo.Proveedor
import com.tomboy.lucas_vg.R
import com.tomboy.lucas_vg.databinding.ListaBinding

class AdaptadorListado(private val data:List<Proveedor>?): RecyclerView.Adapter<AdaptadorListado.ViewHolder>() {
    class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        var binding:ListaBinding=ListaBinding.bind(view)
        var contexto: Context = view.context
        fun enlazarDatos(p: Proveedor){
            binding.foto.setImageResource(R.drawable.foto)
            binding.txtNroRuc.text = p.nroRuc.toString()
            binding.txtRazonSocial.text = p.razonSocial
            binding.txtDescRubro.text = p.descRubro
            binding.txtDireccion.text = p.direccion
            binding.txtTelefono.text = p.telefono
            binding.root.setOnClickListener {
                val v = Intent(contexto, FrmProveedor::class.java)
                v.putExtra("op", 2)
                v.putExtra("nroRuc", p.nroRuc)
                contexto.startActivity(v)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.lista,parent,false)
        return ViewHolder(view)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item:Proveedor?=data?.get(position)
        holder.enlazarDatos(item!!)

    }

    override fun getItemCount()=data!!.size

}