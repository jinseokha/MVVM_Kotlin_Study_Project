package com.devseok.mvp_movie_kotiln.view.main.home.adapter.holder

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.devseok.mvp_movie_kotiln.R
import com.devseok.mvp_movie_kotiln.data.Photo
import kotlinx.android.synthetic.main.item_image_view.view.*

class ImageViewHolder(
    onClick: (Int) -> Unit,
    parent: ViewGroup
) : RecyclerView.ViewHolder(
    LayoutInflater.from(parent.context).inflate(R.layout.item_image_view, parent, false)
){
    init {
        itemView.setOnClickListener {
            onClick(adapterPosition)
        }
    }

    fun onBind(item: Photo?) {
        itemView.onBind(item)
    }

    private fun View.onBind(item: Photo?) {
        img_view.loadImage(item?.getImageUrl())
    }
}