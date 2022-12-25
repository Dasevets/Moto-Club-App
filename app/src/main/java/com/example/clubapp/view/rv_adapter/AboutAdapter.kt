package com.example.clubapp.view.rv_adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.clubapp.App
import com.example.clubapp.data.About
import com.example.clubapp.data.AboutDataBase
import com.example.clubapp.databinding.AboutBinding

class AboutAdapter(private val abouts: List<About>) :
    RecyclerView.Adapter<AboutAdapter.AboutViewHolder>() {


    inner class AboutViewHolder(binding: AboutBinding) : RecyclerView.ViewHolder(binding.root) {
        val persIm: ImageView = binding.person
        val description: TextView = binding.description
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AboutViewHolder {

        val binding = AboutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AboutViewHolder(binding)


    }

    override fun onBindViewHolder(holder: AboutViewHolder, position: Int) {


        holder.persIm.setImageResource(abouts[position].person)
        holder.description.text = abouts[position].desc

    }

    override fun getItemCount(): Int {
        return abouts.size
    }

}


