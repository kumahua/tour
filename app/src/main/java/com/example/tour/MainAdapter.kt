package com.example.tour

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.tour.databinding.ListItemBinding

class MainAdapter(private val context: Context) : RecyclerView.Adapter<MainViewHolder>(), MainViewHolder.CardListener {

    var tourList = arrayListOf<Tour>()

    private lateinit var listener: ListListener

    interface ListListener {

        fun onCardClick(url: String)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {

        return MainViewHolder(ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false), context).setListener(this)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {

        holder.bind(tourList[position])
    }

    override fun getItemCount(): Int {

        return tourList.size
    }

    override fun onCardClick(url: String) {

        listener.onCardClick(url)
    }

    fun updateList(list:ArrayList<Tour>){

        tourList = list
        notifyDataSetChanged()
    }

    fun setListener(listener: ListListener): MainAdapter {

        this.listener = listener

        return this
    }
}