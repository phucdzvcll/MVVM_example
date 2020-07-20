package com.example.testkoin.data.di

import com.example.testkoin.data.local.MyDatabase
import com.example.testkoin.data.repository.RepoRepository
import com.example.testkoin.data.repository.RepoRepositoryIlmt
import com.example.testkoin.viewmodel.MainViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module



val createModule = module {

    single { MyDatabase.getInstance(context = androidContext()) }

    single { get<MyDatabase>().studentDao()}

    single<RepoRepository> { RepoRepositoryIlmt(studentDao = get()) }

    viewModel {MainViewModel(repoRepository = get())}
}


