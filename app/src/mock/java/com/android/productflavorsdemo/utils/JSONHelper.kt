package com.android.productflavorsdemo.utils

import com.android.productflavorsdemo.ProductFlavorsApplication
import com.android.productflavorsdemo.model.PlaceHolderCommentsModel
import com.android.productflavorsdemo.model.PlaceHolderPostsDataModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import retrofit2.Response
import java.lang.reflect.Type

object JSONHelper {
    fun fetchParsedJSONForPosts(): Response<PlaceHolderPostsDataModel> {
        var jsonfile: String = ""
        jsonfile= ProductFlavorsApplication.instance.applicationContext.assets.open("posts.json").bufferedReader().use {it.readText()}

     //   println("Parsed JSON file is.... $jsonfile")
        val gson = Gson()
        val shelfSequenceTypesModelType: Type = object : TypeToken<PlaceHolderPostsDataModel>() {}.type
        var shelfSequenceTypeModel = gson.fromJson<PlaceHolderPostsDataModel>(jsonfile,shelfSequenceTypesModelType)
     //   println("OpenShelfSequenceModel in String ${shelfSequenceTypeModel.toString()}")
        return  Response.success(shelfSequenceTypeModel)
    }

    fun fetchParsedJSONForComments(): Response<PlaceHolderCommentsModel> {
        var jsonfile: String = ""
        jsonfile= ProductFlavorsApplication.instance.applicationContext.assets.open("comments.json").bufferedReader().use {it.readText()}

    //    println("Parsed JSON file is.... $jsonfile")
        val gson = Gson()
        val shelfSequenceTypesModelType: Type = object : TypeToken<PlaceHolderCommentsModel>() {}.type
        var shelfSequenceTypeModel = gson.fromJson<PlaceHolderCommentsModel>(jsonfile,shelfSequenceTypesModelType)
     //   println("OpenShelfSequenceModel in String ${shelfSequenceTypeModel.toString()}")
        return  Response.success(shelfSequenceTypeModel)
    }

}