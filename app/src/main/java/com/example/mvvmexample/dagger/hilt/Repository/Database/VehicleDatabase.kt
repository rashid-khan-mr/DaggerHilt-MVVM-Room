package com.example.mvvmexample

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Vehicle::class],version = 1, exportSchema = false)
abstract class VehicleDatabase : RoomDatabase() {

    abstract fun userDao():VehicleDao


    companion object{
        @Volatile
         var instance:VehicleDatabase?=null
        private const val DATABASE_NAME="User"

        fun getInstance(context: Context):VehicleDatabase?
        {
            if(instance == null)
            {
                synchronized(VehicleDatabase::class.java)
                {
                    if(instance == null)
                    {
                        instance= Room.databaseBuilder(context,VehicleDatabase::class.java,
                            DATABASE_NAME)
                            .fallbackToDestructiveMigration()
                            .build()
                    }
                }
            }

            return instance
        }

    }
}