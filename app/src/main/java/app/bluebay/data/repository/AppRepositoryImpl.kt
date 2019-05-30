package app.bluebay.data.repository


import io.reactivex.Single
import io.reactivex.subjects.BehaviorSubject
import io.reactivex.subjects.PublishSubject
import app.bluebay.data.api.AppApi
import java.util.concurrent.atomic.AtomicInteger
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AppRepositoryImpl @Inject
constructor(private val appApi: AppApi) : AppRepository {


    private val workingStateSubject = BehaviorSubject.create<Boolean>()
    private val dataChangeSubject = PublishSubject.create<Boolean>()
    private val workingLockCount = AtomicInteger(0)

    override fun mockFunction() =
            Single.fromObservable(appApi.mockRequest())
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