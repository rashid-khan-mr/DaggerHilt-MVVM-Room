package com.example.mvvmexample

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "vehicle")
data class Vehicle constructor(val name:String, val price:Int) {
    @PrimaryKey(autoGenerate = true)
    var id:Int?=null
}