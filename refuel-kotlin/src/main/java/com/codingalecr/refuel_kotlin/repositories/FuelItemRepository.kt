package com.codingalecr.refuel_kotlin.repositories

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import com.codingalecr.refuel_kotlin.models.MFuelItem
import com.google.firebase.database.*

/**
 * Created by aulate on 5/1/18.
 */
class FuelItemRepository() {

    private var mFuelReference : DatabaseReference? = FirebaseDatabase.getInstance().getReference("refuels")

    var data : MutableLiveData<List<MFuelItem>> = MutableLiveData()

    fun getAllFuelItems() {
        val list = ArrayList<MFuelItem>()
        val fuelListListener = object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                list.clear()
                dataSnapshot.children.mapNotNullTo(list) { it.getValue<MFuelItem>(MFuelItem::class.java) }
                data.value = list
            }

            override fun onCancelled(databaseError: DatabaseError) {
                println("loadPost:onCancelled ${databaseError.toException()}")
            }
        }
        mFuelReference!!.addValueEventListener(fuelListListener)
    }
}