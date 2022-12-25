package com.example.clubapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.clubapp.App
import com.example.clubapp.R
import com.example.clubapp.data.Service
import com.example.clubapp.databinding.ActivityServicesBinding
import com.example.clubapp.databinding.ServicesBinding
import com.example.clubapp.viewmodel.ServicesViewModel

class ServicesActivity : AppCompatActivity() {

    lateinit var bindService: ActivityServicesBinding

    private var servicesViewModel = App.instance.servicesViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindService = ActivityServicesBinding.inflate(layoutInflater)
        setContentView(bindService.root)


        val services = mutableListOf<Service>()
        servicesViewModel.serviceLiveData.observe(this){ list ->

            list.forEach {
                services.add(it)
            }
        }
    }
}