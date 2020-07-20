package com.example.mvvm_example.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvm_example.data.local.model.Student
import com.example.mvvm_example.data.repository.RepoRepository
import kotlinx.coroutines.*

class MainViewModel(private val repoRepository: RepoRepository) : ViewModel() {

    private val listStudentsLiveData = MutableLiveData<List<Student>>()
    private val coroutineScope = Job() + Dispatchers.IO
    private fun getListStudent() {
        viewModelScope.launch {
            listStudentsLiveData.value=repoRepository.getData()
        }
    }

    fun deleteAll(){
        viewModelScope.launch {
            repoRepository.deleteAllStudent()
            getListStudent()
        }
    }

    fun insertStudent(studentName: String , phoneNumber : String) {
        viewModelScope.launch {
            repoRepository.insert(student = Student(studentName , phoneNumber))
            getListStudent()
        }
    }

    fun getListStudentLiveData(): LiveData<List<Student>>{
        getListStudent()
        return listStudentsLiveData
    }

}