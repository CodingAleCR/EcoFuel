package com.codingalecr.refuel_kotlin.repositories

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.database.Observable
import android.widget.Toast
import com.codingalecr.refuel_kotlin.models.MFuelItem
import com.google.firebase.database.*
import java.util.*
import kotlin.collections.ArrayList

/**
 * Created by aulate on 5/1/18.
 */
class FuelItemRepository {

    private val mFuelReference : DatabaseReference? = FirebaseDatabase.getInstance().getReference("refuels")

    var allItems: MutableLiveData<List<MFuelItem>> = MutableLiveData()

    fun getAllFuelItems() : LiveData<List<MFuelItem>> {
        if (allItems.value == null ) {
            val fuelListListener = object : ValueEventListener {
                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    if (dataSnapshot.exists()) {
                        allItems.postValue(toFuelItems(dataSnapshot))
                    }
                }

                override fun onCancelled(databaseError: DatabaseError) {
                    println("loadPost:onCancelled ${databaseError.toException()}")
                }
            }
            mFuelReference?.addValueEventListener(fuelListListener)
        }

        return allItems
    }

    fun toFuelItems (dataSnapshot: DataSnapshot) : List<MFuelItem> {
        val list  = ArrayList<MFuelItem>()
        dataSnapshot.children.mapNotNullTo(list) { it.getValue<MFuelItem>(MFuelItem::class.java) }
        return list
    }

    fun addRefuel(fuel : MFuelItem, listener: DatabaseReference.CompletionListener)  {
        val newRef = mFuelReference?.push()
        fuel.uuid = newRef?.key
        newRef?.setValue(
                fuel,
                listener
        )
    }
}