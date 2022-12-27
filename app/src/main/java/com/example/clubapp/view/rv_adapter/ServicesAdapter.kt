package com.example.clubapp.view.rv_adapter

import android.view.LayoutInflater
import android.view.View.*
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.clubapp.R
import com.example.clubapp.data.Service
import com.example.clubapp.databinding.ServicesBinding

class ServicesAdapter(private val servicesDB: List<Service>, private val onClickListener: OnServClickListener) :
    RecyclerView.Adapter<ServicesAdapter.ServicesViewHolder>() {


    inner class ServicesViewHolder(bindingServ: ServicesBinding) :
        RecyclerView.ViewHolder(bindingServ.root) {
        val titleServ: TextView = bindingServ.title
        val serv: TextView = bindingServ.service
        var collapseIM : ImageView = bindingServ.collapseImage
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ServicesViewHolder {
        val binding = ServicesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ServicesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ServicesViewHolder, position: Int) {
        holder.titleServ.text = servicesDB[position].title
        holder.serv.text = servicesDB[position].serv
        holder.collapseIM.setImageResource(R.drawable.collapse_icon_close)


        holder.itemView.setOnClickListener() {
            onClickListener.clickServ(servicesDB[position])

            if(holder.serv.visibility == GONE) {
                holder.serv.visibility = VISIBLE
                holder.collapseIM.setImageResource(R.drawable.collapse_icon_open)

            }
            else {
                holder.serv.visibility = GONE
                holder.collapseIM.setImageResource(R.drawable.collapse_icon_close)

            }

        }
    }

    override fun getItemCount(): Int {
        return servicesDB.size
    }


    interface OnServClickListener {
        fun clickServ(service: Service)
    }
}

