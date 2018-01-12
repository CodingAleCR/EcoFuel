package com.codingalecr.refuel_kotlin.views.activities

import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.codingalecr.refuel_kotlin.Contracts
import com.codingalecr.refuel_kotlin.ItemClickListener
import com.codingalecr.refuel_kotlin.R
import com.codingalecr.refuel_kotlin.viewmodels.FuelItemListViewModel
import com.codingalecr.refuel_kotlin.views.adapters.FuelItemListAdapter
import com.codingalecr.refuel_kotlin.views.base.BaseActivity
import com.codingalecr.refuel_kotlin.views.base.ProgressManager
import kotlinx.android.synthetic.main.activity_fuel_list.*

class FuelListActivity : BaseActivity(), ItemClickListener, ProgressManager {

    private var fuelListViewModel : FuelItemListViewModel? = null
    private var fuelListAdapter : FuelItemListAdapter? = FuelItemListAdapter()

    override fun withToolbar() = false

    override fun getLayout() = R.layout.activity_fuel_list

    override fun initViewModel() {
        fuelListViewModel = ViewModelProviders.of(this).get(FuelItemListViewModel::class.java)
    }

    override fun initObservers() {
        fuelListAdapter!!.listener = this
        fuelListViewModel!!.fuelItemList.observe(this, fuelListAdapter!!)
    }

    override fun initObj() {
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

    override fun clicked(viewId: Int, itemPosition: Int, isLongClick: Boolean) {
        when(viewId){
            R.id.fuel_list_item -> {
                val item = fuelListAdapter?.getItem(position = itemPosition)
                val previous = fuelListAdapter?.getItem(position = itemPosition-1)
                val toDetail = Intent(this, DetailActivity::class.java)
                toDetail.putExtra(Contracts.DetailActivityContract.ITEM, item)
                toDetail.putExtra(Contracts.DetailActivityContract.PREVIOUS_ITEM, previous)
                startActivityForResult(toDetail, Contracts.DetailActivityContract.REQUEST_CODE)
            }
        }
    }
}
