package com.atech.dict

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.atech.dict.ui.MainScreen
import com.atech.dict.ui.MainViewModel
import com.atech.dict.utils.darkColorScheme
import com.atech.dict.utils.lightColorScheme
import org.koin.compose.KoinContext
import org.koin.compose.currentKoinScope

@Composable
fun App() {
    val isDarkTheme = isSystemInDarkTheme()
    MaterialTheme(
        colorScheme = if (isDarkTheme) darkColorScheme else lightColorScheme
    ) {
        KoinContext {
            val navController = rememberNavController()
            val viewModel = koinViewModel<MainViewModel>()
            val state by viewModel.definitions
            NavHost(
                navController = navController,
                startDestination = "main"
            ) {
                composable("main") {
                    MainScreen(
                        getDefinition = { word ->
                            viewModel.getDefinition(word)
                        },
                        items = state
                    )
                }
            }
        }
    }
}

@Composable
inline fun <reified T : ViewModel> koinViewModel(): T {
    val scope = currentKoinScope()
    return viewModel {
        scope.get<T>()
    }
}