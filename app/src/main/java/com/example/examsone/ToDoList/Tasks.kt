package com.example.examsone.ToDoList

enum class States{
    TODO, DOING, DONE
}

data class Tasks(val taskName:String, val taskDescription:String, val taskData:String, val taskState:States)