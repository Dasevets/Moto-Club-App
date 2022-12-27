package com.example.clubapp.data

import android.content.Context
import com.google.gson.Gson
import java.io.FileOutputStream

class JSONHelper {

    private val FILE_NAME : String = "data.json"

    fun exportToJSON(context: Context, msg: List<Message>) : Boolean{
        var gson = Gson()
        var dataItems = DataItems()
        dataItems.setMsg(msg)
        var jsonString : String = gson.toJson(dataItems)

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