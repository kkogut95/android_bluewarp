package blue_bay.app.data.api

import blue_bay.app.data.api.article.Article
import blue_bay.app.data.api.base.BaseListResponse
import io.reactivex.Observable
import blue_bay.app.data.api.sign_in.login.LoginRequest
import blue_bay.app.data.api.sign_in.login.LoginResponse
import blue_bay.app.data.api.sign_in.register.RegisterRequest
import blue_bay.app.data.api.sign_in.register.RegisterResponse
import retrofit2.http.*

interface AppApi {

    @GET("articles")
    fun getArticles(@QueryMap request: Map<String, String>): Observable<BaseListResponse<Article>>
}