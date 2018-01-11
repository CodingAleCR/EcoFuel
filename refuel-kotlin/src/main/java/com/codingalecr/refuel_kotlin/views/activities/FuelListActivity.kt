package com.codingalecr.refuel_kotlin.views.activities

import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.codingalecr.refuel_kotlin.R
import com.codingalecr.refuel_kotlin.viewmodels.FuelItemListViewModel
import com.codingalecr.refuel_kotlin.views.adapters.FuelItemListAdapter
import com.codingalecr.refuel_kotlin.views.base.BaseActivity
import com.codingalecr.refuel_kotlin.views.base.ProgressManager
import kotlinx.android.synthetic.main.activity_fuel_list.*

class FuelListActivity : BaseActivity(), ProgressManager {

    private var fuelListViewModel : FuelItemListViewModel? = null
    private var fuelListAdapter : FuelItemListAdapter? = FuelItemListAdapter()

    override fun withToolbar() = false

    override fun getLayout() = R.layout.activity_fuel_list

    override fun initViewModel() {
        fuelListViewModel = ViewModelProviders.of(this).get(FuelItemListViewModel::class.java)
    }

    override fun initObservers() {
        fuelListViewModel!!.fuelItemList.observe(this, fuelListAdapter!!)
    }

    override fun initObj() {
        fuelListViewModel!!.initFuelList()
        launch_add_refuel.setOnClickListener {
            val launchAddRefuel = Intent(this, FuelFormActivity::class.java)
            startActivity(launchAddRefuel)
        }
    }

    override fun initUI() {
        setupRecycler()
    }

    private fun setupRecycler() {
        fuel_list.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, true)
        fuel_list.adapter = fuelListAdapter
        fuelListAdapter!!.notifyDataSetChanged()
        hideProgress()
    }

    override fun showProgress() {
        progress.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        progress.visibility = View.GONE
    }
}
