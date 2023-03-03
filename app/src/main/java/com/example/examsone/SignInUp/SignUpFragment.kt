package com.example.examsone.SignInUp

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.examsone.R
import com.example.examsone.databinding.FragmentSignUpBinding

class SignUpFragment : Fragment(R.layout.fragment_sign_up) {

        private lateinit var binding:FragmentSignUpBinding
        private val args by navArgs<SignUpFragmentArgs>()
        private lateinit var dataBase:SharedPreferences.Editor

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initializer()

        binding.btnSignUp.setOnClickListener {
            checkAndDoSignUp()
        }
    }
    private fun initializer(){
        binding = view?.let { DataBindingUtil.bind(it) }!!
        dataBase = activity?.getSharedPreferences("database", Context.MODE_PRIVATE)?.edit()!!
        binding.email.setText(args.username)
        binding.txtPasswordUp.setText(args.password)
    }

    private fun checkAndDoSignUp(){
        if (binding.email.text.toString().isEmpty())
            Toast.makeText(context, "Username can't be blank", Toast.LENGTH_SHORT).show()
        else if (binding.txtPasswordUp.text.toString().isEmpty())
            Toast.makeText(context, "Password can't be blank", Toast.LENGTH_SHORT).show()
        else if (binding.txtPasswordUp.text.toString() != binding.txtRePasswordUp.text.toString()) {
            Toast.makeText(context, "Password does not match", Toast.LENGTH_SHORT).show()
        } else {
            dataBase?.putString("username", binding.fullName.text.toString())
            dataBase?.putString("mail", binding.email.text.toString())
            dataBase?.putString("password", binding.txtPasswordUp.text.toString())
            dataBase?.apply()
            Toast.makeText(
                context,
                "register completed. press back to login",
                Toast.LENGTH_SHORT
            ).show()
            findNavController().navigate(SignUpFragmentDirections.actionSignUpFragmentToSignInFragment(
                binding.email.text.toString(), binding.txtPasswordUp.text.toString()
            ))
        }
    }
}