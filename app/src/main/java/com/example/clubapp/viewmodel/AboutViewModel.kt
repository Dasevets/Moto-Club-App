package com.example.clubapp.viewmodel

import androidx.lifecycle.MutableLiveData
import com.example.clubapp.data.About
import com.example.clubapp.data.AboutDataBase
import com.example.clubapp.data.BaseDataBase

class AboutViewModel(val aboutDataBase: AboutDataBase) {

    // создаем обозреваемый объект, с изменениями все подписчики будут уведомлены
    val liveAboutData = MutableLiveData<List<About>>()

    fun getDB(){
        liveAboutData.postValue(aboutDataBase.returnBase())
    }

}