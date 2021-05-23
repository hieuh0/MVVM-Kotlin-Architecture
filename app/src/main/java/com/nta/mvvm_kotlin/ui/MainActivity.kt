package com.nta.mvvm_kotlin.ui


import com.nta.mvvm_kotlin.R
import com.nta.mvvm_kotlin.base.BaseActivity
import com.nta.mvvm_kotlin.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>() {

    override fun getLayoutId() = R.layout.activity_main
    override fun onInit() {
//        listenerLoading(viewModel)
//        val host = NavHostFragment.create(R.navigation.home_navigation)
//        supportFragmentManager.beginTransaction().replace(R.id.nav_host_fragment, host).setPrimaryNavigationFragment(host).commit()
//        addFragment(HomeFragment(),R.id.fragment_container)
    }
}