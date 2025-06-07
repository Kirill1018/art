package com.example.art.dataLay

import com.example.art.domLay
    .ArtApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private const val BASE_URL = "https://api.artic.edu/api/v1/"//uniform resource locator
    val artApi: ArtApi by lazy { Retrofit.Builder().baseUrl(this.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create()).client(OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .build()).build().create(ArtApi::class.java)
    }
}