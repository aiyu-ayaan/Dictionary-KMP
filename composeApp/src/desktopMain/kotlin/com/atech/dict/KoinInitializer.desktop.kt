package com.atech.dict

import com.atech.dict.di.appModule
import com.atech.dict.di.viewModelModule
import org.koin.core.context.startKoin

actual class KoinInitializer {
    actual fun init() {
        startKoin {
            modules(appModule, viewModelModule)
        }
    }
}