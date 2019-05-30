package app.bluebay.features.menu

import app.bluebay.data.Resource

data class SignInMenuState(
    var step: Resource<SignInMenuOptions> = Resource.Empty
)

sealed class SignInMenuOptions {
    object LoginEmail : SignInMenuOptions()
}