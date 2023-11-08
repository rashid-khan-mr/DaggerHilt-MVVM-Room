package com.example.mvvmexample

import android.content.Context
import androidx.lifecycle.LiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import javax.inject.Inject

class VehicleRepository @Inject constructor (private val userDao: VehicleDao) {

    fun insert( vehicle:Vehicle)
    {
        CoroutineScope(IO).launch {
            userDao.insert(vehicle)
        }
    }


    fun getAllUserData(): LiveData<List<Vehicle>>
    {
        return userDao.getAllUserData()
    }
}