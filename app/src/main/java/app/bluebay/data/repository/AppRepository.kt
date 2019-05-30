package app.bluebay.data.repository


import io.reactivex.Single
import app.bluebay.data.model.api.BooleanResponse

interface AppRepository : BaseRepository {

    fun mockFunction() : Single<BooleanResponse>

}