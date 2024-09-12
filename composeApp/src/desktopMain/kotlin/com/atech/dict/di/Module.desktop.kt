package com.atech.dict.di

import com.atech.dict.ui.MainViewModel
import org.koin.core.module.Module
import org.koin.dsl.module

actual val viewModelModule: Module = module {
     single { MainViewModel(get()) }
}