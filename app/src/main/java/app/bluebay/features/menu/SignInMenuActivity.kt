package app.bluebay.features.menu

import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import app.bluebay.R
import app.bluebay.di.ViewModelInjectionFactory
import app.bluebay.widgets.BaseNavActivity
import javax.inject.Inject

class SignInMenuActivity : BaseNavActivity(){

    @Inject
    lateinit var viewModelInjectionFactory: ViewModelInjectionFactory<SignInMenuViewModel>

    private val mViewModel: SignInMenuViewModel by lazy {
        ViewModelProviders.of(this, viewModelInjectionFactory)
            .get(SignInMenuViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getNavController().setGraph(R.navigation.navigation_sign_in_menu)

    }

    private fun initToolbar(){

    }
}