package com.example.flowerinpot.ui.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.flowerinpot.ui.domain.Category
import com.example.flowerinpot.ui.repository.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    val repository: MainRepository
) : ViewModel() {

    fun loadCategory(): LiveData<MutableList<Category>> = repository.loadCategory()

}