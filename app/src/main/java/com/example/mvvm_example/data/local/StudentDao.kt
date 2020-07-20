package com.example.mvvm_example.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.mvvm_example.data.local.model.Student

@Dao
interface StudentDao {

    @Query("select * from student")
    fun getAllStudent() : List<Student>

    @Insert
    fun insertStudent(student: Student)

    @Query("delete from student")
    fun deleteAllStudent()
}