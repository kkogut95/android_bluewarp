package blue_bay.app.data.api.sign_in.login

import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @SerializedName("access_token")
    val token: String?,

    @SerializedName("login")
    val loginSuccessful : Boolean?,

    @SerializedName("token_type")
    val tokenType : String?
)