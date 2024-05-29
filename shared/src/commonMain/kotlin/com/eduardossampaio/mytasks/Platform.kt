package com.eduardossampaio.mytasks

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform