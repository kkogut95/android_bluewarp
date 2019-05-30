package app.bluebay.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import app.bluebay.App
import app.bluebay.di.module.ActivityModule
import app.bluebay.di.module.ApiModule
import app.bluebay.di.module.AppModule
import app.bluebay.di.module.DataModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidSupportInjectionModule::class, AppModule::class, ApiModule::class,
    ActivityModule::class, DataModule::class])
interface AppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(app: App)
}