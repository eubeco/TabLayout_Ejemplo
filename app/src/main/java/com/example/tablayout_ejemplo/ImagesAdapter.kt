package com.example.tablayout_ejemplo

import android.content.Context
import android.database.DataSetObserver
import android.view.*
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.view.ActionMode
import androidx.recyclerview.widget.RecyclerView

class ImagesAdapter(var items: ArrayList<CardView>) : RecyclerView.Adapter<ImagesAdapter.TarjViewHolder>() {

    init {
        this.items = items
    }

    class TarjViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnCreateContextMenuListener  {

        var imag : ImageView
        var toolcard : androidx.appcompat.widget.Toolbar

        init {
            imag = itemView.findViewById(R.id.idtbImage)
            toolcard = itemView.findViewById(R.id.idtbCard)
            itemView.setOnCreateContextMenuListener(this)
/*MENÚ ACTION MODE*/
/*
            itemView.setOnLongClickListener { view ->
                (view.context as AppCompatActivity).startSupportActionMode(modeCallBack)
                return@setOnLongClickListener true
            }
*/

        }
        /*MENÚ ACTION MODE*/
/*
        var modeCallBack: ActionMode.Callback = object : ActionMode.Callback {
            override fun onActionItemClicked(mode: ActionMode?, item: MenuItem?): Boolean {
                val id = item?.itemId
                when (id) {
                    R.id.Editar -> {
                        Toast.makeText(itemView.context, "Editando", Toast.LENGTH_LONG).show()
                        mode?.finish()
                    }
                    R.id.Compartir -> {
                        Toast.makeText(itemView.context, "Compartiendo", Toast.LENGTH_LONG).show()
                        mode?.finish()
                    }
                    R.id.Eliminar -> {
                        Toast.makeText(itemView.context, "Eliminando", Toast.LENGTH_LONG).show()
                        mode?.finish()
                    }
                    else -> return false
                }
                return false
            }

            override fun onPrepareActionMode(mode: ActionMode, menu: Menu): Boolean {
                return false
            }

            override fun onDestroyActionMode(mode: ActionMode?) {
                var mode = mode
                mode = null
            }

            override fun onCreateActionMode(mode: ActionMode, menu: Menu): Boolean {
                mode.setTitle("Options")
                mode.getMenuInflater().inflate(R.menu.menu_context_barra, menu)
                return true
            }
        }
*/



        override fun onCreateContextMenu(contextMenu: ContextMenu, view: View, contextMenuInfo: ContextMenu.ContextMenuInfo?) {
            contextMenu.add(0, 0, adapterPosition, "Editar")     //groupId, itemId, order, title
            contextMenu.add(0, 1, adapterPosition, "Eliminar")
            contextMenu.add(0, 2, adapterPosition, "Compartir")
        }


        fun bindTarjeta(t: CardView) {
            imag.setImageResource(t.card_imagen)
            toolcard.menu.clear()
            toolcard.inflateMenu(R.menu.menu_tar)
            toolcard.title = t.card_nombre
        }
    }





    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): TarjViewHolder {
        val itemView = LayoutInflater.from(viewGroup.context).inflate(R.layout.list_item, viewGroup, false)
        return TarjViewHolder(itemView)
    }

    override fun onBindViewHolder(viewHolder: TarjViewHolder, pos: Int) {
        var itemCard = items[pos]
        viewHolder.bindTarjeta(itemCard)

        viewHolder.toolcard.setOnMenuItemClickListener(object : androidx.appcompat.widget.Toolbar.OnMenuItemClickListener {
            override fun onMenuItemClick(item: MenuItem): Boolean {
                when (item.getItemId()) {
                    R.id.action_añadir -> {
                        items.add(pos, CardView(itemCard.card_nombre, itemCard.card_imagen))
                        notifyItemInserted(pos)
                    }
                    R.id.action_eliminar -> {
                        items.removeAt(pos)
                        notifyItemRemoved(pos)
                    }
                }
                return true
            }
        })
    }

    override fun getItemCount(): Int {
        return items.size
    }
}