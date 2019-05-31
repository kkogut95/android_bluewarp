package blue_bay.app.di.module.fragment

import dagger.Module
import dagger.android.ContributesAndroidInjector
import blue_bay.app.features.register.part_1.RegisterFragmentPart1
import blue_bay.app.features.register.part_2.RegisterFragmentPart2

@Module
abstract class RegisterFragmentsModule {

    @ContributesAndroidInjector
    abstract fun contributeRegisterPart1Fragment(): RegisterFragmentPart1

    @ContributesAndroidInjector
    abstract fun contributeRegisterPart2Fragment(): RegisterFragmentPart2

}