package com.devseok.mvp_movie_kotiln.view.main.home.presenter

import androidx.annotation.VisibleForTesting
import com.devseok.mvp_movie_kotiln.data.PhotoResponse
import com.devseok.mvp_movie_kotiln.data.source.flickr.FlickrRemoteData
import com.devseok.mvp_movie_kotiln.data.source.flickr.FlickrRepository
import com.devseok.mvp_movie_kotiln.view.main.home.adapter.model.ImageRecyclerModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomePresenter(
    private val view: HomeContract.View,
    private val flickrRepository: FlickrRepository,
    @VisibleForTesting val imageRecyclerModel: ImageRecyclerModel
) : HomeContract.Presenter {

    var isLoading = false

    private val perPage = 50
    private var page = 0

    init {
        imageRecyclerModel.onClick = { position ->
            view.showBottomSheetDialog(imageRecyclerModel.getItem(position)?.id ?: "")
        }
    }

    override fun loadMovieImage() {
        isLoading = true
        view.showProgress()

        flickrRepository.getSearchPhoto("Eiffle Tower", ++page, perPage)
            .enqueue(object : Callback<PhotoResponse> {
                override fun onResponse(
                    call: Call<PhotoResponse>,
                    response: Response<PhotoResponse>
                ) {
                    if(response?.isSuccessful == true) {
                        response.body().takeIf { it?.stat == "ok" }?.let {
                            page = it.photos.page

                            it.photos.photo.forEach {
                                imageRecyclerModel.addItem(it)
                            }
                            imageRecyclerModel.notifyDataSetChang()
                        } ?: let {
                            view.showLoadFail("Code ${response.body()?.code} message : ${response.body()?.message}")
                        }
                    } else {
                        view.showLoadFail()
                    }

                    view.hideProgress()

                    isLoading = false
                }

                override fun onFailure(call: Call<PhotoResponse>, t: Throwable) {
                    view.hideProgress()
                    view.showLoadFail()
                    isLoading = false
                }
            })
    }
}