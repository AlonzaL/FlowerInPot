package com.example.flowerinpot.ui.repository

import androidx.lifecycle.LiveData
import com.example.flowerinpot.ui.domain.Category
import com.google.firebase.database.FirebaseDatabase

interface MainRepository {

    fun loadCategory(): LiveData<MutableList<Category>>
}