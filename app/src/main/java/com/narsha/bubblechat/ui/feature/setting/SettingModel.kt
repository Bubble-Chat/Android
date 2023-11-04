package com.narsha.bubblechat.ui.feature.setting

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