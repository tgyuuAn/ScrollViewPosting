package com.example.scrollveiw

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.scrollveiw.databinding.RvItemBinding

class RVViewHolder(private val binding: RvItemBinding) : RecyclerView.ViewHolder(binding.root){
    fun bind(item : Song){
        binding.song = item
        binding.itemIV.setBackgroundResource(item.image)
    }
}

class RVAdapter(val songList : List<Song>) : RecyclerView.Adapter<ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return RVViewHolder(RvItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount(): Int {
        return songList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder as RVViewHolder
        holder.bind(songList[position])
    }
}