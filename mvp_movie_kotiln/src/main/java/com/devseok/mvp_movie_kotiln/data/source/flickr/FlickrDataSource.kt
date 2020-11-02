package com.devseok.mvp_movie_kotiln.data.source.flickr

import com.devseok.mvp_movie_kotiln.data.PhotoInfo
import com.devseok.mvp_movie_kotiln.data.PhotoResponse
import retrofit2.Call

interface FlickrDataSource {

    fun getSearchPhoto(keyword: String, page: Int, perPage: Int): Call<PhotoResponse>

    fun getPhotoDetail(photoId: String): Call<PhotoInfo>
}