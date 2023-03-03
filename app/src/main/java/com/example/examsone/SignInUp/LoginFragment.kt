package com.example.examsone.SignInUp


import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.examsone.R
import com.example.examsone.Activities.TaskManagementActivity
import com.example.examsone.databinding.FragmentLoginBinding

class LoginFragment : Fragment(R.layout.fragment_login) {

    private lateinit var binding : FragmentLoginBinding
    private val args by navArgs<SignUpFragmentArgs>()
    private lateinit var dataBase:SharedPreferences
    private lateinit var dataBaseEdit:SharedPreferences.Editor

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initializer()

        binding.btnLogin.setOnClickListener {
            checkLogin()
        }

        binding.txtSignUp.setOnClickListener {
            goToSignUp()
        }

    }

    private fun initializer(){
        binding = view?.let { DataBindingUtil.bind(it) }!!

        binding.txtUsernameIn.setText(args.username)
        binding.txtPasswordIn.setText(args.password)
    }

    private fun checkLogin(){
        val dataBase = activity?.getSharedPreferences("database", Context.MODE_PRIVATE)
        val dataBaseEdit = dataBase?.edit()
        if (binding.txtUsernameIn.text.toString().isEmpty()){
            Toast.makeText(context, "email can't be blank", Toast.LENGTH_SHORT).show()
        } else if (binding.txtPasswordIn.text.toString().isEmpty()) {
            Toast.makeText(context, "password can't be blank", Toast.LENGTH_SHORT).show()
        }   else if (binding.txtUsernameIn.text.toString() != dataBase?.getString("mail","admin")
            && binding.txtPasswordIn.text.toString() != dataBase?.getString("password", "admin")){
            Toast.makeText(context, "Info does not match. please sign up to continue", Toast.LENGTH_SHORT).show()
        } else if (binding.txtUsernameIn.text.toString() == dataBase?.getString("mail","admin")
            && binding.txtPasswordIn.text.toString() == dataBase?.getString("password", "admin")) {
            Toast.makeText(context, "login successful", Toast.LENGTH_SHORT).show()
            dataBaseEdit?.putString("loginState", "IN")
            dataBaseEdit?.apply()
            val intent = Intent(activity?.baseContext, TaskManagementActivity::class.java).apply {
                putExtra("NewUserUp",
                    dataBase.getString("username", dataBase.getString("mail", "No Name")))
            }
            startActivity(intent)
        }
    }

    private fun goToSignUp(){
        findNavController().navigate(LoginFragmentDirections.actionSignInFragmentToSignUpFragment(
            binding.txtUsernameIn.text.toString(), binding.txtPasswordIn.text.toString()
        ))
    }

}