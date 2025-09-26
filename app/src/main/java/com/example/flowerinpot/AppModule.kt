package com.example.flowerinpot

import com.example.flowerinpot.ui.repository.MainRepository
import com.example.flowerinpot.ui.repository.MainRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton

    fun providesMainRepository(): MainRepository = MainRepositoryImpl()
}