package com.example.tablayout_ejemplo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView


class Fragment1 : Fragment() {


        override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {


            val rootView = inflater.inflate(R.layout.fragment1, container, false)

            val array_cards_view = ArrayList<CardView>()
            array_cards_view.add(CardView("Card 1", R.drawable.whale))
            array_cards_view.add(CardView("Card 2",R.drawable.whale2))
            array_cards_view.add(CardView("Card 3", R.drawable.whale3))
            array_cards_view.add(CardView("Card 4", R.drawable.whale4))
            array_cards_view.add(CardView("Card 5", R.drawable.whale5))
            array_cards_view.add(CardView("Card 6", R.drawable.whale6))
            array_cards_view.add(CardView("Card 7", R.drawable.whale7))
            array_cards_view.add(CardView("Card 8", R.drawable.whale8))
            array_cards_view.add(CardView("Card 9", R.drawable.whale9))
            array_cards_view.add(CardView("Card 10", R.drawable.whale10))

            val recView = rootView.findViewById<RecyclerView>(R.id.idRecyclerView)
            recView.setHasFixedSize(true)
            val adaptador = ImagesAdapter(array_cards_view)
            recView.adapter = adaptador
            recView.layoutManager = GridLayoutManager(activity, 2)

            return rootView
        }
    }