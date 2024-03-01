package com.example.sbx3quiz3.data

data class Profile(
    val name: String,
    val id: String,
    val age: Int,
    val town: String
)

val profiles = listOf(
    Profile("Aisyah","HTS-00001",18,"Pekalongan"),
    Profile("Adinda","HTS-0002",21,"Jakarta"),
    Profile("Indriani","HTS-00003",19,"Gorontalo"),
    Profile("Chandra","HTS-00004",25,"Jambi"),
    Profile("Ummu Sualim","HTS-00005",27,"Pekalongan"),
    Profile("Nida","HTS-0006",21,"Jakarta"),
    Profile("Wndriani","HTS-00007",19,"Gorontalo"),
    Profile("Zainab","HTS-00008",25,"Jambi")
)

