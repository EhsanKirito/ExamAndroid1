package com.example.examsone.Activities

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.examsone.R

class SignInUpActivity : AppCompatActivity() {
    private lateinit var sharedPref:SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in_up)

        initializer()
        checkIfIsLoggedIn()

    }

    private fun initializer(){
        val sharedPref = getSharedPreferences("database", Context.MODE_PRIVATE)
        val intent = Intent(this, TaskManagementActivity::class.java).apply {
            putExtra("NewUserUp",
                sharedPref.getString("username", sharedPref.getString("mail", "No Name")))
        }
    }

    private fun checkIfIsLoggedIn(){
        if (sharedPref?.getString("loginState","1")== "IN"){
            startActivity(intent)
        }
    }

}