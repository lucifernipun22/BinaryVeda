package com.nipun.binaryveda.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nipun.binaryveda.R
import com.nipun.binaryveda.data.ModelItem

/**
 * MyAdapter is used to set the landing page recyclerview layout.
 */
class MyAdapter(private val list: List<ModelItem>, private val context: Context) :
    RecyclerView.Adapter<MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_layout, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val modelItem = list[position]
        modelItem?.let { holder.bindData(it) }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}