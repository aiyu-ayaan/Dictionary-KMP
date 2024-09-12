package com.atech.dict.di

import com.atech.dict.Client
import com.atech.dict.network.ktor.DictionaryService
import com.atech.dict.network.ktor.DictionaryServiceImp
import org.koin.core.module.Module
import org.koin.dsl.bind
import org.koin.dsl.module

val appModule = module {
    single { DictionaryServiceImp(Client().getClient().createEngine()) }
        .bind<DictionaryService>()
}

expect val viewModelModule: Module