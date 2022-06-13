package com.example.notesapproom

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


//this will create an entity table
//entity class is data class
//lets annotate the class
//it will create a table to store our notes
@Entity(tableName = "notes_table")
//our table will have a column of any name to store data in column
data class Notes(@ColumnInfo(name = "text") val text: String){
    //we will access data according to the id of the object
    @PrimaryKey(autoGenerate = true)
    var id = 0
}

//this is our entity
//now lets create dao access data
