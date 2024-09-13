package com.atech.dict

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.atech.dict.di.appModule
import com.atech.dict.di.viewModelModule
import com.atech.dict.ui.theme.isSystemInDarkTheme
import org.koin.core.context.startKoin

fun main() {
    startKoin {
        modules(appModule, viewModelModule)
    }
    application {
        isSystemInDarkTheme()
        Window(
            onCloseRequest = ::exitApplication,
            title = "Dictionary",
        ) {
            App()
        }
    }
}