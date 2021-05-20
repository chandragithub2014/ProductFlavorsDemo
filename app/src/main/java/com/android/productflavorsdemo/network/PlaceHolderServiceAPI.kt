package com.android.productflavorsdemo.network


import com.android.productflavorsdemo.model.PlaceHolderCommentsModel
import com.android.productflavorsdemo.model.PlaceHolderPostsDataModel
import retrofit2.Response
import retrofit2.http.GET


interface PlaceHolderServiceAPI {

    @GET("posts")
   suspend fun fetchPlaceHolderPosts(): Response<PlaceHolderPostsDataModel>


    @GET("comments")
    suspend fun fetchPlaceHolderComments() : Response<PlaceHolderCommentsModel>
}