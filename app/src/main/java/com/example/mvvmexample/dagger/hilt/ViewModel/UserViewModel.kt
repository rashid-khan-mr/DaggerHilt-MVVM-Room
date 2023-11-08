package com.example.mvvmexample

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(private val vehicleRepository: VehicleRepository):ViewModel() {

    fun insert(vehicle:Vehicle)
    {
        vehicleRepository.insert(vehicle)
    }

    fun getAllUserData():LiveData<List<Vehicle>>
    {
        return vehicleRepository.getAllUserData()
    }
}