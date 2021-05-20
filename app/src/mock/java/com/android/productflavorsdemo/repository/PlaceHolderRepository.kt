package com.android.productflavorsdemo.repository

import com.android.productflavorsdemo.model.PlaceHolderCommentsModel
import com.android.productflavorsdemo.model.PlaceHolderPostsDataModel
import com.android.productflavorsdemo.network.PlaceHolderServiceAPI
import com.android.productflavorsdemo.utils.JSONHelper
import retrofit2.Response


class PlaceHolderRepository(private  val apiServiceAPI: PlaceHolderServiceAPI) {
     init {
         println("From Mock ")
     }
     fun  displayInfo() = "From Mock"
     suspend fun fetchPosts(): Response<PlaceHolderPostsDataModel> =  JSONHelper.fetchParsedJSONForPosts()
     suspend fun fetchComments(): Response<PlaceHolderCommentsModel> = JSONHelper.fetchParsedJSONForComments()
}