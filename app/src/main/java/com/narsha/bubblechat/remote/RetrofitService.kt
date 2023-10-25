package dgsw.stac.knowledgender.remote

import com.narsha.bubblechat.ui.feature.start.LoginRequest
import com.narsha.bubblechat.ui.feature.start.LoginResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface RetrofitService {
    @POST("api/v1/user/signin")
    suspend fun doLogin(@Body body: LoginRequest): LoginResponse
}