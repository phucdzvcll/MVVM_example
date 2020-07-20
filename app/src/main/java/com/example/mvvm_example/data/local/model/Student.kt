package com.example.mvvm_example.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "student")
data class Student(
    val name:String? ="",
    val phoneNumber:String?=""
) {
    @PrimaryKey(autoGenerate = true)
    var id:Int = 0
}


