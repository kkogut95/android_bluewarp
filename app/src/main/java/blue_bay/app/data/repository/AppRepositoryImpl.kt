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


    private val workingStateSubject = BehaviorSubject.create<Boolean>()
    private val dataChangeSubject = PublishSubject.create<Boolean>()
    private val workingLockCount = AtomicInteger(0)

    override fun login(request: LoginRequest) =
            Single.fromObservable(appApi.login(request))
                    .doOnSubscribe { incrementWorkingLock() }
                    .doFinally(this::decrementWorkingLock)!!

    override fun register(request: RegisterRequest) =
        Single.fromObservable(appApi.register(request))
            .doOnSubscribe { incrementWorkingLock() }
            .doFinally(this::decrementWorkingLock)!!


    override fun getWorkingStateSubject(): BehaviorSubject<Boolean> {
        return workingStateSubject
    }


    override fun getDataChangeSubject(): PublishSubject<Boolean> {
        return dataChangeSubject
    }

    /**
     * Increment working jobs counter.
     */
    @Synchronized
    private fun incrementWorkingLock() {
        val previousCount = workingLockCount.getAndIncrement()
        if (previousCount <= 0) {
            workingStateSubject.onNext(true)
        }
    }

    /**
     * Decrement working jobs counter.
     */
    @Synchronized
    private fun decrementWorkingLock() {
        val count = workingLockCount.decrementAndGet()
        if (count <= 0) {
            workingStateSubject.onNext(false)
        }
    }
}