package com.example.clubapp.data

import android.content.Context

class MsgDataBase () : BaseDataBase {

    private var msgDB = mutableListOf<Message>()

    private var jsonHelper = JSONHelper()

    override fun returnBase(): List<Message> {
        return msgDB
    }

    fun add(message: Message){
        msgDB.add(message)
    }

    fun send(context: Context){
        jsonHelper.exportToJSON(context, msgDB)
        //println(msgDB)
        msgDB.clear()
    }
}