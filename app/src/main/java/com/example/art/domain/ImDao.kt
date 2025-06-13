package com.example.art.domain
import androidx.room.*
interface ImDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insIm(image: Image)
    @Query("select * from images")
    suspend fun getAllIm(): List<Image>
    @Delete
    suspend fun delIm(image: Image)
}