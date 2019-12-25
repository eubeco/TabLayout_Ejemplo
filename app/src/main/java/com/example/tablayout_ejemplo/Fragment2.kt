package com.example.tablayout_ejemplo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

class Fragment2 : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

        val rootView = inflater.inflate(R.layout.fragment2, container, false)

        val listaUsers = rootView.findViewById(R.id.listusers) as ListView
        /*val cabecera = layoutInflater.inflate(R.layout.header_list, null)
        listaUsers.addHeaderView(cabecera)*/


        val usuarios = ArrayList<CardView>()
        usuarios.add(CardView("María Mata", R.drawable.whale))
        usuarios.add(CardView("Antonio Sanz", R.drawable.whale2 ))
        usuarios.add(CardView("Carlos", R.drawable.whale3))
        usuarios.add(CardView("Berta", R.drawable.whale4))
        usuarios.add(CardView("Hector Campos", R.drawable.whale5))
        usuarios.add(CardView("Magda", R.drawable.whale6))
        usuarios.add(CardView("Eugenia", R.drawable.whale7))
        usuarios.add(CardView("Jesús", R.drawable.whale8))
        usuarios.add(CardView("Victoria", R.drawable.whale9))
        usuarios.add(CardView("Catalina", R.drawable.whale10))

        val adaptador = ListaAdapter(rootView.context,usuarios)

        listaUsers.adapter=adaptador

        listaUsers.setOnItemClickListener(object : AdapterView.OnItemClickListener {
            override fun onItemClick(parent: AdapterView<*>, v: View, position: Int, id: Long) {
                Toast.makeText(rootView.context, usuarios.get(position-1).card_nombre, Toast.LENGTH_SHORT).show()

            }
        })
        return rootView
    }
}


