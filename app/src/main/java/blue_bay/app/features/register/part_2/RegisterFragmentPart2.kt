package blue_bay.app.features.register.part_2

import android.os.Bundle
import android.text.InputFilter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.mukesh.countrypicker.Country

import blue_bay.app.databinding.FragmentRegister2Binding
import blue_bay.app.di.Injectable
import blue_bay.app.di.ViewModelInjectionFactory
import blue_bay.app.features.register.RegisterViewModel
import blue_bay.app.utils.AutoClearedValue
import javax.inject.Inject
import com.mukesh.countrypicker.listeners.OnCountryPickerListener
import com.mukesh.countrypicker.CountryPicker
import blue_bay.app.utils.MaskWatcher


class RegisterFragmentPart2 : Fragment(), Injectable, OnCountryPickerListener {


    private lateinit var mBinding: AutoClearedValue<FragmentRegister2Binding>

    @Inject
    lateinit var mainViewModelInjectionFactory: ViewModelInjectionFactory<RegisterViewModel>

    private val mViewModel: RegisterViewModel by lazy {
        ViewModelProviders.of(activity!!, mainViewModelInjectionFactory)
            .get(RegisterViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mBinding = AutoClearedValue(
            this,
            FragmentRegister2Binding.inflate(inflater, container, false)
        )

        mBinding.get().viewModel = mViewModel

        mBinding.get().etRegisterCountry.etProfileInput.setOnClickListener {
            val builder = CountryPicker.Builder().with(context!!)
                .listener(this)
            builder.build().showBottomSheet((activity as AppCompatActivity?)!!)
        }

        mBinding.get().etRegisterPostCode.etProfileInput.addTextChangedListener(MaskWatcher("##-###"))
        mBinding.get().etRegisterPostCode.etProfileInput.filters += InputFilter.LengthFilter(6)

        return mBinding.get().root
    }

    override fun onSelectCountry(country: Country?) {
        mViewModel.countryInput.set(country?.name)
        mViewModel.countryCode = country?.code
        mBinding.get().etRegisterPostCode.root.visibility = if (country?.code == "PL") {
            View.VISIBLE
        } else {
            View.GONE
        }
    }
}