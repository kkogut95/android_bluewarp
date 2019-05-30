package blue_bay.app.data.api

import com.google.gson.annotations.SerializedName

data class ErrorApi(
    @SerializedName("code")
    val code: Int,
    @SerializedName("message")
    val message: String

)