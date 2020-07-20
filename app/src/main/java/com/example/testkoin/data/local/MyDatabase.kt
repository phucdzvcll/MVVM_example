package com.example.testkoin.data.local
import android.content.Context
import androidx.room.*
import com.example.testkoin.data.local.model.Student

@Database(entities = [Student::class], version = 1)

abstract class MyDatabase : RoomDatabase() {

    abstract fun studentDao() : StudentDao

    companion object {

        private var INSTANCE: MyDatabase? = null

        fun getInstance(context: Context): MyDatabase {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(
                    context,
                    MyDatabase::class.java,
                    "Student Manager")
                    .allowMainThreadQueries()
                    .build()
            }

            return INSTANCE!!
        }
    }
}
