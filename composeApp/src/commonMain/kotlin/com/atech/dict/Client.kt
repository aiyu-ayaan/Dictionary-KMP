package com.atech.dict

import com.atech.dict.network.httpClientEngineFactory

class Client {
    private val client = httpClientEngineFactory()

    fun getClient() = client
}