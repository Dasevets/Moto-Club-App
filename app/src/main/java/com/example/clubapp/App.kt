package com.example.clubapp

import android.app.Application
import com.example.clubapp.data.AboutDataBase
import com.example.clubapp.data.MsgDataBase
import com.example.clubapp.data.ServicesDataBase
import com.example.clubapp.viewmodel.AboutViewModel
import com.example.clubapp.viewmodel.MsgViewModel
import com.example.clubapp.viewmodel.ServicesViewModel

class App : Application() {

    private lateinit var aboutDB: AboutDataBase
    lateinit var aboutViewModel: AboutViewModel

    private lateinit var serviceDB : ServicesDataBase
    lateinit var servicesViewModel: ServicesViewModel

    private lateinit var msgDB : MsgDataBase
    lateinit var msgViewModel: MsgViewModel

    override fun onCreate() {
        super.onCreate()
        instance = this

        aboutDB = AboutDataBase()
        aboutViewModel = AboutViewModel(aboutDB)

        serviceDB = ServicesDataBase()
        servicesViewModel = ServicesViewModel(serviceDB)

        msgDB = MsgDataBase()
        msgViewModel = MsgViewModel(msgDB)
    }

    companion object {
        lateinit var instance: App
        private set
    }
}