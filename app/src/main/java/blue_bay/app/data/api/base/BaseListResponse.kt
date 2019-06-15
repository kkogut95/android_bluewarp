package pl.tracker.app.data.api.base

import blue_bay.app.data.api.base.BaseIDModel
import com.google.gson.annotations.SerializedName

data class BaseListResponse<T : BaseIDModel>(
    @SerializedName("data")
    val list: MutableList<T>
)