package com.example.tour

import android.content.Context
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tour.databinding.ListItemBinding

class MainViewHolder(private val v: ListItemBinding, private val context: Context) : RecyclerView.ViewHolder(v.root), CardAdapter.ListListener {

    private lateinit var listener: CardListener

    interface CardListener {

        fun onCardClick(url: String)
    }

    override fun onCardClick(url: String) {

        listener.onCardClick(url)
    }

    fun setListener(listener: CardListener): MainViewHolder {

        this.listener = listener

        return this
    }

    fun bind(tour: Tour) {

        val cardAdapter = CardAdapter()
        cardAdapter.updateList(tour.card)
        cardAdapter.setListener(this)

        v.title.text = tour.title
        v.nestedRV.layoutManager = LinearLayoutManager(itemView.context, LinearLayoutManager.HORIZONTAL, false)
        v.nestedRV.adapter = cardAdapter
    }
}