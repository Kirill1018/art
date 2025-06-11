package com.example.art.data

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson
    .GsonConverterFactory

object RetrofitClient {
    private const val BASE_URL = "https://www.rijksmuseum.nl/api/nl/"//uniform resource locator
    val artApi: ArtApi by lazy { Retrofit.Builder().baseUrl(this
        .BASE_URL).addConverterFactory(GsonConverterFactory.create())
        .client(OkHttpClient.Builder().addInterceptor(HttpLoggingInterceptor()
            .setLevel(HttpLoggingInterceptor.Level.BODY))
            .build()).build().create(ArtApi::class
            .java)
    }
}