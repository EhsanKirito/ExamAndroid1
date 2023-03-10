package com.example.examsone.ToDoList

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import com.example.examsone.R
import com.example.examsone.databinding.FragmentDoingBinding

class DoingFragment : Fragment(R.layout.fragment_doing) {
    private val myViewModel: myViewModel by activityViewModels()
    private lateinit var binding : FragmentDoingBinding

            override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = view?.let { DataBindingUtil.bind(it) }!!

    }
}