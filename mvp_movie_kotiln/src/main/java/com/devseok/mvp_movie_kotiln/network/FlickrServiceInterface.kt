package com.devseok.mvp_movie_kotiln.network

import com.devseok.mvp_movie_kotiln.data.PhotoInfo
import com.devseok.mvp_movie_kotiln.data.PhotoResponse
import com.devseok.mvvm_movie_sample.BuildConfig
import retrofit2.Call
import retrofit2.http.POST
import retrofit2.http.Query


interface FlickrServiceInterface {
    @POST("?method=flickr.photos.search&api_key=${BuildConfig.FLICKR_API_KEY}&format=json&nojsoncallback=1")
    fun getFlickrSearchPhotos(
        @Query("text") keyword: String,
        @Query("safe_search") safeSearch: Int = 1,
        @Query("page") page: Int,
        @Query("per_page") perPage: Int
    ): Call<PhotoResponse>

    // https://api.flickr.com/services/rest/?method=flickr.photos.getInfo&api_key=9c853da14ec63ea02507f1cf67545b5f&photo_id=37632503954&format=json&nojsoncallback=1&api_sig=7e8fce92b6d4630df35c2e82e542a2d4
    @POST("?method=flickr.photos.getInfo&api_key=${BuildConfig.FLICKR_API_KEY}&format=json&nojsoncallback=1")
    fun getFlickrPhotoDetail(
        @Query("photo_id") photoId: String
    ): Call<PhotoInfo>

}