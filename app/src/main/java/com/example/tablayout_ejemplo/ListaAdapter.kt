package com.example.tablayout_ejemplo

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class ListaAdapter(context: Context, private val versiones: ArrayList<CardView>) : ArrayAdapter<CardView>(context, R.layout.lista_item, versiones)
{
    private val mInflater: LayoutInflater

    init {
        this.mInflater = LayoutInflater.from(context)
    }

    override fun getCount(): Int {
        return versiones.size
    }

    override fun getItem(position: Int): CardView? {
        return versiones[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var convertView = convertView
        var holder: ViewHolder? = null

        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.lista_item, null)
            holder = ViewHolder()
            holder.hNombre = convertView.findViewById(R.id.idNombre) as TextView
            holder.hImage = convertView.findViewById(R.id.idLogo) as ImageView
            convertView.tag = holder
        }
        else {
            holder = convertView!!.tag as ViewHolder?
        }
        val listaelemento = getItem(position)
        holder!!.hNombre!!.text = listaelemento!!.card_nombre
        holder!!.hImage!!.setImageResource(listaelemento!!.card_imagen)
        return convertView!!
    }

    internal inner class ViewHolder {
        var hNombre: TextView? = null
        var hImage: ImageView? = null
    }
}