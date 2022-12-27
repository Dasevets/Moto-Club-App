package com.example.clubapp.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.clubapp.App
import com.example.clubapp.data.About
import com.example.clubapp.databinding.ActivityAboutUsBinding
import com.example.clubapp.view.rv_adapter.AboutAdapter

class AboutActivity : AppCompatActivity() {
    private lateinit var bindAboutUsBinding: ActivityAboutUsBinding

    private val aboutViewModel = App.instance.aboutViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindAboutUsBinding = ActivityAboutUsBinding.inflate(layoutInflater)
        setContentView(bindAboutUsBinding.root)


        val recyclerView: RecyclerView = bindAboutUsBinding.recyclerViewAbout
        val abouts = mutableListOf<About>()

        aboutViewModel.liveAboutData.observe(this) { list ->


            list.forEach {

                abouts.add(it)

            }


        }
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = AboutAdapter(abouts)

    }
}


