package com.example.clubapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.clubapp.App
import com.example.clubapp.R
import com.example.clubapp.data.JSONHelper
import com.example.clubapp.data.Message
import com.example.clubapp.databinding.ActivityContactsBinding

class ContactsActivity : AppCompatActivity() {

    lateinit var bindingCont: ActivityContactsBinding

    private val msgViewModel = App.instance.msgViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingCont = ActivityContactsBinding.inflate(layoutInflater)
        setContentView(bindingCont.root)

        var msgBD = mutableListOf<Message>()
        msgViewModel.msgLiveData.observe(this){list ->

            list.forEach {
                msgBD.add(it)
            }

        }

        bindingCont.sendButton.setOnClickListener{
            val email = bindingCont.editTextTextEmailAddress2.text.toString()
            val msg = bindingCont.sendText.text.toString()

            msgViewModel.putToDB(this, Message(email, msg))

        }
    }
}