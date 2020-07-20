package com.example.mvvm_example.data.di

import com.example.mvvm_example.data.local.MyDatabase
import com.example.mvvm_example.data.repository.RepoRepository
import com.example.mvvm_example.data.repository.RepoRepositoryIlmt
import com.example.mvvm_example.viewmodel.MainViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module



val createModule = module {

    single { MyDatabase.getInstance(context = androidContext()) }

    single { get<MyDatabase>().studentDao()}

    single<RepoRepository> { RepoRepositoryIlmt(studentDao = get()) }

    viewModel {MainViewModel(repoRepository = get())}
}


