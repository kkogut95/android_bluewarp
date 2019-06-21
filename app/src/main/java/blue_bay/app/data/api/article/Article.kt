package blue_bay.app.data.api.article

import blue_bay.app.data.api.base.BaseIDModel
import com.google.gson.annotations.SerializedName

class Article(
    @SerializedName("title")
    val title : String,

    @SerializedName("content")
    val content : String
) : BaseIDModel()