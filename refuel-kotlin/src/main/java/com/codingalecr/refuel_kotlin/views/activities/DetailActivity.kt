package com.codingalecr.refuel_kotlin.views.activities

import android.arch.lifecycle.ViewModelProviders
import com.codingalecr.refuel_kotlin.R
import com.codingalecr.refuel_kotlin.viewmodels.FuelItemViewModel
import com.codingalecr.refuel_kotlin.views.base.BaseActivity

/**
 * Created by aulate on 18/12/17.
 */

class DetailActivity : BaseActivity() {

    private var viewModel : FuelItemViewModel? = null

    override fun withToolbar() = false

    override fun getLayout() = R.layout.activity_detail

    override fun initObj() {
    }

    override fun initViewModel() {
        viewModel = ViewModelProviders.of(this).get(FuelItemViewModel::class.java)
    }

    override fun initObservers() {
    }

    override fun initUI() {
    }
}
