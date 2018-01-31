package com.codingalecr.refuel_kotlin.viewmodels

import android.arch.lifecycle.MutableLiveData
import com.codingalecr.refuel_kotlin.models.MFuelItem

/**
 * Created by aulate on 11/1/18.
 */
class DetailViewModel(private var previousItem : MFuelItem = MFuelItem(), item : MFuelItem  = MFuelItem()) : FuelItemViewModel(item) {

    var itemLiveData : MutableLiveData<MFuelItem> = MutableLiveData()

    fun setItems(previousItem : MFuelItem, item : MFuelItem) {
        this.previousItem = previousItem
        this.item = item
        itemLiveData.postValue(item)
    }

    fun getPerformance(): Float {
        return if (getKilometerDifference() > 0 && item.amountLt > 0) {
            getKilometerDifference() / item.amountLt
        } else 0f
    }

    fun getKilometerDifference(): Float {
        return if (previousItem.odometer < item.odometer) {
            item.odometer - previousItem.odometer
        } else 0f
    }

    fun priceByLiter(): Float {
        return if (item.amountLt > 0 && item.amountCash > 0) {
            item.amountCash / item.amountLt
        } else 0f
    }

    fun getLastRefuelDate() = previousItem.fuelingDate
}