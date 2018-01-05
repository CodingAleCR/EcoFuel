package com.codingalecr.refuel_kotlin.viewmodels

import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import com.codingalecr.refuel_kotlin.models.MFuelItem
import com.codingalecr.refuel_kotlin.repositories.FuelItemRepository

/**
 * Created by aulate on 5/1/18.
 */
class FuelItemListViewModel : ViewModel(), LifecycleObserver {

    private var fuelItemRepository : FuelItemRepository = FuelItemRepository()
    val fuelItemList:  LiveData<List<MFuelItem>> = fuelItemRepository.data

    fun initFuelList() {
        fuelItemRepository.getAllFuelItems()
    }

}