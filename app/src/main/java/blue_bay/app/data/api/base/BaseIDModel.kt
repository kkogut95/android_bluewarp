package pl.tracker.app.data.api.base

import androidx.recyclerview.widget.DiffUtil
import com.google.gson.annotations.SerializedName
import pl.tracker.app.data.api.ranking.RankingItem

abstract class BaseIDModel (
    @SerializedName("id")
    val id : String? = null
)