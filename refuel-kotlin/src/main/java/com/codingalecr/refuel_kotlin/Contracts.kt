package com.codingalecr.refuel_kotlin

/**
 * Created by aulate on 22/12/17.
 */

class Contracts {
    interface DetailActivityContract {
        companion object {
            val REQUEST_CODE = 101
            val ITEM = "ITEM"
            val PREVIOUS_ITEM = "PREVIOUS"
        }
    }
    interface FormActivityContract {
        companion object {
            val REQUEST_CODE = 102
        }
    }
}
