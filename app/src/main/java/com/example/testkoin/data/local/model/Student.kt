package com.example.testkoin.data.local.model

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


