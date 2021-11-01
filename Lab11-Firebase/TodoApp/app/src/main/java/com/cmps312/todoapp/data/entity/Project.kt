package com.cmps312.todoapp.data.entity

import com.google.firebase.firestore.DocumentId

data class Project(
    @DocumentId
    var projectId: String = "",
    var name: String? = "",
    val userId: String? = ""
)