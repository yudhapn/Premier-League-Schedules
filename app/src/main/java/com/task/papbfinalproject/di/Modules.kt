package com.task.papbfinalproject.di

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.task.papbfinalproject.BuildConfig
import com.task.papbfinalproject.repository.FootballRepository
import com.task.papbfinalproject.viewmodel.NewsViewModel
import com.yudhapn.footballapp.api.NewsApi
import okhttp3.OkHttpClient
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {
    factory { OkHttpClient.Builder().build() }
    single {
        Retrofit.Builder()
            .client(get())
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()
    }

    factory { get<Retrofit>().create(NewsApi::class.java) }
}

val repositoryModule = module {
    factory { FootballRepository(get()) }
}

val viewModelModule = module {
    viewModel { (eventType : String) ->NewsViewModel(get(), eventType) }
}

val appComponent = listOf(
    viewModelModule,
    repositoryModule,
    networkModule
)