package blue_bay.app.data.api.base

import blue_bay.app.utils.Constants

class BaseListRequest (
    var page : Int = 0,

    val size : Int = Constants.LIST_BASE_LIMIT,

    val token : String
) {
    fun toMap() : Map<String, String> {
        val map = mapOf("size" to size.toString(),
            "page" to page.toString())
        return map
    }
}