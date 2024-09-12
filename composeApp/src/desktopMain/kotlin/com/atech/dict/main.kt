package com.atech.dict

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.atech.dict.di.appModule
import com.atech.dict.di.viewModelModule
import org.koin.core.context.startKoin

fun main() {
    startKoin {
        modules(appModule, viewModelModule)
    }
    application {
        Window(
            onCloseRequest = ::exitApplication,
            title = "Dictionary",
        ) {
            App()
        }
    }
}