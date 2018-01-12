package com.codingalecr.refuel_kotlin.viewmodels

import com.codingalecr.refuel_kotlin.models.MFuelItem

/**
 * Created by aulate on 11/1/18.
 */
class DetailViewModel(var previousItem : MFuelItem = MFuelItem(), item : MFuelItem) : FuelItemViewModel(item) {

    fun setItems(previousItem : MFuelItem, item : MFuelItem) {
        this.previousItem = previousItem
        this.item = item
    }

    fun getPerformance(): Float {
        return if (getKilometerDifference(previousItem.odometer) > 0 && item.amountLt > 0) {
            getKilometerDifference(previousItem.odometer) / item.amountLt
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