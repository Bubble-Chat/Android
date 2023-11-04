package com.narsha.bubblechat.ui.feature.friend

data class GetUserInfoResponse(
    val email: String,
    val name: String,
    val photoPath: String
)
//{
//    "email": String,
//    "name": String,
//    "photoPath": String
//}
data class UpdateUserInfoResponse(
    val name: String,
    val photoPath: String
)
//{
//    "name": String,
//    "photoPath": String
//}