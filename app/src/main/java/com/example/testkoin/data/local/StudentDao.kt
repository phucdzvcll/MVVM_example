package com.example.testkoin.data.local

import android.telecom.Call
import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.testkoin.data.local.model.Student

@Dao
interface StudentDao {

    @Query("select * from student")
    fun getAllStudent() : List<Student>

    @Insert
    fun insertStudent(student: Student)

    @Query("delete from student")
    fun deleteAllStudent()
}