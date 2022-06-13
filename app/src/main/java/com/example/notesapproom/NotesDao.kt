package com.example.notesapproom

import androidx.lifecycle.LiveData
import androidx.room.*


//Dao are abstract class

@Dao
abstract class NotesDao {
    //we will perform delete insert and get all notes operation through
    //function

    @Insert(onConflict =  OnConflictStrategy.IGNORE )
    abstract suspend fun insert(note: Notes)

    @Delete
    abstract suspend fun delete(note: Notes)

    //This will select all data from our table according to id
    @Query("SELECT * FROM notes_table ORDER BY id ASC")
    abstract fun getAllNotes(): LiveData<List<Notes>>

}

//this our data access object to access data
//Next we create room data base
