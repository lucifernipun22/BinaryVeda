package com.nipun.binaryveda.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nipun.binaryveda.R
import com.nipun.binaryveda.data.GridModel

/**
 * This is a adapter class to set the layout of Grid view of gallery image.
 */
class GridImageAdapter(private val list: List<GridModel>, private val context: Context) :
    RecyclerView.Adapter<GridViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GridViewHolder {
        return GridViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.grid_item_layout, parent, false)
        )
    }

    override fun onBindViewHolder(holder: GridViewHolder, position: Int) {
        val GridModel = list[position]
        GridModel?.let { holder.bindData(it) }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}