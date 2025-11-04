package com.wellpath.er

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform