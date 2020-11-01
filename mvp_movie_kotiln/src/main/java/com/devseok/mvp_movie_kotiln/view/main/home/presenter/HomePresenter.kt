package com.devseok.mvp_movie_kotiln.view.main.home.presenter

import androidx.annotation.VisibleForTesting
import com.devseok.mvp_movie_kotiln.data.source.movie.MovieRepository
import com.devseok.mvp_movie_kotiln.view.main.home.adapter.model.ImageRecyclerModel

class HomePresenter(
    private val view: HomeContract.View,
    private val movieRepository: MovieRepository,
    @VisibleForTesting val movieRecyclerModel: ImageRecyclerModel
) : HomeContract.Presenter {

    val isLoading = false

    private val perPage = 50
    private var page = 0

    init {
        movieRecyclerModel.onClick = { position ->
            //view.showBottomSheetDialog(movieRecyclerModel.getItem(position)?.id ?: "")
        }
    }


    override fun loadMovieImage() {

    }
}