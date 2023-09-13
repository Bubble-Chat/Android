package com.narsha.bubblechat.ui.feature

data class LoginRequest(
    val provider: String,
    val token: String
)

data class LoginResponse(
    val name: String,
    val email: String,
    val accessToken: String,
    val exists: Boolean
)


