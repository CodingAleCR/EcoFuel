package com.codingalecr.refuel_kotlin.viewmodels

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import com.codingalecr.refuel_kotlin.models.MFuelItem
import com.codingalecr.refuel_kotlin.repositories.FuelItemRepository
import com.google.firebase.database.DatabaseReference
import java.util.*
import android.arch.lifecycle.MutableLiveData



/**
 * Created by aulate on 5/1/18.
 */
class FuelItemViewModel(var item: MFuelItem = MFuelItem()) : ViewModel() {

    private var fuelItemRepository: FuelItemRepository = FuelItemRepository()

    init {
        item = MFuelItem()
    }

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

    fun addRefuelItem(fuelingDate: Long = Date().time,
                      amountLt: Float? = 0.toFloat(),
                      amountCash: Float? = 0.toFloat(),
                      odometer: Float? = 0.toFloat()) {
        item = MFuelItem(
                fuelingDate = fuelingDate,
                amountCash = amountCash!!,
                amountLt = amountLt!!,
                odometer = odometer!!
        )

        val listener = DatabaseReference.CompletionListener { databaseError, _ ->
            if (databaseError == null) {

            }
        }

        fuelItemRepository.addRefuel(item, listener)

    }


}