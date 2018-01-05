package com.codingalecr.refuel_kotlin.viewmodels

import com.codingalecr.refuel_kotlin.models.MFuelItem

/**
 * Created by aulate on 5/1/18.
 */
class FuelItemViewModel(var item: MFuelItem) {

    fun getPerformance(kilometers: Float): Float {
        return if (getKilometerDifference(kilometers) > 0 && item.amountLt > 0) {
            getKilometerDifference(kilometers) / item.amountLt
        } else 0f
    }

    fun getKilometerDifference(kilometers: Float): Float {
        return if (kilometers < kilometers) {
            kilometers - kilometers
        } else 0f
    }

    fun priceByLiter(): Float {
        return if (item.amountLt > 0 && item.amountCash > 0) {
            item.amountCash / item.amountLt
        } else 0f
    }

}