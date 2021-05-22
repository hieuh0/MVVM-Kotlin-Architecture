package com.nta.mvvm_kotlin

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.nta.mvvm_kotlin.base.BaseFragment
import com.nta.mvvm_kotlin.databinding.FragmentHomeBinding
import com.nta.mvvm_kotlin.extension.observe
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    private val viewModel by viewModels<HomeViewModel>()

    override fun getLayoutId() = R.layout.fragment_home

    override fun onInit() {
        with(viewModel){
            observe(loading,::handleLoading)
        }

        var loading = true
//        binding?.button.setOnClickListener {
////          val action = HomeFragmentDirections.actionHomeFragmentToDetailsFragment()
////          findNavController().navigate(action)
//            viewModel.handlerLoading(loading)
//            loading = !loading
//        }
    }

    private fun handleLoading(isLoading: Boolean) {
        showLoading(isLoading)
    }
}