package blue_bay.app.data.model.api

import com.google.gson.annotations.SerializedName

data class BooleanResponse(
    @SerializedName("code")
    val response: Boolean
)