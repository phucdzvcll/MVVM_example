package com.example.mvvm_example.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvm_example.R
import com.example.mvvm_example.ui.adapter.MyAdapter
import com.example.mvvm_example.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    lateinit var adapter : MyAdapter
    private val mainViewModel:MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupView()
        setupViewModel()
        resetUI()
    }

    private fun setupView() {
        recycle_view.layoutManager = LinearLayoutManager(this)
        adapter = MyAdapter(arrayListOf())
        recycle_view.adapter = adapter

        btn_add_student.setOnClickListener {
            addStudent(edt_insert_name.text.toString(),edt_phone_number.text.toString())
            resetUI()
        }

        btn_delete_all_student.setOnClickListener {
            mainViewModel.deleteAll()
        }

    }

    private fun resetUI() {
        edt_insert_name.setText("")
        edt_phone_number.setText("")
        edt_insert_name.requestFocus()
    }

    private fun addStudent(studentName : String,phoneNumber:String) {
        mainViewModel.insertStudent(studentName , phoneNumber)
    }

    private fun setupViewModel() {
        mainViewModel.getListStudentLiveData().observe(
            this,
            Observer { list -> adapter.addAll(list)}
        )
    }
}