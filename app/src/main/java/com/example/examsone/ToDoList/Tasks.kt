package com.example.examsone.ToDoList

import androidx.lifecycle.ViewModel

enum class States{
    TODO, DOING, DONE
}

data class Tasks(val taskName:String, val taskDescription:String, val taskData:String, val taskState:States)

class myViewModel: ViewModel() {
    val todoList = arrayListOf<Tasks>()
    val doneList = arrayListOf<Tasks>()
    val doingList = arrayListOf<Tasks>()

}