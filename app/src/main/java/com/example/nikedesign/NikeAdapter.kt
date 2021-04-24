package com.example.nikedesign

import android.content.Context
import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.recycler_item.view.*


class NikeAdapter(private val nikeList: List<NikeResponse>?, private val context: Context) :
    RecyclerView.Adapter<NikeAdapter.NikeViewHolder>() {

    private lateinit var currentItem: List<NikeResponse>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NikeViewHolder {
        val itemView =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.recycler_item, parent, false)
        return NikeViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return nikeList?.size!!
    }


    override fun onBindViewHolder(holder: NikeViewHolder, position: Int) {
        try {
            currentItem = listOf(nikeList!![position])

            val layoutParams: ViewGroup.LayoutParams = holder.itemView.nikeCardview.getLayoutParams()
            layoutParams.height = currentItem[0].size?.toInt()!!

            holder.itemView.nikeCardview.setLayoutParams(layoutParams)
            holder.itemView.nikeCardview.setCardBackgroundColor(Color.parseColor("#3C4147"))
            holder.itemView.imgNike.setBackgroundResource(currentItem[0].image!!)
            holder.itemView.txtName.text = currentItem[0].imageName
            holder.itemView.txtName.isAllCaps = true

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