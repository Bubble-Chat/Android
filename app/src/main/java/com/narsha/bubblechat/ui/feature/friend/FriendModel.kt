package com.narsha.bubblechat.ui.feature.friend



data class FriendResponseList(
    val friendResponseList: List<FriendResponse>
)
data class FriendResponse(
    val idx: Int,
    val email: String,
    val friend: Friend
)
data class Friend(
    val email: String,
    val name: String,
    val photoPath: String
)

//[
//  {
//      "idx": 4,
//      "email": "hinu0622@dgsw.hs.kr",
//      "friend": {
//          "email": "gmbae06@dgsw.hs.kr",
//          "name": "조근호",
//          "photoPath": null
//      }
//  },
//  {
//       "idx": 3,
//       "email": "hinu0622@dgsw.hs.kr",
//       "friend": {
//           "email": "whqkrqkr1@gmail.com",
//           "name": "근호조",
//           "photoPath": null
//      }
//  }
//]