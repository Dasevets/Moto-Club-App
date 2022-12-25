package com.example.clubapp.data

import com.example.clubapp.R

class AboutDataBase () : BaseDataBase {

    private val aboutDB = mutableListOf(
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

    override fun returnBase(): List<About> {
        return aboutDB
    }

}