package com.example.neighbours_app

object AuthUtils {
    private val userCredentials = mapOf(
        "James" to "James",
        "Rohit" to "Rohit",
        "Moti"  to "Moti",
        "Farshad" to "Farshad",
        "Bassam" to "Bassam",
        )

    fun authenticate(userName: String, password: String): Boolean {
        // Check if the provided username exists in the map
        val storedPassword = userCredentials[userName]
        // If the username exists, compare the provided password with the stored password
        return storedPassword != null && storedPassword == password
    }
}
