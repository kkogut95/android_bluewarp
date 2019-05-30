package app.bluebay.features.menu

import androidx.lifecycle.ViewModel
import com.mlykotom.valifi.fields.ValiFieldText
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import app.bluebay.data.Resource
import app.bluebay.data.repository.AppRepository
import app.bluebay.data.repository.UserRepository
import app.bluebay.utils.LiveDataDelegate
import javax.inject.Inject

class SignInMenuViewModel @Inject constructor(private val userRepository: UserRepository,
                                              private val appRepository: AppRepository): ViewModel(){

    val loginInput = ValiFieldText()
    val passwordInput = ValiFieldText()

    val faqLiveData = LiveDataDelegate(SignInMenuState())
    var state by faqLiveData
    private val disposable = CompositeDisposable()

    fun signIn() {
        state = state.copy(step = Resource.Loading)

        disposable.add(appRepository.mockFunction()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                state = state.copy(step = Resource.Success(SignInMenuOptions.LoginEmail))
            }, {
                state = state.copy(step = Resource.Error(it))
            }))
    }
}