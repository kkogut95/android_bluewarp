package blue_bay.app.data.repository


import io.reactivex.Single
import io.reactivex.subjects.BehaviorSubject
import io.reactivex.subjects.PublishSubject
import blue_bay.app.data.api.AppApi
import blue_bay.app.data.api.sign_in.login.LoginRequest
import blue_bay.app.data.api.sign_in.register.RegisterRequest
import java.util.concurrent.atomic.AtomicInteger
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AppRepositoryImpl @Inject
constructor(private val appApi: AppApi) : AppRepository {

    override fun login(request: LoginRequest) =
            Single.fromObservable(appApi.login(request))

    override fun register(request: RegisterRequest) =
        Single.fromObservable(appApi.register(request))


}