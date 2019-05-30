package blue_bay.app.data.api

import io.reactivex.Observable
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Headers
import blue_bay.app.data.api.sign_in.login.LoginRequest
import blue_bay.app.data.api.sign_in.login.LoginResponse
import blue_bay.app.data.api.sign_in.register.RegisterRequest
import blue_bay.app.data.api.sign_in.register.RegisterResponse

interface AppApi {

    @Headers("Content-type: app/json")
    @POST("auth/login")
    fun login(@Body request: LoginRequest): Observable<LoginResponse>

    @Headers("Content-type: app/json")
    @POST("auth/signup")
    fun register(@Body request: RegisterRequest): Observable<RegisterResponse>
}