package com.codingalecr.refuel_kotlin.views.activities

import android.content.Intent
import com.codingalecr.refuel_kotlin.R
import com.codingalecr.refuel_kotlin.views.base.BaseActivity
import kotlinx.android.synthetic.main.activity_menu.*

class MenuActivity : BaseActivity() {

    override fun withToolbar() = true

    override fun getLayout() = R.layout.activity_menu

    override fun initObj() {
        btn_fuel_list.setOnClickListener {
            val i = Intent(this, FuelListActivity::class.java)
            startActivity(i)
        }
    }

    override fun initViewModel() {
    }

    override fun initObservers() {
    }

    override fun initUI() {
    }
}
