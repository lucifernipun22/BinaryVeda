package com.nipun.binaryveda.adapter

import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.nipun.binaryveda.R
import com.nipun.binaryveda.data.GridModel

/**
 * This is viewHolder class which is assign in GridImageAdapter class to set the grid view images.
 */
class GridViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bindData(item: GridModel) {
        itemView.apply {
            val image = findViewById<ImageView>(R.id.ivImage)
            item.image?.let { image.setImageResource(it) }
        }
    }
}