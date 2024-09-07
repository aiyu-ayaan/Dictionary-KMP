package com.atech.dict

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform