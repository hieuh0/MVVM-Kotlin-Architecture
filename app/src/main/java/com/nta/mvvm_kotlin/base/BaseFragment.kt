package com.nta.mvvm_kotlin.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

abstract class BaseFragment<DataBinding : ViewDataBinding>: Fragment() {

    private var _binding : DataBinding? = null

    abstract fun getLayoutId(): Int

    abstract fun onInit()

    val binding
    get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = DataBindingUtil.inflate(inflater,getLayoutId(),container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            lifecycleOwner = this@BaseFragment
        }
        onInit()
    }

    fun listenerLoading(viewModel : BaseViewModel){
        (activity as BaseActivity<*>).listenerLoading(viewModel)
    }

    fun showLoading(isLoading : Boolean){
        (activity as BaseActivity<*>).showLoading(isLoading)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onResume() {
        super.onResume()
    }


}