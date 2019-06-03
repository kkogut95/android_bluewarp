package blue_bay.app.features.register

import androidx.lifecycle.ViewModel
import com.mlykotom.valifi.ValiFiForm
import com.mlykotom.valifi.fields.ValiFieldText
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import blue_bay.app.R
import blue_bay.app.data.Resource
import blue_bay.app.data.api.sign_in.register.RegisterRequest
import blue_bay.app.data.repository.AppRepository
import blue_bay.app.data.repository.UserRepository
import blue_bay.app.utils.LiveDataDelegate
import blue_bay.app.utils.SingleLiveEvent
import blue_bay.app.utils.ValiFieldEmailPlaceholder
import blue_bay.app.utils.ValiFieldPlaceholder
import javax.inject.Inject

class RegisterViewModel @Inject constructor(
    private val userRepository: UserRepository,
    private val appRepository: AppRepository
) : ViewModel() {

    val registerLiveData = LiveDataDelegate(RegisterState())
    var state by registerLiveData
    private val disposable = CompositeDisposable()

    val errorLiveData = SingleLiveEvent<Void>()

    val emailInput = ValiFieldEmailPlaceholder().addPlaceholderText(R.string.email_label)
    val passwordInput = ValiFieldPlaceholder().addMinLengthValidator(R.string.password_label, 6)
    val repeatPasswordInput = ValiFieldPlaceholder().addVerifyFieldValidator(R.string.repeat_password_label, passwordInput)

    val registerPart1Form = ValiFiForm(emailInput, passwordInput, repeatPasswordInput)

    val countryInput = ValiFieldText().addNotEmptyValidator()
    val nameInput = ValiFieldPlaceholder().addMinLengthValidator(R.string.name_label, 1)
    val postCodeInput = ValiFieldPlaceholder().addMinLengthValidator(R.string.name_label, 1)
    val surnameInput = ValiFieldPlaceholder().addMinLengthValidator(R.string.surname_label, 1)
    var countryCode : String? = null

    val registerPart2Form = ValiFiForm(countryInput, nameInput, surnameInput)

    fun checkEmail() {
        if(!registerPart1Form.isValid){
            errorLiveData.call()
        } else {
            state = state.copy(step = Resource.Success(RegisterOptions.CheckEmail))
        }
    }

    fun register() {
        state = state.copy(step = Resource.Loading)

        if(!registerPart2Form.isValid){
            errorLiveData.call()
            return
        }
        disposable.add(appRepository.register(RegisterRequest(emailInput.value, passwordInput.value, nameInput.value,
                        countryCode))
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                userRepository.setToken(it.token)
                userRepository.setTokenType(it.tokenType)
                state = state.copy(step = Resource.Success(RegisterOptions.RegisterEmail))
            }, {
                state = state.copy(step = Resource.Error(it))
            }))
    }

    override fun onCleared() {
        registerPart1Form.destroy()
        registerPart2Form.destroy()
        disposable.clear()
        super.onCleared()
    }
}