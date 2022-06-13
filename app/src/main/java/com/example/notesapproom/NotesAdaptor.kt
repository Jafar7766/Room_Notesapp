package com.example.notesapproom

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NotesAdaptor(private val listener: MainActivity): RecyclerView.Adapter<NotesAdaptor.NotesViewHolder>() {

   private val allNotes = ArrayList<Notes>()

    class NotesViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val textView: TextView = itemView.findViewById(R.id.text)
        val deleteButton: ImageView = itemView.findViewById(R.id.deleteButton)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesViewHolder{
        val viewHolder = NotesViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_note,parent,false))
        viewHolder.deleteButton.setOnClickListener{
            listener.onNoteClick(allNotes[viewHolder.adapterPosition])
        }
        return viewHolder
    }

    override fun onBindViewHolder(holder: NotesViewHolder, position: Int) {
        val currentItem = allNotes[position]
        holder.textView.text = currentItem.text
    }


    override fun getItemCount(): Int {
        return allNotes.size
    }

    fun updateData(newData: List<Notes>){
        allNotes.clear()
        allNotes.addAll(newData)
        notifyDataSetChanged()
    }
}

interface IAdaptor{
    fun onNoteClick(notes: Notes)
}