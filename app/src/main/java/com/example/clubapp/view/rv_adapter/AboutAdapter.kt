package com.example.clubapp.view.rv_adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.clubapp.data.About
import com.example.clubapp.databinding.AboutBinding

class AboutAdapter(private val aboutsDB: List<About>) :
    RecyclerView.Adapter<AboutAdapter.AboutViewHolder>() {



    inner class AboutViewHolder(bindingAbout: AboutBinding) : RecyclerView.ViewHolder(bindingAbout.root) {
        val persIm: ImageView = bindingAbout.person
        val description: TextView = bindingAbout.description
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AboutViewHolder {

        val binding = AboutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AboutViewHolder(binding)


    }

    override fun onBindViewHolder(holder: AboutViewHolder, position: Int) {


        holder.persIm.setImageResource(aboutsDB[position].person)
        holder.description.text = aboutsDB[position].desc

    }

    override fun getItemCount(): Int {
        return aboutsDB.size
    }

}


