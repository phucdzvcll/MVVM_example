package com.example.mvvm_example.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvm_example.R
import com.example.mvvm_example.data.local.model.Student
import kotlinx.android.synthetic.main.row_student.view.*



class MyAdapter(private val data: ArrayList<Student>): RecyclerView.Adapter<MyAdapter.MyHolder>(){



    class MyHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        fun bind(item: Student){
            itemView.item_name.text = item.name
            itemView.item_phone_number.text = item.phoneNumber
        }
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): MyHolder {
        val itemView = LayoutInflater.from(p0.context)
            .inflate(R.layout.row_student, p0, false)

        return MyHolder(itemView)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        holder.bind( data[position])
    }

    fun addAll(listStudent: List<Student>){
        data.clear()
        data.addAll(listStudent)
        notifyDataSetChanged()
    }
}