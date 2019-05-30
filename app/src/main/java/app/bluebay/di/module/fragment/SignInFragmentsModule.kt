package app.bluebay.di.module.fragment

import dagger.Module
import dagger.android.ContributesAndroidInjector
import app.bluebay.features.menu.login.LoginFragment
import app.bluebay.features.menu.login.ResetPasswordFragment

@Module
abstract class SignInFragmentsModule {

    @ContributesAndroidInjector
    abstract fun contributeLoginFragment(): LoginFragment

    @ContributesAndroidInjector
    abstract fun contributeResetPasswordFragment(): ResetPasswordFragment

}