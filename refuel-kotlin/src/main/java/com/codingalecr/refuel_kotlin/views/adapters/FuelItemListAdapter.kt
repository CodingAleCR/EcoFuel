package com.codingalecr.refuel_kotlin.views.adapters

import android.arch.lifecycle.Observer
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.codingalecr.refuel_kotlin.*
import com.codingalecr.refuel_kotlin.models.MFuelItem
import kotlinx.android.synthetic.main.fuel_item.view.*

/**
 * Class adapter
 * Created by aulate on 5/1/18.
 */
class FuelItemListAdapter : RecyclerView.Adapter<FuelItemViewHolder>(), Observer<List<MFuelItem>> {

    private var list: List<MFuelItem>? = ArrayList()
    var listener: ItemClickListener? = null

    override fun onBindViewHolder(holder: FuelItemViewHolder, position: Int) {
        holder.showItem(list!![position])
        listener.run {
            holder.itemView.isClickable = true
            holder.itemView.setOnClickListener({
                this?.clicked(R.id.fuel_list_item, position, false)
            })
        }
    }

    override fun getItemCount(): Int {
        return list!!.size
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): FuelItemViewHolder {
        val view = LayoutInflater.from(parent!!.context).inflate(R.layout.fuel_item, parent, false)
        return FuelItemViewHolder(view)
    }

    override fun onChanged(t: List<MFuelItem>?) {
        list = t
        notifyDataSetChanged()
    }

    fun getItem(position: Int): MFuelItem? {
        if (list!!.isNotEmpty() and (position < list!!.size) and (position > 0)) {
            return list!![position]
        }
        return null
    }
}

class FuelItemViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {

    fun showItem(item: MFuelItem = MFuelItem()) {
        itemView.refuel_date.showDate(item.fuelingDate)
        itemView.refuel_kms.showKilometersAbbreviation(item.odometer)
        itemView.refuel_cash.showCash(item.amountCash)
        itemView.refuel_amount_liters.showLitersAbbreviation(item.amountLt)
    }
}