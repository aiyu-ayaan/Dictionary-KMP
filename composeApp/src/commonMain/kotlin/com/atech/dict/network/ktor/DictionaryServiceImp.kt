package com.atech.dict.network.ktor

import com.atech.dict.network.ktor.DictionaryService.Companion.BASE_URL
import com.atech.dict.network.model.DictionaryResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.url
import io.ktor.http.ContentType
import io.ktor.http.contentType

class DictionaryServiceImp(
    private val client: HttpClient
) : DictionaryService {
    override suspend fun getDefinition(word: String): List<DictionaryResponse> =
        try {
            client.get {
                url("$BASE_URL/word/$word")
                contentType(ContentType.Application.Json)
            }.body()
        } catch (e: Exception) {
            println("Error: ${e.message}")
            emptyList()
        }
}