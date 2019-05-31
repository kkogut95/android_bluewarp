package blue_bay.app.data.repository

interface UserRepository {

    fun setTokenType(tokenType : String?)

    fun getTokenType() : String?

    fun setToken(token : String?)

    fun getToken() : String?
}