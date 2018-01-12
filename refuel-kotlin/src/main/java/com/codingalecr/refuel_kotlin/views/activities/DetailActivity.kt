package com.codingalecr.refuel_kotlin.views.activities

import android.arch.lifecycle.ViewModelProviders
import com.codingalecr.refuel_kotlin.Contracts
import com.codingalecr.refuel_kotlin.R
import com.codingalecr.refuel_kotlin.models.MFuelItem
import com.codingalecr.refuel_kotlin.viewmodels.DetailViewModel
import com.codingalecr.refuel_kotlin.views.base.BaseActivity

/**
 * Created by aulate on 18/12/17.
 */

class DetailActivity : BaseActivity() {

    private var viewModel : DetailViewModel? = null

    override fun withToolbar() = false

    override fun getLayout() = R.layout.activity_detail

    override fun initObj() {
        if (intent.hasExtra(Contracts.DetailActivityContract.ITEM)
                && intent.hasExtra(Contracts.DetailActivityContract.PREVIOUS_ITEM)) {
            val item = intent.getSerializableExtra(Contracts.DetailActivityContract.ITEM) as MFuelItem
            val previous = intent.getSerializableExtra(Contracts.DetailActivityContract.PREVIOUS_ITEM) as MFuelItem
            viewModel?.setItems(previousItem = previous, item = item)
        }
    }

    override fun initViewModel() {
        viewModel = ViewModelProviders.of(this).get(DetailViewModel::class.java)
    }

    override fun initObservers() {
    }

    override fun initUI() {
    }
}
