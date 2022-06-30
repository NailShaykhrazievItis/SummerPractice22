package com.test.summerpractice22.first

import android.util.Log

data class Admin(
    val id: Int,
    val myEmail: String = "admin@gmail.com",
) : User(
    email = myEmail,
    age = 6,
) {

    override fun logMessage() {
        Log.e("Admin", "I am $name, $age, $email")
    }


}
