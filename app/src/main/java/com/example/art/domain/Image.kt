package com.example.art.domain
import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity(tableName = "images")
data class Image(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String,
    val longTitle: String,
    val url: String
)