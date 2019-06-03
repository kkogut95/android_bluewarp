package blue_bay.app.features.menu

import blue_bay.app.data.Resource

class SignInMenuState(
    var step: Resource<SignInMenuOptions> = Resource.Empty
)

sealed class SignInMenuOptions {
    object LoginEmail : SignInMenuOptions()
    object ResetPassword : SignInMenuOptions()
}