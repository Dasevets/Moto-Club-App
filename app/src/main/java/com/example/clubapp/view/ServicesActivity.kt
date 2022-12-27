package com.example.clubapp.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.clubapp.App
import com.example.clubapp.data.Service
import com.example.clubapp.databinding.ActivityServicesBinding
import com.example.clubapp.view.rv_adapter.ServicesAdapter


class ServicesActivity : AppCompatActivity() {

    private lateinit var bindService: ActivityServicesBinding

    private var servicesViewModel = App.instance.servicesViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindService = ActivityServicesBinding.inflate(layoutInflater)
        setContentView(bindService.root)

        val recyclerView: RecyclerView = bindService.servicesRecyclerView

        val services = mutableListOf<Service>()
        servicesViewModel.serviceLiveData.observe(this) { list ->

            list.forEach {
                services.add(it)
            }

        }


        val servClickListener: ServicesAdapter.OnServClickListener =
            object : ServicesAdapter.OnServClickListener {
                override fun clickServ(service: Service) {

                }
            }

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = ServicesAdapter(services, servClickListener)

    }


}