package com.example.notesapproom

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

//This is Room data base
//Room data base are abstract class

@Database(entities = [Notes::class],version = 1, exportSchema = false)
abstract class NotesDatabase: RoomDatabase() {
    //we will access our dao through database
    abstract fun getNoteDao(): NotesDao


    companion object{
        @Volatile
        private var INSTANCE : NotesDatabase? = null
        fun getDatabase(context: Context): NotesDatabase{
            return INSTANCE ?:  synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    NotesDatabase::class.java,
                    "note_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }

}