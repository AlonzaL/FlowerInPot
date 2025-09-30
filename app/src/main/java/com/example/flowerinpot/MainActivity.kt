package com.example.flowerinpot

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.flowerinpot.ui.repository.MainRepository
import com.example.flowerinpot.ui.screen.MainScreen
import com.example.flowerinpot.ui.theme.FlowerInPotTheme
import com.example.flowerinpot.ui.viewModel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FlowerInPotTheme {
                val mainViewModel: MainViewModel = hiltViewModel()
                MainScreen(mainViewModel)
            }
        }
    }
}