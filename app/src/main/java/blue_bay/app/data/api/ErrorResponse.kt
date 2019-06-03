package blue_bay.app.data.api

import com.google.gson.annotations.SerializedName

data class ErrorResponse(
    @SerializedName("status")
    val code: Int,

    @SerializedName("message")
    val message: String
)