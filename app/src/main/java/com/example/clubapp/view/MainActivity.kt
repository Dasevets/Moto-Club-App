package com.example.clubapp.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.clubapp.App
import com.example.clubapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    private val aboutViewModel = App.instance.aboutViewModel
    private val servicesViewModel = App.instance.servicesViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.aboutUs.setOnClickListener {
            val intent = Intent(this, AboutActivity::class.java)
            aboutViewModel.getDB()
            startActivity(intent)
        }
        binding.services.setOnClickListener {
            val intent = Intent(this, ServicesActivity::class.java)
            servicesViewModel.getDB()
            startActivity(intent)
        }
        binding.contacts.setOnClickListener {
            val intent = Intent(this, ContactsActivity::class.java)
            startActivity(intent)
        }
    }


}