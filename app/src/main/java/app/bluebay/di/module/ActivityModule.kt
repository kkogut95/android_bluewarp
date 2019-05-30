package app.bluebay.di.module

import dagger.Module
import dagger.android.ContributesAndroidInjector
import app.bluebay.di.ActivityScope
import app.bluebay.di.module.fragment.SignInFragmentsModule
import app.bluebay.features.menu.SignInMenuActivity

@Module
abstract class ActivityModule{
    @ActivityScope
    @ContributesAndroidInjector(modules = [(SignInFragmentsModule::class)])
    abstract fun contributeSignInMenuActivity() : SignInMenuActivity
}