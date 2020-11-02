package com.devseok.mvp_movie_kotiln.data.source.flickr

import com.devseok.mvp_movie_kotiln.data.PhotoInfo
import com.devseok.mvp_movie_kotiln.data.PhotoResponse
import com.devseok.mvp_movie_kotiln.network.FlickrServiceInterface
import com.devseok.mvp_movie_kotiln.network.createRetrofit
import retrofit2.Call

class FlickrRemoteData : FlickrDataSource {
    companion object {
        const val FLICKR_URL = "https://api.flickr.com/services/rest/"
    }

    private val flickrServiceInterface =
        createRetrofit(FlickrServiceInterface::class.java, FLICKR_URL)

    override fun getSearchPhoto(keyword: String, page: Int, perPage: Int) =
        flickrServiceInterface.getFlickrSearchPhotos(
            keyword = keyword,
            page = page,
            perPage = perPage
        )


    override fun getPhotoDetail(photoId: String): Call<PhotoInfo>  =
        flickrServiceInterface.getFlickrPhotoDetail(photoId)

}