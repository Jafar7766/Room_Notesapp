package com.example.notesapproom

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.LiveData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

// it is moderator between UI and data
class NotesViewModel(application: Application): AndroidViewModel(application) {
     val allNotes : LiveData<List<Notes>>
     private val repository : NotesRepository

     //initialize the above datas

     init {
         val dao = NotesDatabase.getDatabase(application).getNoteDao()
         repository = NotesRepository(dao)
         allNotes = repository.allNotes
     }

    //insert note function
    // we want function to be run on background thread
    fun insertNote(notes: Notes) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(notes)
    }

    fun deleteNotes(notes: Notes) = viewModelScope.launch(Dispatchers.IO) {
        repository.delete(notes)
    }


}