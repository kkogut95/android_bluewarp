package app.bluebay.data.api

import com.google.gson.annotations.SerializedName

data class ErrorApi(
    @SerializedName("code")
    val code: Int,
    @SerializedName("message")
    val message: String

)