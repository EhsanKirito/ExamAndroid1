package com.example.examsone.ToDoList

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.databinding.DataBindingUtil
import com.example.examsone.R
import com.example.examsone.databinding.FragmentCreateTaskBinding
import com.example.examsone.databinding.FragmentLoginBinding


class CreatTaskFragment : Fragment(R.layout.fragment_create_task) {
    private lateinit var binding : FragmentCreateTaskBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = view?.let { DataBindingUtil.bind(it) }!!


    }


}