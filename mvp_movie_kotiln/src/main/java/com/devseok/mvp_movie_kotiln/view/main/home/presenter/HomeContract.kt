package com.devseok.mvp_movie_kotiln.view.main.home.presenter

interface HomeContract {

    interface View {
        fun hideProgress()
        fun showProgress()

        fun showLoadFail()
        fun showLoadFail(message: String)

        fun showBottomSheetDialog(movieId: String)
    }

    interface Presenter {
        fun loadMovieImage()
    }
}