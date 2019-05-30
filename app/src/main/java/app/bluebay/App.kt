package app.bluebay

import android.app.Activity
import android.app.Application
import com.mlykotom.valifi.ValiFi
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import app.bluebay.di.AppInjector
import javax.inject.Inject

class App : Application(), HasActivityInjector{

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    override fun activityInjector(): DispatchingAndroidInjector<Activity> = dispatchingAndroidInjector

    override fun onCreate() {
        super.onCreate()
        AppInjector.init(this)
        ValiFi.install(this)
    }
}