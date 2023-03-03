package com.example.examsone.ToDoList

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.databinding.DataBindingUtil
import com.example.examsone.R
import com.example.examsone.databinding.FragmentDoingBinding
import com.example.examsone.databinding.FragmentDoneBinding


class DoneFragment : Fragment(R.layout.fragment_done) {

    private lateinit var binding : FragmentDoneBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = view?.let { DataBindingUtil.bind(it) }!!

    }

}