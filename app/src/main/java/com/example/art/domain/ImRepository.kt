package com.example.art.domain

import android.content.Context
import com.example.art
    .data.AppDatabase

class ImRepository(context: Context) {
    private val db = AppDatabase.getInstance(context)
    private val imDao = this.db.imDao()
    suspend fun addIm(name: String, description: String,
                      link: String) = this.imDao.insIm(Image(title = name, longTitle = description,
                          url = link))
    suspend fun getAllIm(): List<Image> = this.imDao.getAllIm()
}