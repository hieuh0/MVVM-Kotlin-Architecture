package com.nta.mvvm_kotlin.ui

import androidx.fragment.app.viewModels
import com.nta.mvvm_kotlin.R
import com.nta.mvvm_kotlin.base.BaseFragment
import com.nta.mvvm_kotlin.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    private val viewModel : HomeViewModel by viewModels()

    override fun getLayoutId() = R.layout.fragment_home

    override fun onInit() {

    }
}