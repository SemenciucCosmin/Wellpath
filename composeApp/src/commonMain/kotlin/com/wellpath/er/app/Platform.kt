package com.wellpath.er.app

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform