package com.example.tablayout_ejemplo

import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

class ImagesAdapter(var items: ArrayList<CardView>) : RecyclerView.Adapter<ImagesAdapter.TarjViewHolder>() {

    init {
        this.items = items
    }

    class TarjViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var imag : ImageView
        var toolcard : androidx.appcompat.widget.Toolbar

        init {
            imag = itemView.findViewById(R.id.idtbImage)
            toolcard = itemView.findViewById(R.id.idtbCard)
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