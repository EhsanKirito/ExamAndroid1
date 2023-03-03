package com.example.examsone.ToDoList

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import com.example.examsone.R
import com.example.examsone.databinding.FragmentDoingBinding
import com.example.examsone.databinding.FragmentTodoBinding

class ToDoFragment : Fragment(R.layout.fragment_todo) {
    private val myViewModel: myViewModel by activityViewModels()
    private lateinit var binding : FragmentTodoBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = view.let { DataBindingUtil.bind(it) }!!
            if (myViewModel.todoList.isNotEmpty()){
                binding.textView.text = myViewModel.todoList[0].taskName
                binding.textView2.text = myViewModel.todoList[0].taskDescription
                binding.textView3.text = myViewModel.todoList[0].taskData
            }

    }
}