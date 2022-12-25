package com.example.clubapp

import android.app.Application
import com.example.clubapp.data.AboutDataBase
import com.example.clubapp.data.BaseDataBase
import com.example.clubapp.data.ServicesDataBase
import com.example.clubapp.viewmodel.AboutViewModel
import com.example.clubapp.viewmodel.ServicesViewModel

class App : Application() {

    lateinit var aboutDB: AboutDataBase
    lateinit var aboutViewModel: AboutViewModel

    lateinit var serviceDB : ServicesDataBase
    lateinit var servicesViewModel: ServicesViewModel

    override fun onCreate() {
        super.onCreate()
        instance = this

        aboutDB = AboutDataBase()
        aboutViewModel = AboutViewModel(aboutDB)

        serviceDB = ServicesDataBase()
        servicesViewModel = ServicesViewModel(serviceDB)
    }

    companion object {
        lateinit var instance: App
        private set
    }
}