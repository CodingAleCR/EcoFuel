package com.codingalecr.refuel_kotlin.views.adapters

import android.arch.lifecycle.Observer
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.codingalecr.refuel_kotlin.*
import com.codingalecr.refuel_kotlin.models.MFuelItem
import com.codingalecr.refuel_kotlin.views.base.ProgressManager
import kotlinx.android.synthetic.main.fuel_item.view.*

/**
 * Created by aulate on 5/1/18.
 */
class FuelItemListAdapter : RecyclerView.Adapter<FuelItemViewHolder>(), Observer<List<MFuelItem>> {

    private var list :  List<MFuelItem>? = ArrayList()

    override fun onBindViewHolder(holder: FuelItemViewHolder, position: Int) {
        holder.item = list!![position]
        holder.showItem()
    }

    override fun getItemCount(): Int {
        return list!!.size
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): FuelItemViewHolder {
        var view = LayoutInflater.from(parent!!.context).inflate(R.layout.fuel_item, parent, false)
        return FuelItemViewHolder(view)
    }

    override fun onChanged(t: List<MFuelItem>?) {
        list = t
        notifyDataSetChanged()
    }
}

class FuelItemViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
    var item : MFuelItem? = null

    fun showItem() {
        itemView.refuel_date.showDate(item!!.fuelingDate)
        itemView.refuel_kms.showKilometersAbbreviation(item!!.odometer)
        itemView.refuel_cash.showCash(item!!.amountCash)
        itemView.refuel_amount_liters.showLitersAbbreviation(item!!.amountLt)
    }
}