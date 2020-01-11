package com.example.tablayout_ejemplo

import android.os.Bundle
import android.widget.AdapterView
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import android.R.*
import android.content.Context
import android.view.*
import android.view.MenuInflater
import android.view.ContextMenu
import androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior.setTag
import android.R.attr.name








class Fragment2 : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val rootView = inflater.inflate(R.layout.fragment2, container, false)

        val listaUsers = rootView.findViewById(R.id.listusers) as ListView

/*Menú contextual*/
        /*registerForContextMenu(listaUsers)
        setHasOptionsMenu(true)*/

        val usuarios = ArrayList<CardView>()
        usuarios.add(CardView("María Mata", R.drawable.whale))
        usuarios.add(CardView("Antonio Sanz", R.drawable.whale2))
        usuarios.add(CardView("Carlos", R.drawable.whale3))
        usuarios.add(CardView("Berta", R.drawable.whale4))
        usuarios.add(CardView("Hector Campos", R.drawable.whale5))
        usuarios.add(CardView("Magda", R.drawable.whale6))
        usuarios.add(CardView("Eugenia", R.drawable.whale7))
        usuarios.add(CardView("Jesús", R.drawable.whale8))
        usuarios.add(CardView("Victoria", R.drawable.whale9))
        usuarios.add(CardView("Catalina", R.drawable.whale10))

        val adaptador = ListaAdapter(rootView.context, usuarios)

        listaUsers.adapter = adaptador

        listaUsers.setOnItemLongClickListener(object : AdapterView.OnItemLongClickListener {
            override fun onItemLongClick(
                parent: AdapterView<*>,
                view: View,
                position: Int,
                id: Long
            ): Boolean {
                val mActionMode = parent.startActionMode(modeCallBack)
                mActionMode.setTag(position)
                view.isSelected = true
                return true
            }
        })

        return rootView
    }

/*Menú contextual*/
    /* override fun onCreateContextMenu(
         menu: ContextMenu,
         v: View,
         menuInfo: ContextMenu.ContextMenuInfo?
     ) {

         super.onCreateContextMenu(menu, v, menuInfo)

         val inflater = this@Fragment2.activity!!.menuInflater
         if (v.id === R.id.listusers) {
             inflater.inflate(R.menu.menu_context, menu)
         }
     }


     override fun onContextItemSelected(item: MenuItem): Boolean {
         when (item.getItemId()) {
             R.id.Editar -> {
                 Toast.makeText(this@Fragment2.context, "Editando", Toast.LENGTH_SHORT).show()
                 return true
             }
             R.id.Eliminar -> {
                 Toast.makeText(this@Fragment2.context, "Eliminando", Toast.LENGTH_SHORT).show()
                 return true
             }
             R.id.Compartir -> {
                 Toast.makeText(this@Fragment2.context, "Compartiendo", Toast.LENGTH_SHORT).show()
                 return true
             }
             else -> return super.onOptionsItemSelected(item)
         }
     }*/
    private val modeCallBack = object : ActionMode.Callback {

        override fun onPrepareActionMode(mode: ActionMode, menu: Menu): Boolean {
            return false
        }

        override fun onDestroyActionMode(mode: ActionMode?) {
            var mode = mode
            mode = null
        }

        override fun onCreateActionMode(mode: ActionMode, menu: Menu): Boolean {
            mode.title = "Options"
            mode.menuInflater.inflate(R.menu.menu_context_barra, menu)
            return true
        }

        override fun onActionItemClicked(mode: ActionMode, item: MenuItem): Boolean {
            val id = item.itemId

            when (id) {
                R.id.Compartir -> {
                    Toast.makeText(this@Fragment2.context, "Compartiendo", Toast.LENGTH_LONG)
                        .show()
                    mode.finish()
                }
                R.id.Eliminar -> {
                    Toast.makeText(this@Fragment2.context, "Eliminando", Toast.LENGTH_LONG)
                        .show()
                    mode.finish()
                }
                R.id.Editar -> {
                    Toast.makeText(this@Fragment2.context, "Editando", Toast.LENGTH_LONG)
                        .show()
                    mode.finish()
                }
                else -> return false
            }
            return false
        }
    }

}