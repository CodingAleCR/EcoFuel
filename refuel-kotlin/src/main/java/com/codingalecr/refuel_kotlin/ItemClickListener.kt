package com.codingalecr.refuel_kotlin

/**
 * Created by aulate on 11/1/18.
 */
interface ItemClickListener {
    fun clicked(viewId : Int, itemPosition: Int, isLongClick : Boolean)
}