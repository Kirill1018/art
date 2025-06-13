package com.example.art.data
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.art
    .domain.ImDao
import com.example.art
    .domain.Image

//@Database(entities = [Image::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun imDao(): ImDao
    companion object {
        @Volatile private var instance: AppDatabase? = null
        fun getInstance(context: Context): AppDatabase = this.instance?: synchronized(this) { this.instance?: this
            .buildDatabase(context).also { this.instance = it } }
        private fun buildDatabase(context: Context) = Room.databaseBuilder(context.applicationContext, AppDatabase::class
            .java, "art.db").build()
    }
}