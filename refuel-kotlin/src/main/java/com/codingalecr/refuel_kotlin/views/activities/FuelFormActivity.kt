package com.codingalecr.refuel_kotlin.views.activities

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import com.codingalecr.refuel_kotlin.R
import com.codingalecr.refuel_kotlin.getDateInMillis
import com.codingalecr.refuel_kotlin.viewmodels.FuelItemViewModel
import com.codingalecr.refuel_kotlin.views.base.BaseActivity
import kotlinx.android.synthetic.main.activity_fuel_item_form.*
import org.jetbrains.anko.longToast
import org.jetbrains.anko.toast
import java.util.*

/**
 * Created by aulate on 10/1/18.
 */

class FuelFormActivity : BaseActivity() {

    private var fuelItemViewModel: FuelItemViewModel? = null

    override fun withToolbar(): Boolean {
        return false
    }

    override fun getLayout(): Int {
        return R.layout.activity_fuel_item_form
    }

    override fun initObj() {
        add_refuel.setOnClickListener {
            fuelItemViewModel!!.addRefuelItem(
                    datePicker_refuel_date.getDateInMillis(),
                    textInput_liters.editText!!.text.toString().toFloatOrNull(),
                    textInput_cash.editText!!.text.toString().toFloatOrNull(),
                    textInput_kilometers.editText!!.text.toString().toFloatOrNull()
            )
        }
    }

    override fun initViewModel() {
        fuelItemViewModel = ViewModelProviders.of(this).get(FuelItemViewModel::class.java)
    }

    override fun initObservers() {
        val observer = Observer<Boolean> {
            if (it!!) {
                longToast(R.string.refuel_added)
                finish()
            }
        }

        fuelItemViewModel?.isSaved?.observe(this, observer)
    }

    override fun initUI() {

    }

    fun clearForm() {
        textInput_cash.editText!!.text = null
        textInput_liters.editText!!.text = null
        textInput_kilometers.editText!!.text = null
        clearDatePicker()
    }

    fun clearDatePicker() {
        val now = Date()
        val cal = Calendar.getInstance()
        cal.time = now

        datePicker_refuel_date.init(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH), null)
    }
}
