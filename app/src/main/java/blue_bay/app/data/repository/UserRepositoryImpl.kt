package blue_bay.app.data.repository

import android.content.SharedPreferences
import androidx.core.content.edit
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserRepositoryImpl @Inject constructor(private val sharedPref: SharedPreferences) : UserRepository {
    override fun setTokenType(tokenType: String?) =
        sharedPref.edit {putString(TOKEN_TYPE, tokenType)}

    override fun getTokenType(): String? =
        sharedPref.getString(TOKEN_TYPE, "")

    override fun setToken(token: String?) =
        sharedPref.edit { putString(TOKEN, token) }

    override fun getToken(): String? =
        sharedPref.getString(TOKEN, "")

    companion object {
        const val TOKEN_TYPE = "TOKEN_TYPE"
        const val TOKEN = "TOKEN"
    }
}