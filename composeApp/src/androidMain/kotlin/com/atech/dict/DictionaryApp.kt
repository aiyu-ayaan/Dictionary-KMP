package com.atech.dict

import android.app.Application

class DictionaryApp : Application() {
    override fun onCreate() {
        super.onCreate()
        KoinInitializer(applicationContext).init()
    }
}