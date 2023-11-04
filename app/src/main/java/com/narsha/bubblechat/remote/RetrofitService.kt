package com.narsha.bubblechat.remote

import com.narsha.bubblechat.ui.feature.friend.FriendResponseList
import com.narsha.bubblechat.ui.feature.setting.GetUserInfoResponse
import com.narsha.bubblechat.ui.feature.start.LoginRequest
import com.narsha.bubblechat.ui.feature.start.LoginResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface RetrofitService {
    @POST("api/v1/user/signin")
    suspend fun doLogin(@Body body: LoginRequest): LoginResponse

    @GET("api/v1/user/info")
    suspend fun getUserInfo(@Header("Authorization")token: String): GetUserInfoResponse

    @GET("api/v1/friend/list")
    suspend fun getFriendList(@Header("Authorization")token: String): FriendResponseList
}