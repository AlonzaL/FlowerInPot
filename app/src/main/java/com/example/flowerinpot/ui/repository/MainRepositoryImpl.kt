package com.example.flowerinpot.ui.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.flowerinpot.ui.domain.Category
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import javax.inject.Inject

class MainRepositoryImpl @Inject constructor(): MainRepository {
    private val firebaseDatabase = FirebaseDatabase.getInstance()

    override fun loadCategory(): LiveData<MutableList<Category>> {
        val listData = MutableLiveData<MutableList<Category>>()
        val ref = firebaseDatabase.getReference("Category")

        ref.addValueEventListener(
            object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    val list = mutableListOf<Category>()

                    for(child in snapshot.children) {
                        val item = child.getValue(Category::class.java)
                        item?.let { list.add(it) }
                    }
                    listData.value = list
                }

                override fun onCancelled(error: DatabaseError) {
                    TODO("Not yet implemented")
                }
            })
        return listData
    }
}