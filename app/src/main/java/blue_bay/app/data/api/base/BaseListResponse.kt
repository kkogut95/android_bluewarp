package pl.tracker.app.data.api.base

import com.google.gson.annotations.SerializedName

data class BaseListResponse<T : BaseIDModel>(
    @SerializedName("data")
    val list: MutableList<T>
)