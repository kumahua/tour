package com.example.tour

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.example.tour.databinding.CardItemBinding

class CardViewHolder(private val v: CardItemBinding) : RecyclerView.ViewHolder(v.root) {

    private lateinit var listener: CardListener

    interface CardListener {

        fun onCardClick(url: String)
    }

    fun setListener(listener: CardListener): CardViewHolder {

        this.listener = listener

        return this
    }

    fun bind(card: Card) {

        v.title.text = card.context

        Glide.with(itemView.context)
            .load(card.imageUrl)
            .transform(CenterCrop())
            .into(v.photo)

        itemView.setOnClickListener { listener.onCardClick(card.imageUrl) }
    }
}