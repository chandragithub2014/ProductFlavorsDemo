package com.android.productflavorsdemo.repository

import com.android.productflavorsdemo.model.PlaceHolderCommentsModel
import com.android.productflavorsdemo.model.PlaceHolderPostsDataModel
import com.android.productflavorsdemo.network.PlaceHolderServiceAPI
import retrofit2.Response

class PlaceHolderRepository(private  val apiServiceAPI: PlaceHolderServiceAPI){
    init {
        println("From Real ")
    }
    fun  displayInfo() = "From Real"
    suspend fun fetchPosts(): Response<PlaceHolderPostsDataModel> = apiServiceAPI.fetchPlaceHolderPosts()
    suspend fun fetchComments(): Response<PlaceHolderCommentsModel> = apiServiceAPI.fetchPlaceHolderComments()
}
