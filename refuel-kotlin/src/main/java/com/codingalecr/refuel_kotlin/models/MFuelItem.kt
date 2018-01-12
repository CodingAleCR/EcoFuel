package com.codingalecr.refuel_kotlin.models

import java.io.Serializable
import java.util.*

/**
 * Created by Alejandro on 11/27/2017.
 */

data class MFuelItem(var uuid: String? = null,
                     var fuelingDate: Long = Date().time,
                     var amountLt: Float = 0.toFloat(),
                     var amountCash: Float = 0.toFloat(),
                     var odometer: Float = 0.toFloat()) : Serializable {
}