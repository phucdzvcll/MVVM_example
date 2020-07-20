package com.example.testkoin.data.repository

import androidx.lifecycle.LiveData
import com.example.testkoin.data.local.model.Student

interface RepoRepository {

    suspend fun getData(): List<Student>

    suspend  fun  insert(student: Student)

    suspend fun deleteAllStudent()
}