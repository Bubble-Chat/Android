package dgsw.stac.knowledgender.remote

import com.narsha.bubblechat.ui.feature.LoginRequest
import com.narsha.bubblechat.ui.feature.LoginResponse
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.Query

interface RetrofitService {
    @POST("api/v1/user/signin")
    suspend fun doLogin(@Body body: LoginRequest): LoginResponse
}