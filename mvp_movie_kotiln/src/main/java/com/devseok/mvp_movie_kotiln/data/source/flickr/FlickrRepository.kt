package com.devseok.mvp_movie_kotiln.data.source.flickr

import com.devseok.mvp_movie_kotiln.data.PhotoInfo
import com.devseok.mvp_movie_kotiln.data.PhotoResponse
import retrofit2.Call

object FlickrRepository : FlickrDataSource{

    private val flickrRemoteData = FlickrRemoteData()

    override fun getSearchPhoto(keyword: String, page: Int, perPage: Int) =
        flickrRemoteData.getSearchPhoto(keyword, page, perPage)


    override fun getPhotoDetail(photoId: String) =
        flickrRemoteData.getPhotoDetail(photoId)
}