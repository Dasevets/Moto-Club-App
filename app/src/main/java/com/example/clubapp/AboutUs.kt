package com.example.clubapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.clubapp.databinding.ActivityAboutUsBinding

class AboutUs : AppCompatActivity() {
    lateinit var bindAboutUsBinding: ActivityAboutUsBinding



    val abouts = listOf(
        About(
            R.drawable.logo,
            "President, founder of the club"
        ),
        About(
            R.drawable.logo,
            "Vice president, replaces the head in his absence"
        ),
        About(
            R.drawable.logo,
            "Road captain, leads the column, develops routes"
        )
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindAboutUsBinding = ActivityAboutUsBinding.inflate(layoutInflater)
        setContentView(bindAboutUsBinding.root)

        val recyclerView: RecyclerView = bindAboutUsBinding.recyclerViewAbout

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = AboutAdapter(abouts)


    }
}