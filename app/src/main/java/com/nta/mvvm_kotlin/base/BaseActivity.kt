package com.nta.mvvm_kotlin.base

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.nta.mvvm_kotlin.R
import com.nta.mvvm_kotlin.utils.extension.beGone
import com.nta.mvvm_kotlin.utils.extension.beVisibleIf
import com.nta.mvvm_kotlin.utils.extension.observe

abstract class BaseActivity<DataBinding : ViewDataBinding> : AppCompatActivity() {

    private var _binding: DataBinding? = null

    abstract fun onInit()

    val binding get() = _binding

    abstract fun getLayoutId(): Int

    private lateinit var loadingView: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = DataBindingUtil.setContentView(this, getLayoutId())
        _binding!!.executePendingBindings()
        _binding!!.apply {
            lifecycleOwner = this@BaseActivity
        }
        initLoadingView()
        onInit()
    }

    fun listenerLoading(viewModel: BaseViewModel) {
        with(viewModel) {
            observe(loading){
                // TODO
            }
        }
    }

    fun addFragment(
        fragment: Fragment,
        containerId: Int,
        isAddToBackStack: Boolean = true,
        bundle: Bundle? = null,
        tag: String? = null
    ) {
        supportFragmentManager.beginTransaction().apply {
            add(containerId, fragment.apply { bundle?.let { arguments = it } })
            if (isAddToBackStack) {
                addToBackStack(tag ?: fragment::class.java.name)
            }
            setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
            commit()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    @SuppressLint("InflateParams")
    private fun initLoadingView() {
        loadingView = LayoutInflater.from(this).inflate(R.layout.loading_view, null).apply {
            z = 500f
            beGone()
            bringToFront()
            setOnClickListener { }
        }
        val container = findViewById<ViewGroup>(android.R.id.content).rootView as ViewGroup
        container.addView(loadingView)
        container.invalidate()
    }

    fun showLoading(isLoading: Boolean) {
        loadingView.beVisibleIf(isLoading)
    }

}