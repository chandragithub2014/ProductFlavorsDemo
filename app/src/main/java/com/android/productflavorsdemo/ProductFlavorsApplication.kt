package com.android.productflavorsdemo

import android.app.Application
import android.content.res.Resources



class ProductFlavorsApplication : Application() {

    private val LOG_TAG = "ProductFlavorsApplication"
    companion object {
        lateinit var instance: ProductFlavorsApplication
        lateinit var resources: Resources

    }

    override fun onCreate() {
        super.onCreate()
        instance  = this

    }
}