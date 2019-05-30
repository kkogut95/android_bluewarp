package app.bluebay.features.menu.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import app.bluebay.data.Resource
import app.bluebay.databinding.FragmentSignInMenuBinding
import app.bluebay.di.Injectable
import app.bluebay.di.ViewModelInjectionFactory
import app.bluebay.features.menu.SignInMenuViewModel
import app.bluebay.utils.AutoClearedValue
import javax.inject.Inject

class LoginFragment : Fragment(), Injectable{

    private lateinit var mBinding : AutoClearedValue<FragmentSignInMenuBinding>

    @Inject
    lateinit var mainViewModelInjectionFactory: ViewModelInjectionFactory<SignInMenuViewModel>

    private val mViewModel: SignInMenuViewModel by lazy {
        ViewModelProviders.of(activity!!, mainViewModelInjectionFactory)
            .get(SignInMenuViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mBinding = AutoClearedValue(this,
            FragmentSignInMenuBinding.inflate(inflater, container, false))

        mViewModel.signIn()

        mViewModel.faqLiveData.observe(this){
            if(it.step is Resource.Success){
                Toast.makeText(context!!, "It works", Toast.LENGTH_LONG).show()
            } else if (it.step is Resource.Error){
                Toast.makeText(context!!, (it.step as Resource.Error).errorResponse.error.message, Toast.LENGTH_LONG).show()
            }
        }

        return mBinding.get()?.root
    }
}