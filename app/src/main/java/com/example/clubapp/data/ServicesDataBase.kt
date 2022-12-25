package com.example.clubapp.data

class ServicesDataBase : BaseDataBase {

    private val serviceDB = mutableListOf(
        Service(
            "Garage",
            "motorcycle storage in the off-season"
        ),
        Service(
            "Repair",
            "repair of motor vehicles of any complexity"
        ),
        Service(
            "Custom",
            "production of custom parts and installation on motor vehicles"
        )
    )


    override fun returnBase(): List<Service> {
        return serviceDB
    }
}