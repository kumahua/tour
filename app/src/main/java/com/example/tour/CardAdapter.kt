package com.example.tour

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tour.databinding.CardItemBinding

class CardAdapter : RecyclerView.Adapter<CardViewHolder>(), CardViewHolder.CardListener {

    private var cardList = mutableListOf<Card>()

    private lateinit var listener: ListListener

    interface ListListener {

        fun onCardClick(url: String)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {

        return CardViewHolder(CardItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)).setListener(this)
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {

        holder.bind(cardList[position])
    }

    override fun getItemCount(): Int {

        return cardList.size
    }

    override fun onCardClick(url: String) {

        listener.onCardClick(url)
    }

    fun updateList(list: MutableList<Card>){

        cardList = list

        notifyDataSetChanged()
    }

    fun setListener(listener: ListListener): CardAdapter {

        this.listener = listener

        return this
    }
}