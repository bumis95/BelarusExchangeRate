package com.android.belarusexchangerate.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.belarusexchangerate.R
import com.android.belarusexchangerate.data.model.Bank
import kotlinx.android.synthetic.main.layout_item.view.*

class BankAdapter : RecyclerView.Adapter<BankViewHolder>() {

    private val items = mutableListOf<Bank>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BankViewHolder =
        BankViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.layout_item, parent, false)
        )

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: BankViewHolder, position: Int) {
        holder.bind(items[position])
    }

    fun addItems(newItems: List<Bank>) {
        items.addAll(newItems)
        notifyDataSetChanged()
    }

    fun clearItems() {
        items.clear()
        notifyItemRangeRemoved(0, items.size)
    }
}

class BankViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(bank: Bank) {
        itemView.apply {
            streetView.text = bank.street
            usdInView.text = bank.usd_in.toString()
            usdOutView.text = bank.usd_out.toString()
        }
    }
}