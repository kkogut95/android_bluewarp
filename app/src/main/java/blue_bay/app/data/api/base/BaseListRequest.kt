package blue_bay.app.data.api.base

import com.google.gson.annotations.SerializedName

data class BaseListRequest(
    @SerializedName("offset")
    var offset: Int = 0,

    @SerializedName("limit")
    var limit: Int = 30,

    //TODO move to child class
    @SerializedName("gender")
    var gender : String? = null,

    @SerializedName("period")
    var period : String? = null

)