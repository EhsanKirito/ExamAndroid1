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
        initializer()
        val taskList = arrayListOf<Tasks>()
        radioButtonInitializers()


        binding.btnSubmit.setOnClickListener {
            taskSubmitter(taskList)
        }


    }
    private fun initializer(){
        binding = view?.let { DataBindingUtil.bind(it) }!!

    }
    private fun radioButtonInitializers(){
        binding.btnToDo.setOnClickListener {
            binding.btnDoing.isChecked = false
            binding.btnDone.isChecked = false
        }
        binding.btnDoing.setOnClickListener {
            binding.btnToDo.isChecked = false
            binding.btnDone.isChecked = false
        }
        binding.btnDone.setOnClickListener {
            binding.btnDoing.isChecked = false
            binding.btnToDo.isChecked = false
        }
    }
    fun taskSubmitter(taskList:ArrayList<Tasks>){
        if (binding.btnToDo.isChecked){
            taskList.add(Tasks(binding.taskName.text.toString(), binding.taskDescription.text.toString(),
                binding.taskDate.text.toString(), States.TODO))
        } else if (binding.btnDoing.isChecked){
            taskList.add(Tasks(binding.taskName.text.toString(), binding.taskDescription.text.toString(),
                binding.taskDate.text.toString(), States.DOING))
        }else if (binding.btnDone.isChecked){
            taskList.add(Tasks(binding.taskName.text.toString(), binding.taskDescription.text.toString(),
                binding.taskDate.text.toString(), States.DONE))
        }
    }


}