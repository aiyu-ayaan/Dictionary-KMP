package com.atech.dict.network.ktor

import com.atech.dict.network.model.DictionaryResponse

interface DictionaryService {
    suspend fun getDefinition(word: String): List<DictionaryResponse>

    companion object{
        const val BASE_URL = "http://192.168.29.205:9090/"
    }
}