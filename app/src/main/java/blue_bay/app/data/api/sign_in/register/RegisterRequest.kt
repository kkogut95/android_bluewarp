package blue_bay.app.data.api.sign_in.register

import com.google.gson.annotations.SerializedName

data class RegisterRequest(
    @SerializedName("email")
    val email : String?,

    @SerializedName("password")
    val password : String?,

    @SerializedName("name")
    val name : String?,

    @SerializedName("country")
    val country : String?,

    @SerializedName("zip_code")
    val zipCode : String?
)