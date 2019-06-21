package blue_bay.app.data.api.tags

import com.google.gson.annotations.SerializedName

class Tag (
    @SerializedName("id")
    val id : Int,

    @SerializedName("name")
    val name : String
)