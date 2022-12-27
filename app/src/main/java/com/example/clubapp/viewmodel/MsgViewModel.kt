package com.example.clubapp.viewmodel

import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.example.clubapp.data.Message
import com.example.clubapp.data.MsgDataBase

class MsgViewModel(private val msgDataBase: MsgDataBase) {
    val msgLiveData = MutableLiveData<List<Message>>()



    fun getDB(){
        msgLiveData.postValue(msgDataBase.returnBase())
    }

    fun putToDB(context: Context, message: Message){
        msgDataBase.add(message)
        msgDataBase.send(context)
    }
}