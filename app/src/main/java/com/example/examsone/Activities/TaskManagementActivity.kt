package com.example.examsone.Activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.example.examsone.R
import com.example.examsone.databinding.ActivityTaskManagementBinding

class TaskManagementActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task_management)
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.sign_out_menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            R.id.signOutMenu -> {
                val dataBase = getSharedPreferences("database", Context.MODE_PRIVATE)
                val dataBaseEdit = dataBase?.edit()
                val intent = Intent(this, SignInUpActivity::class.java)
                dataBaseEdit?.putString("loginState", "Out")
                dataBaseEdit?.apply()
                startActivity(intent)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}