package com.example.clubapp.view

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import com.example.clubapp.App
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
        msgViewModel.msgLiveData.observe(this) { list ->

            list.forEach {
                msgBD.add(it)
            }

        }
        bindingCont.sendButton.setOnClickListener {
            val email = bindingCont.editTextTextEmailAddress2.text.toString()
            val msg = bindingCont.sendText.text.toString()

            msgViewModel.putToDB(this, Message(email, msg))
            bindingCont.editTextTextEmailAddress2.text.clear()
            bindingCont.sendText.text.clear()
            hideKeyboard(this)

        }
    }

    private fun hideKeyboard(activity: Activity) {
        val imm: InputMethodManager =
            activity.getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager

        var view: View? = activity.currentFocus

        if (view == null) {
            view = View(activity)
        }
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}