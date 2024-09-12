package com.atech.dict.network

import io.ktor.client.HttpClient
import io.ktor.client.engine.js.JsClient


class WasmJsClientEngineFactory : EngineFactory {
    override fun createEngine(): HttpClient {
        return createHttpClient(
            JsClient().create()
        )
    }

}

actual fun httpClientEngineFactory(): EngineFactory =
    WasmJsClientEngineFactory()
