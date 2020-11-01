package com.devseok.mvp_movie_kotiln.view.main.home.adapter.model

import com.devseok.mvp_movie_kotiln.data.MovieResult

interface ImageRecyclerModel {

    fun addItem(movieData: MovieResult?)

    fun  getItem(position: Int): MovieResult?

    fun getItemCount() : Int

    fun notifyDataSetChang()

    var onClick: (Int) -> Unit
}