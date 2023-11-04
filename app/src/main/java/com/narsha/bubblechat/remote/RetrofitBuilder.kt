package com.narsha.bubblechat.remote

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {

    private const val BASE_URL = "http://bc.mhaa.kr/"
//    private val BASE_URL = "https://jsonplaceholder.typicode.com"
    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .callFactory(
                OkHttpClient.Builder()
                    .addInterceptor(
                        HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
                    ).build()
            )
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val apiService: RetrofitService = getRetrofit().create(RetrofitService::class.java)
}