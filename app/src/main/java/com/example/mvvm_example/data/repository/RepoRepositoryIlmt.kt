package com.example.mvvm_example.data.repository

import com.example.mvvm_example.data.local.StudentDao
import com.example.mvvm_example.data.local.model.Student
import kotlinx.coroutines.delay

class RepoRepositoryIlmt(private val studentDao: StudentDao) : RepoRepository {

    override suspend fun getData(): List<Student>{
        delay(300)
        return studentDao.getAllStudent()
    }

    override suspend fun insert(student: Student) {
        delay(500)
        studentDao.insertStudent(student)
    }

    override suspend fun deleteAllStudent() {
        delay(700)
        studentDao.deleteAllStudent()
    }
}