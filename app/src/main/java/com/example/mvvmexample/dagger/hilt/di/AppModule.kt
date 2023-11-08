package com.example.mvvmexample.dagger.hilt.di

import android.content.Context
import androidx.room.Room
import com.example.mvvmexample.VehicleDao
import com.example.mvvmexample.VehicleDatabase
import com.example.mvvmexample.VehicleRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule  {

    @Provides
    fun providesUserDao(vehicleDatabase: VehicleDatabase): VehicleDao = vehicleDatabase.userDao()

    @Provides
    @Singleton
    fun providesUserDatabase(@ApplicationContext context: Context):VehicleDatabase
            = Room.databaseBuilder(context,VehicleDatabase::class.java,"UserDatabase").build()

    @Provides
    fun providesUserRepository(userDao: VehicleDao) : VehicleRepository
            = VehicleRepository(userDao)
}