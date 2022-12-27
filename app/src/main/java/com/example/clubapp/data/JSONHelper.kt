package com.example.clubapp.data

import android.content.Context
import com.google.gson.Gson

class JSONHelper {

    private val FILE_NAME = "data.json"

    fun exportToJSON(context: Context, msg: List<Message>) : Boolean{
        val gson = Gson()
        val dataItems = DataItems()
        dataItems.setMsg(msg)
        val jsonString : String = gson.toJson(dataItems)

            try {
                context.openFileOutput(FILE_NAME, Context.MODE_PRIVATE).use { fileOutputStream ->
                    fileOutputStream.write(jsonString.toByteArray())


                    return true
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        return false
    }


}

class DataItems{
    private lateinit var msg : List<Message>



    fun setMsg(msg: List<Message>){
        this.msg = msg
    }

}