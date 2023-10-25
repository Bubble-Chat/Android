package com.narsha.bubblechat.ui.feature.start

data class LoginRequest(
    val email: String,
    val name: String
)

//"email": String,
//"name": String

data class LoginResponse(
    val name: String,
    val email: String,
    val accessToken: String,
    val exists: Boolean
)
//{
//    "name": String,
//    "email": String,
//    "accessToken": String,
//    "exists": boolean
//}


