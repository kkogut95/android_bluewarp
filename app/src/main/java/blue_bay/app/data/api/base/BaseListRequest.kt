package pl.tracker.app.data.api.base

import com.google.gson.annotations.SerializedName
import pl.tracker.app.data.contracts.Constants

data class BaseListRequest(
    @SerializedName("offset")
    var offset: Int = 0,

    @SerializedName("limit")
    var limit: Int = Constants.LIST_BASE_LIMIT,

    //TODO move to child class
    @SerializedName("gender")
    var gender : String? = null,

    @SerializedName("period")
    var period : String? = null

)