package com.atech.dict

import android.content.Context
import com.atech.dict.di.appModule
import com.atech.dict.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

actual class KoinInitializer(
    private val context: Context
) {
    actual fun init() {
        startKoin {
            androidContext(context)
            modules(appModule, viewModelModule)
        }
    }
}