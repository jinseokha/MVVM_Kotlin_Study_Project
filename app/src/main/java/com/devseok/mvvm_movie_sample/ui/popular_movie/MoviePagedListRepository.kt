package com.devseok.mvvm_movie_sample.ui.popular_movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.devseok.mvvm_movie_sample.data.api.POST_PER_PAGE
import com.devseok.mvvm_movie_sample.data.api.TheMovieDBInterface
import com.devseok.mvvm_movie_sample.data.repository.MovieDataSource
import com.devseok.mvvm_movie_sample.data.repository.MovieDataSourceFactory
import com.devseok.mvvm_movie_sample.data.repository.NetworkState
import com.devseok.mvvm_movie_sample.data.vo.Movie
import io.reactivex.disposables.CompositeDisposable

class MoviePagedListRepository(private val apiService: TheMovieDBInterface) {

    lateinit var moviePagedList: LiveData<PagedList<Movie>>
    lateinit var moviesDataSourceFactory: MovieDataSourceFactory

    fun fetchLiveMoviePagedList(compositeDisposable: CompositeDisposable): LiveData<PagedList<Movie>> {
        moviesDataSourceFactory = MovieDataSourceFactory(apiService, compositeDisposable)

        val config: PagedList.Config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setPageSize(POST_PER_PAGE)
            .build()

        moviePagedList = LivePagedListBuilder(moviesDataSourceFactory, config).build()

        return moviePagedList
    }

    fun getNetworkState(): LiveData<NetworkState> {
        return Transformations.switchMap<MovieDataSource, NetworkState> (
            moviesDataSourceFactory.movieLiveDataSource, MovieDataSource::networkState)

    }
}