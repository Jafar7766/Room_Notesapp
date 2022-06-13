package com.example.notesapproom

//it will take dao as constructor
class NotesRepository(private val notesDao: NotesDao){
    val allNotes = notesDao.getAllNotes()

    suspend fun insert(notes: Notes){
        notesDao.insert(notes)
    }
    suspend fun delete(notes: Notes){
        notesDao.delete(notes)
    }
}