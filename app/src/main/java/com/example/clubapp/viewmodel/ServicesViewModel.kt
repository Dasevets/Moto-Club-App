package com.example.clubapp.viewmodel

import androidx.lifecycle.MutableLiveData
import com.example.clubapp.data.Service
import com.example.clubapp.data.ServicesDataBase

class ServicesViewModel(val servicesDataBase: ServicesDataBase) {

    val serviceLiveData = MutableLiveData<List<Service>>()

    fun getDB(){
        serviceLiveData.postValue(servicesDataBase.returnBase())
    }
}