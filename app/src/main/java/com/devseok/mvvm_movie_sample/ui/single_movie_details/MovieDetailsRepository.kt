package com.devseok.mvvm_movie_sample.ui.single_movie_details

import androidx.lifecycle.LiveData
import com.devseok.mvvm_movie_sample.data.api.TheMovieDBInterface
import com.devseok.mvvm_movie_sample.data.repository.MovieDetailsNetworkDataSource
import com.devseok.mvvm_movie_sample.data.repository.NetworkState
import com.devseok.mvvm_movie_sample.data.vo.MovieDetails
import io.reactivex.disposables.CompositeDisposable

class MovieDetailsRepository(private val apiService: TheMovieDBInterface) {

    lateinit var movieDetailsNetworkDataSource: MovieDetailsNetworkDataSource

    fun fetchSingleMovieDetails (compositeDisposable: CompositeDisposable, movieId: Int): LiveData<MovieDetails> {
        movieDetailsNetworkDataSource = MovieDetailsNetworkDataSource(apiService, compositeDisposable)

        movieDetailsNetworkDataSource.fetchMovieDetails(movieId)

        return movieDetailsNetworkDataSource.downloadedMovieResponse
    }

    fun getMovieDetailsNetworkState(): LiveData<NetworkState> {
        return movieDetailsNetworkDataSource.networkState
    }
}