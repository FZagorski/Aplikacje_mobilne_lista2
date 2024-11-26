package com.example.myapplication

import androidx.lifecycle.ViewModel

class UsersList : ViewModel() {
    private val users = mutableListOf<User>()
    private var loggedInUser: User? = null

    init {
        users.add(User("user1", "password1"))
        users.add(User("user2", "password2"))
        users.add(User("user3", "password3"))
        users.add(User("user4", "password4"))
        users.add(User("user5", "password5"))
    }

    fun authenticate(username: String, password: String): Boolean {
        val user = users.find { it.username == username && it.password == password }
        if (user != null) {
            loggedInUser = user
            return true
        }
        return false
    }

    fun addUser(username: String, password: String): Boolean {
        if (users.any { it.username == username }) {
            return false
        }
        users.add(User(username, password))
        return true
    }

    fun getLoggedInUser(): User? {
        return loggedInUser
    }

    fun logout() {
        loggedInUser = null
    }
}
