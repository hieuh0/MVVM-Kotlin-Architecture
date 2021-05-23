package com.nta.mvvm_kotlin.ui

import com.nta.mvvm_kotlin.R
import com.nta.mvvm_kotlin.base.BaseFragment
import com.nta.mvvm_kotlin.databinding.FragmentDetailsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailsFragment : BaseFragment<FragmentDetailsBinding>() {
    override fun getLayoutId() = R.layout.fragment_details

    override fun onInit() {
    }

}