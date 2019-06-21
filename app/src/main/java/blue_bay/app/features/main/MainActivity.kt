package blue_bay.app.features.main

import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import blue_bay.app.R
import blue_bay.app.data.Resource
import blue_bay.app.data.api.ErrorResponse
import blue_bay.app.databinding.ActivityMainBinding
import blue_bay.app.di.ViewModelInjectionFactory
import blue_bay.app.utils.ToastHelper
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

class MainActivity : AppCompatActivity(), HasSupportFragmentInjector{

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>

    @Inject
    lateinit var viewModelInjectionFactory: ViewModelInjectionFactory<MainViewModel>

    override fun supportFragmentInjector(): AndroidInjector<Fragment> = dispatchingAndroidInjector

    private val viewModel: MainViewModel by lazy {
        ViewModelProviders.of(this, viewModelInjectionFactory)
            .get(MainViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val mainActivityBinding : ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        initViewModel(mainActivityBinding)
        findNavController(R.id.fragment_navigation).setGraph(R.navigation.navigation_main)
    }

    private fun initViewModel(activityMainBinding: ActivityMainBinding) {
        viewModel.mainLiveData.observe(this) {
            activityMainBinding.loadingState.resource = it.step
            if (it.step is Resource.Success) {
                when ((it.step as Resource.Success<MainOptions>).data) {

                }
            } else if (it.step is Resource.Error) {
                val error = it.step as Resource.Error
                ToastHelper.showError(this, error.errorResponse.message)
            }
        }
    }
}