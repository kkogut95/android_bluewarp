package blue_bay.app.features.main

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import blue_bay.app.data.repository.AppRepository
import blue_bay.app.data.repository.UserRepository
import blue_bay.app.utils.LiveDataDelegate
import blue_bay.app.utils.SingleLiveEvent
import javax.inject.Inject

class MainViewModel @Inject constructor(private val userRepository: UserRepository,
                                        private val appRepository: AppRepository): ViewModel(){

    val mainLiveData = LiveDataDelegate(MainState())
    var state by mainLiveData
    private val disposable = CompositeDisposable()

    val errorLiveData = SingleLiveEvent<Void>()

    /*fun signIn() {
        state = state.copy(step = Resource.Loading)

        if(!loginForm.isValid){
            errorLiveData.call()
            return
        }
        disposable.add(appRepository.login(LoginRequest(loginInput.value!!, passwordInput.value!!))
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                userRepository.setTokenType(it.tokenType)
                userRepository.setToken(it.token)
                state = state.copy(step = Resource.Success(SignInMenuOptions.LoginEmail))
            }, {
                state = state.copy(step = Resource.Error(it))
            }))
    }*/

    override fun onCleared() {
        disposable.clear()
        super.onCleared()

    }
}