package app.bluebay.data.api

import io.reactivex.Observable
import retrofit2.http.GET
import app.bluebay.data.model.api.BooleanResponse

interface AppApi {
    @GET("/v2/5ba1fbac2f00005c008d2b19?mocky-delay=200ms")
    fun mockRequest(): Observable<BooleanResponse>
}