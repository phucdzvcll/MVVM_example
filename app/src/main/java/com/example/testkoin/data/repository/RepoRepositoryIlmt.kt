package com.example.testkoin.data.repository

import androidx.lifecycle.LiveData
import com.example.testkoin.data.local.StudentDao
import com.example.testkoin.data.local.model.Student
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