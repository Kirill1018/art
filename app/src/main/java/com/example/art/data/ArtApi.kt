package com.example.art.data

import com.example.art
    .domain.Artwork
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ArtApi {
    @GET("artworks")
    fun getArt(@Query("limit") end: Int, @Query("page") webPage: Int): Call<Artwork>
}