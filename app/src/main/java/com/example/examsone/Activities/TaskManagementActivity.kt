package com.example.examsone.Activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.examsone.R
import com.example.examsone.databinding.ActivityTaskManagementBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class TaskManagementActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task_management)
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentContainerViewTaskManagement) as NavHostFragment
        val navController = navHostFragment.navController
        findViewById<BottomNavigationView>(R.id.bottomNavigationView)
            .setupWithNavController(navController)
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.sign_out_menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            R.id.creatTaskMenu -> {

            }
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