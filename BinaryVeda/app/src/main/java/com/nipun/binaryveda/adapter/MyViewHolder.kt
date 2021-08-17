package com.nipun.binaryveda.adapter


import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.nipun.binaryveda.data.ModelItem
import kotlinx.android.synthetic.main.item_layout.view.*

/**
 * MyViewHolder class is assign in a MyAdapter class to set the data like image, title and summary
 * of the content which is fetch by my own server.
 */
class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindData(item: ModelItem) {
            itemView.apply {
                //set Image View here
                Glide.with(ivImage).load(item.image).into(ivImage)
                //set title here
                val tvDesc = item.title
                tvTitle.text = tvDesc
                //set summary here
                val Summary = item.summary
                tvSummary.text = Summary
            }
        }
    }