package com.nta.mvvm_kotlin

import com.nta.mvvm_kotlin.base.BaseFragment
import com.nta.mvvm_kotlin.databinding.FragmentDetailsBinding

class DetailsFragment : BaseFragment<FragmentDetailsBinding>() {
    override fun getLayoutId() = R.layout.fragment_details

    override fun onInit() {
    }
}