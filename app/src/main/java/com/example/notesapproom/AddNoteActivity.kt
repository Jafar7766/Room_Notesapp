package com.example.notesapproom

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class AddNoteActivity : AppCompatActivity() {

    private lateinit var viewModel: NotesViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(NotesViewModel::class.java)
        setContentView(R.layout.activity_add_note)
        val btn: Button = findViewById(R.id.addNote)
        btn.setOnClickListener{
            addingNotes()
        }
    }

    fun addingNotes(){
        val editText : EditText = findViewById(R.id.input)
        val input = editText.text.toString()
        if(input.isNotEmpty()){
            viewModel.insertNote(Notes(input))
            // move to main activity

            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
    }
}