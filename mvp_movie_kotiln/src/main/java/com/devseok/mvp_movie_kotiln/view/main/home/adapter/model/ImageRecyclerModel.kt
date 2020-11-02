package com.devseok.mvp_movie_kotiln.view.main.home.adapter.model

import com.devseok.mvp_movie_kotiln.data.Photo

interface ImageRecyclerModel {

    fun addItem(movieData: Photo?)

    fun  getItem(position: Int): Photo?

    fun getItemCount() : Int

    fun notifyDataSetChang()

    var onClick: (Int) -> Unit
}