package com.cmps312.todoapp.data.entity

data class Todo(
    var title: String? = "",

    var priority: String? = "",

    var todoId: String? = "",
    var projectId: String? = null
)