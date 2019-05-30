package app.bluebay.data.repository

import android.content.SharedPreferences
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserRepositoryImpl @Inject constructor(private val sharedPref: SharedPreferences) : UserRepository {

    companion object {
    }
}