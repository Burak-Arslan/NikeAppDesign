package com.example.nikedesign

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.bottom_sheet_recycler_item.view.*


class NikeSheetAdapter(private val nikeList: List<NikeResponse>?, private val context: Context) :
    RecyclerView.Adapter<NikeSheetAdapter.NikeViewHolder>() {

    private lateinit var currentItem: List<NikeResponse>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NikeViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.bottom_sheet_recycler_item, parent, false)
        return NikeViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return nikeList?.size!!
    }


    override fun onBindViewHolder(holder: NikeViewHolder, position: Int) {
        try {
            currentItem = listOf(nikeList!![position])

            holder.itemView.imgCell.setBackgroundResource(currentItem[0].image!!)
            holder.itemView.txtPrice.text = currentItem[0].price
            holder.itemView.txtName.text = currentItem[0].imageName

        } catch (e: Exception) {
            e.message?.let { Log.e("NikeAdapterViewMHolder", it) }
        }
    }


    inner class NikeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {

        }
    }

    //  interface OnItemClickListener {
    //      fun onItemClick(currentItem: GeneralFields<NewsResponse>)
    //  }
}