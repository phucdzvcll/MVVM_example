package com.example.mvvm_example.data.repository

import com.example.mvvm_example.data.local.model.Student

interface RepoRepository {

    suspend fun getData(): List<Student>

    suspend  fun  insert(student: Student)

    suspend fun deleteAllStudent()
}